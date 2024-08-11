package kg.aidar.techtrack.models;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorityModel implements GrantedAuthority {

    String authority;
    String description;

}
