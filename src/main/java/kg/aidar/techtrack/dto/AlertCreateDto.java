package kg.aidar.techtrack.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import kg.aidar.techtrack.enums.AlertPriority;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AlertCreateDto {

    String alertMessage;

    AlertPriority priority;

    Long equipmentId;

}
