package kg.aidar.techtrack.services.user;


import kg.aidar.techtrack.dto.SignUpUserDto;
import kg.aidar.techtrack.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void saveUser(SignUpUserDto signUpUserDto);

    boolean isUserExists(String username);

    UserDto getProfile();

}
