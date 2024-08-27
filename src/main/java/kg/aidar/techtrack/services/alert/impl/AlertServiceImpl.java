package kg.aidar.techtrack.services.alert.impl;

import kg.aidar.techtrack.dto.AlertCreateDto;
import kg.aidar.techtrack.dto.AlertDto;
import kg.aidar.techtrack.entities.AlertsEntity;
import kg.aidar.techtrack.repositories.AlertRepository;
import kg.aidar.techtrack.repositories.EquipmentRepository;
import kg.aidar.techtrack.services.alert.AlertService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlertServiceImpl implements AlertService {

    private final AlertRepository alertRepository;
    private final EquipmentRepository equipmentRepository;

    @Override
    public boolean create(AlertCreateDto dto) {
        AlertsEntity alertsEntity = new AlertsEntity();
        alertsEntity.setAlertMessage(dto.getAlertMessage());
        alertsEntity.setEquipment(equipmentRepository.findById(dto.getEquipmentId()).orElseThrow());
        alertsEntity.setPriority(dto.getPriority());
        alertRepository.save(alertsEntity);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        alertRepository.deleteById(id);
        return true;
    }

    @Override
    public List<AlertDto> getAlerts() {
        return alertRepository.findAll().stream().map(e -> new AlertDto(e.getId(), e.getAlertMessage(), e.getPriority(), e.getEquipment().getId(), e.getTimestamp())).toList();
    }
}
