package kg.aidar.techtrack.services.user;


import kg.aidar.techtrack.dto.CreateUserDto;
import kg.aidar.techtrack.dto.CreatedUserDto;
import kg.aidar.techtrack.dto.SignUpUserDto;
import kg.aidar.techtrack.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void saveUser(SignUpUserDto signUpUserDto);

    CreatedUserDto saveUser(CreateUserDto createUserDto);

    void assignAuthority(String username, String authority);

    List<UserDto> getUsers();

    void deleteUser(String username);

    boolean isUserEnabled(String username);

    void activate(String username);
}
