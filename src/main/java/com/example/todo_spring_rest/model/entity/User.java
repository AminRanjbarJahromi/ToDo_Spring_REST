package com.example.todo_spring_rest.model.entity;

import com.example.todo_spring_rest.exception.DataDuplicateException;
import com.example.todo_spring_rest.exception.DataNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")

public class User {
    @Id
    @Column(updatable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    private boolean expired;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "user_roles", joinColumns = {@JoinColumn(name="USERNAME")},
    inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})

    private Set<Role> roles = new HashSet<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void addRole(Role role){
        if(roles.contains(role)){
            throw new DataDuplicateException("Duplicate Error");
        }
        roles.add(role);
    }

    public void removeRole(Role role){

        if(!roles.contains(role)){
            throw new DataNotFoundException("Data Not Found Error");
        }
        roles.remove(role);
    }
}
