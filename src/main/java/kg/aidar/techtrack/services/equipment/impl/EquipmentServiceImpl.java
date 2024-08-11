package kg.aidar.techtrack.services.equipment.impl;

import kg.aidar.techtrack.dto.EquipmentCreateDto;
import kg.aidar.techtrack.dto.EquipmentCreatedDto;
import kg.aidar.techtrack.entities.EquipmentEntity;
import kg.aidar.techtrack.models.AppUserDetails;
import kg.aidar.techtrack.repositories.EquipmentRepository;
import kg.aidar.techtrack.repositories.UserRepository;
import kg.aidar.techtrack.services.equipment.EquipmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final UserRepository userRepository;

    @Override
    public EquipmentCreatedDto createEquipment(EquipmentCreateDto equipmentCreateDto) {
        AppUserDetails user = (AppUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        EquipmentEntity equipment = new EquipmentEntity(
                null,
                LocalDateTime.now(),
                equipmentCreateDto.getModel(),
                userRepository.findByUsername(user.getUsername()).get()
        );
        EquipmentEntity save = equipmentRepository.save(equipment);
        return EquipmentCreatedDto.builder()
                .id(save.getId())
                .installationDate(save.getInstallationDate())
                .model(save.getModel())
                .build();
    }

    @Override
    public List<EquipmentCreatedDto> getList(String model) {
        if (model != null) {
            return equipmentRepository.findByModel(model).stream().map(e -> new EquipmentCreatedDto(e.getId(), e.getInstallationDate(), e.getModel())).toList();
        } else {
            return equipmentRepository.findAll().stream().map(e -> new EquipmentCreatedDto(e.getId(), e.getInstallationDate(), e.getModel())).toList();
        }
    }
}
