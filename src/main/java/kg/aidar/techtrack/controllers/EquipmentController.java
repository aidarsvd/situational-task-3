package kg.aidar.techtrack.controllers;

import jakarta.validation.Valid;
import kg.aidar.techtrack.dto.EquipmentCreateDto;
import kg.aidar.techtrack.dto.EquipmentCreatedDto;
import kg.aidar.techtrack.services.equipment.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('equipment.create')")
    public EquipmentCreatedDto createEquipment(@Valid @RequestBody EquipmentCreateDto equipmentCreateDto) {
        return equipmentService.createEquipment(equipmentCreateDto);
    }

    @GetMapping("/get-list")
    @PreAuthorize("hasAuthority('equipment.read')")
    public List<EquipmentCreatedDto> getList(@RequestParam(required = false, value = "s") String search) {
        return equipmentService.getList(search);
    }

}
