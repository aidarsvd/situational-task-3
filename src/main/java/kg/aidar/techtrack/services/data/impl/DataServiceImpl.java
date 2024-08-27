package kg.aidar.techtrack.services.data.impl;

import kg.aidar.techtrack.dto.DataSubmitDto;
import kg.aidar.techtrack.entities.DataEntity;
import kg.aidar.techtrack.repositories.DataRepository;
import kg.aidar.techtrack.repositories.EquipmentRepository;
import kg.aidar.techtrack.services.data.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {

    private final DataRepository dataRepository;
    private final EquipmentRepository equipmentRepository;

    @Override
    public boolean submitData(DataSubmitDto submitDto) {
        DataEntity dataEntity = new DataEntity();
        dataEntity.setRawValue(submitDto.getRawValue());
        dataEntity.setUnit(submitDto.getUnit());
        dataEntity.setDescription(submitDto.getDescription());
        dataEntity.setEquipment(equipmentRepository.findById(submitDto.getEquipmentId()).orElseThrow());
        dataRepository.save(dataEntity);
        return true;
    }
}
