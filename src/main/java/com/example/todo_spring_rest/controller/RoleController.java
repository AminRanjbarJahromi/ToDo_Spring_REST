package com.example.todo_spring_rest.controller;

import com.example.todo_spring_rest.model.dto.RoleDto;
import com.example.todo_spring_rest.model.entity.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

        //1. for @GetMapping ----->  http://localhost:8080/api/v1/role/
        // ResponseEntity has a convert role to convert Jason message

    @GetMapping("/")
    public ResponseEntity<List<RoleDto>>  getAll(){
        List<RoleDto> roles = new ArrayList<>();
        roles.add(new RoleDto(1,"ADMIN"));
        roles.add(new RoleDto(2,"USER"));
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> findById(@PathVariable("id")  Integer id){

        RoleDto result = new RoleDto(id,"Amin R");
        return ResponseEntity.ok(result);
    }
}
