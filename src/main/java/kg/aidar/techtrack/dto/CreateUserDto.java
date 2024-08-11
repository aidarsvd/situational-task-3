package kg.aidar.techtrack.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateUserDto {

    @NotEmpty(message = "username can not be empty")
    String username;

    @NotEmpty(message = "name can not be empty")
    String name;

}
