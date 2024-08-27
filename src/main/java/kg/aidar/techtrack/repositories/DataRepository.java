package kg.aidar.techtrack.repositories;

import kg.aidar.techtrack.entities.DataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<DataEntity, Long> {

}
