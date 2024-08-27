package kg.aidar.techtrack.services.alert;

import kg.aidar.techtrack.dto.AlertCreateDto;
import kg.aidar.techtrack.dto.AlertDto;

import java.util.List;

public interface AlertService {

    boolean create(AlertCreateDto createDto);

    boolean delete(Long id);

    List<AlertDto> getAlerts();


}
