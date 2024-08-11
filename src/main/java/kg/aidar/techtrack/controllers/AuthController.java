package kg.aidar.techtrack.controllers;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import kg.aidar.techtrack.dto.*;
import kg.aidar.techtrack.services.security.SecurityService;
import kg.aidar.techtrack.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trusted/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final SecurityService securityService;

    @PostMapping("/sign-up")
    @Operation(summary = "Signup to system")
    public SuccessDto signUp(@Valid @RequestBody SignUpUserDto signUpUserDto) {
        userService.saveUser(signUpUserDto);
        return SuccessDto.builder().build();
    }

    @PostMapping("/sign-in")
    @Operation(summary = "Signin to system")
    public AuthorizedUserDto signInUser(@Valid @RequestBody AuthorizeUserDto authorizeUserDto) {
        return securityService.authorizeUser(authorizeUserDto);
    }

    @PostMapping("/refresh-token")
    @Operation(summary = "Refresh token system")
    public AuthorizedUserDto refreshToken(@Valid @RequestBody RefreshTokenDto refreshTokenDto) {
        return securityService.refreshToken(refreshTokenDto.getRefreshToken());
    }

}
