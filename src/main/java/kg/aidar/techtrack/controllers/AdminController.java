package kg.aidar.techtrack.controllers;

import jakarta.validation.Valid;
import kg.aidar.techtrack.dto.AssignAuthorityDto;
import kg.aidar.techtrack.dto.CreateUserDto;
import kg.aidar.techtrack.dto.CreatedUserDto;
import kg.aidar.techtrack.dto.SuccessDto;
import kg.aidar.techtrack.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    @PostMapping("/user-create")
    @PreAuthorize("hasAuthority('users.create')")
    public ResponseEntity<CreatedUserDto> createUser(@Valid @RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.ok(userService.saveUser(createUserDto));
    }


    @PostMapping("/assign-authority")
    @PreAuthorize("hasAuthority('users.edit')")
    public ResponseEntity<SuccessDto> assignAuthority(@Valid @RequestBody AssignAuthorityDto assignAuthorityDto) {
        userService.assignAuthority(assignAuthorityDto.getUsername(), assignAuthorityDto.getAuthority());
        return ResponseEntity.ok(SuccessDto.builder().build());
    }

}
