package kg.aidar.techtrack.models;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppUserDetails implements UserDetails {

    Long id;

    String username;

    String name;

    String password;

    List<AuthorityModel> authorities;

    boolean isEnabled;

    LocalDateTime createdAt;

    @Override
    public boolean isAccountNonExpired() {
        return this.isEnabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isEnabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isEnabled;
    }

}
