package com.example.hm15;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/employee")
@RestController
@ResponseStatus
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String name, @RequestParam String surname) {
        return employeeService.addEmployee(surname, name);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String name, @RequestParam String surname) {
        return employeeService.deleteEmployee(surname, name);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam String name, @RequestParam String surname){
    return employeeService.findEmployee(surname,name);
    }
}


