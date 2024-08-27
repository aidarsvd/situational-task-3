package kg.aidar.techtrack.controllers;

import jakarta.validation.Valid;
import kg.aidar.techtrack.dto.DataSubmitDto;
import kg.aidar.techtrack.dto.SuccessDto;
import kg.aidar.techtrack.services.data.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
public class DataController {

    private final DataService dataService;

    @PostMapping("/submit")
    public SuccessDto submitData(@RequestBody @Valid DataSubmitDto submitDto) {
        return SuccessDto.builder().success(dataService.submitData(submitDto)).build();
    }

}
