package kg.aidar.techtrack.factories;


import kg.aidar.techtrack.enums.JwtServiceChannel;
import kg.aidar.techtrack.services.jwt.JwtService;

public interface JwtServiceFactory {
    JwtService defineJwtService(JwtServiceChannel jwtServiceChannel);
}
