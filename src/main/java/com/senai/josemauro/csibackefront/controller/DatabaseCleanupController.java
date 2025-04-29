package com.senai.josemauro.csibackefront.controller;

import com.senai.josemauro.csibackefront.service.DatabaseCleanupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class DatabaseCleanupController {

    @Autowired
    private DatabaseCleanupService databaseCleanupService;

    @DeleteMapping("/limpar-banco")
    public String limparBanco() {
        databaseCleanupService.limparDados();
        return "Todos os dados foram apagados!";
    }

}
