package kg.aidar.techtrack.services.user.impl;


import kg.aidar.techtrack.dto.SignUpUserDto;
import kg.aidar.techtrack.dto.UserDto;
import kg.aidar.techtrack.entities.UserEntity;
import kg.aidar.techtrack.exceptions.ApiException;
import kg.aidar.techtrack.models.AppUserDetails;
import kg.aidar.techtrack.models.AuthorityModel;
import kg.aidar.techtrack.repositories.UserRepository;
import kg.aidar.techtrack.services.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(u -> new AppUserDetails(
                                u.getId(),
                                u.getUsername(),
                                u.getName(),
                                u.getPassword(),
                                u.getAuthorities().stream().map(a -> new AuthorityModel(a.getName(), a.getDescription())).toList(),
                                u.isEnabled(),
                                u.getCreatedAt()
                        )
                )
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }

    @Override
    public void saveUser(SignUpUserDto userDto) {
        log.info("Sign up user: {}", userDto.getUsername());
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userEntity.setEnabled(true);
        try {
            userRepository.save(userEntity);
            log.info("User: {} is signed up", userDto.getUsername());
        } catch (DataIntegrityViolationException e) {
            log.error("Exception when user saving", e);
            throw new ApiException(e);
        } catch (Exception e) {
            log.error("Unknown exception when user saving", e);
            throw new ApiException(e);
        }
    }


    @Override
    public boolean isUserExists(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public UserDto getProfile() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        UserEntity user = userRepository.findByUsername(((AppUserDetails) authentication.getPrincipal()).getUsername()).orElseThrow();
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .build();
    }
}
