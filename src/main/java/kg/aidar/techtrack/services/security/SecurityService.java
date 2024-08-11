package kg.aidar.techtrack.services.security;


import kg.aidar.techtrack.dto.AuthorizeUserDto;
import kg.aidar.techtrack.dto.AuthorizedUserDto;

public interface SecurityService {

    AuthorizedUserDto authorizeUser(AuthorizeUserDto authorizeUserDto);

    AuthorizedUserDto refreshToken(String refreshToken);

}
