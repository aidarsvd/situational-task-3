package kg.aidar.techtrack.controllers;

import jakarta.validation.Valid;
import kg.aidar.techtrack.dto.*;
import kg.aidar.techtrack.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/get-users")
    @PreAuthorize("hasAuthority('users.read')")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping("/delete-user")
    @PreAuthorize("hasAuthority('users.delete')")
    public ResponseEntity<SuccessDto> deleteUser(@RequestParam("username") String username) {
        userService.deleteUser(username);
        return ResponseEntity.ok(SuccessDto.builder().build());
    }

    @PostMapping("/activate-user")
    @PreAuthorize("hasAuthority('users.edit')")
    public ResponseEntity<SuccessDto> activateUser(@RequestParam("username") String username) {
        userService.activate(username);
        return ResponseEntity.ok(SuccessDto.builder().build());
    }

}
