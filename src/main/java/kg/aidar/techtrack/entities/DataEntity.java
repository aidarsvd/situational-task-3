package kg.aidar.techtrack.entities;

import jakarta.persistence.*;
import kg.aidar.techtrack.enums.AlertPriority;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "tech_track_data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(columnDefinition = "TEXT")
    String rawValue;

    String unit;

    @Column(columnDefinition = "TEXT")
    String description;

    LocalDateTime timestamp;

    @ManyToOne
    EquipmentEntity equipment;

    @PrePersist
    private void init() {
        this.timestamp = LocalDateTime.now();
    }

}
