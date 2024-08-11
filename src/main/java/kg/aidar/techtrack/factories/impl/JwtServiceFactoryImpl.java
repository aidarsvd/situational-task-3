package kg.aidar.techtrack.factories.impl;




import kg.aidar.techtrack.enums.JwtServiceChannel;
import kg.aidar.techtrack.factories.JwtServiceFactory;
import kg.aidar.techtrack.services.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class JwtServiceFactoryImpl implements JwtServiceFactory {

    private final Map<JwtServiceChannel, JwtService> jwtServicesMap;

    @Autowired
    public JwtServiceFactoryImpl(List<JwtService> jwtServices) {
        this.jwtServicesMap = jwtServices.stream().collect(Collectors.toUnmodifiableMap(JwtService::defineChannel, Function.identity()));
    }

    @Override
    public JwtService defineJwtService(JwtServiceChannel jwtServiceChannel) {
        return Optional.ofNullable(jwtServicesMap.get(jwtServiceChannel)).orElseThrow(IllegalArgumentException::new);
    }
}
