package kg.aidar.techtrack.entities;

import jakarta.persistence.*;
import kg.aidar.techtrack.enums.AlertPriority;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "tech_track_alerts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AlertsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(columnDefinition = "TEXT")
    String alertMessage;

    @Enumerated(EnumType.STRING)
    AlertPriority priority;

    @ManyToOne
    EquipmentEntity equipment;

    LocalDateTime timestamp;

    @PrePersist
    private void init(){
        this.timestamp = LocalDateTime.now();
    }

}
