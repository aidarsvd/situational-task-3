package kg.aidar.techtrack.repositories;

import kg.aidar.techtrack.entities.AlertsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<AlertsEntity, Long> {
}
