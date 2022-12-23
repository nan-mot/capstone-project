package com.stroimvmeste.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExitController {

    private final ApplicationContext context;

    @GetMapping("/exit")
    public void exit() {
        int exitCode = SpringApplication.exit(context, () -> 0);
        System.exit(exitCode);
    }
}
