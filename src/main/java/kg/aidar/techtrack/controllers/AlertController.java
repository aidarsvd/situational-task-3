package kg.aidar.techtrack.controllers;

import jakarta.validation.Valid;
import kg.aidar.techtrack.dto.AlertCreateDto;
import kg.aidar.techtrack.dto.AlertDto;
import kg.aidar.techtrack.dto.SuccessDto;
import kg.aidar.techtrack.services.alert.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trusted/alert")
@RequiredArgsConstructor
public class AlertController {

    private final AlertService alertService;

    @PostMapping("/create")
    public SuccessDto createAlert(@Valid @RequestBody AlertCreateDto dto) {
        return SuccessDto.builder().success(alertService.create(dto)).build();
    }

    @DeleteMapping("/delete/{id}")
    public SuccessDto delete(@PathVariable Long id) {
        return SuccessDto.builder().success(alertService.delete(id)).build();
    }

    @GetMapping("/get-all")
    public List<AlertDto> getAll() {
        return alertService.getAlerts();
    }

}
