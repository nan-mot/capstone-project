package com.stroimvmeste.backend.controller;

import com.stroimvmeste.backend.dto.ExpertDto;
import com.stroimvmeste.backend.dto.UserLiteDto;
import com.stroimvmeste.backend.controller.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/createUser")
    public UserLiteDto createUser(@RequestBody UserLiteDto userLiteDto) {
        return userService.addUser(userLiteDto);
    }

    @PostMapping("/createExpert")
    public ExpertDto createExpert(@RequestBody ExpertDto expertDto) {
        return userService.addExpert(expertDto);
    }

    @GetMapping("/all")
    public List<UserLiteDto> viewAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserLiteDto viewUser(@PathVariable Long id) {
        return userService.getUser(id).get();
    }
}
