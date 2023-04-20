package com.example.ExtractAndMapData.Controller;

import com.example.ExtractAndMapData.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Execution {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/do-something")
    public void doSomething() throws IOException {
        employeeService.exportToCSV();
        employeeService.main();

    }

}
