package ru.Goncharov.Sem_7_Spring_Security.api;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/resource")
public class ResourceController {

    @GetMapping
    public String resource() {
        return "Resource";
    }

    @GetMapping("/user")
    @Secured("user")
    //@PreAuthorize("hasAuthority('user')")
    public String user() {
        return "User";
    }

    @GetMapping("/admin")
    @Secured("admin")
    //@PreAuthorize("hasAuthority('admin')")
    public String admin() {
        return "Admin";
    }

    @GetMapping("/auth")
    public String auth() {
        return "Authorized";
    }
}