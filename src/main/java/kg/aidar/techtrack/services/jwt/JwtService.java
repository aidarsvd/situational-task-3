package kg.aidar.techtrack.services.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import kg.aidar.techtrack.enums.JwtServiceChannel;

public interface JwtService {

    String generateJwtToken(String username);

    DecodedJWT decodeAndValidateToken(String token) throws Exception;

    JwtServiceChannel defineChannel();

}
