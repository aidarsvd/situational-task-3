package kg.aidar.techtrack.services.equipment;

import kg.aidar.techtrack.dto.EquipmentCreateDto;
import kg.aidar.techtrack.dto.EquipmentCreatedDto;

import java.util.List;

public interface EquipmentService {

    EquipmentCreatedDto createEquipment(EquipmentCreateDto equipmentCreateDto);

    List<EquipmentCreatedDto> getList(String model);

    boolean deleteEquipment(Long id);
}
