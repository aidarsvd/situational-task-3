package kg.aidar.techtrack.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataSubmitDto {

    @NotEmpty
    String rawValue;

    @NotEmpty
    String unit;

    String description;

    @NotNull
    Long equipmentId;

}
