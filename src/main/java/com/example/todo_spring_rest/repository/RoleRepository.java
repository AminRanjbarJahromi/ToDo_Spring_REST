package com.example.todo_spring_rest.repository;

import com.example.todo_spring_rest.model.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;



public interface RoleRepository extends CrudRepository<Role, Integer> {

    Optional<Role> findByName(String name);

    List<Role> findAllByOrderByIdDesc();

}
