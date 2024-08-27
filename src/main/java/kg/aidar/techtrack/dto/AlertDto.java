package kg.aidar.techtrack.dto;

import kg.aidar.techtrack.enums.AlertPriority;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AlertDto {

    Long id;

    String alertMessage;

    AlertPriority priority;

    Long equipmentId;

    LocalDateTime timestamp;

}