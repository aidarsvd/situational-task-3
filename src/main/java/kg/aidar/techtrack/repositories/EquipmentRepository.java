package kg.aidar.techtrack.repositories;

import kg.aidar.techtrack.entities.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<EquipmentEntity, Long> {

    List<EquipmentEntity> findByModel(String model);

}
