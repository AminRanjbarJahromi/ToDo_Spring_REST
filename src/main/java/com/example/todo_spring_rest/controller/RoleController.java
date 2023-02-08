package com.example.todo_spring_rest.controller;

import com.example.todo_spring_rest.model.entity.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class RoleController {

        //1. for @GetMapping ----->  http:// localhost:9090/api/v1/roles/
        // ResponseEntity has a convert role to convert Jason message
    @GetMapping(" api/v1/roles/")

    public ResponseEntity<List<Role>>  getAll(){
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(1,"ADMIN"));
        roles.add(new Role(2,"USER"));
        return ResponseEntity.ok(roles);
    }
}
