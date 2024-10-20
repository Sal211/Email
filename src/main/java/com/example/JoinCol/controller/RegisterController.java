package com.example.JoinCol.controller;

import com.example.JoinCol.entity.Registers;
import com.example.JoinCol.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    RegisterRepository repository;

    @GetMapping("/reg")
    public Registers getReg(){
        Registers registers = repository.findById(1).orElse(null);
        return registers;
    }
}
