package com.projectmanagement.manage.Controller;

import com.projectmanagement.manage.Model.AppUser;
import com.projectmanagement.manage.Service.AppUserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AppUserController {

    private final AppUserServiceImpl appUserService;

    @GetMapping("/users")
    public ResponseEntity getAllUsers(){
        return ResponseEntity.ok().body(appUserService.getAllUsers());
    }

    @PostMapping("/save/user")
    public void saveAppUser(@RequestBody AppUser appUser){
        appUserService.saveAppUser(appUser);
    }
}
