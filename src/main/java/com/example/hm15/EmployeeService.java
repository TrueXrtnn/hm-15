package com.example.hm15;

import exception.EmployeeAlreadyAddedException;
import exception.EmployeeNotFoundException;
import exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private static final int MAX_SIZE = 100;
    Map<String, Employee> employeesList = new HashMap(MAX_SIZE);

    public Employee addEmployee(String surname, String name) {
        if (employeesList.size() > MAX_SIZE) throw new EmployeeStorageIsFullException();
        var key = (surname + " " + name).toLowerCase();
        if (employeesList.containsKey(key)) throw new EmployeeAlreadyAddedException();
        Employee employee = new Employee(surname, name);
        employeesList.put(key, employee);
        return employee;
    }

    public Employee findEmployee(String surname, String name) {
        var key = (surname + " " + name).toLowerCase();
        var person = employeesList.get(key);
        if (person!=null) return person;
        else throw new EmployeeNotFoundException();
    }

    public Employee deleteEmployee(String surname, String name) {
        var key = (surname + " " + name).toLowerCase();
        var removed = employeesList.remove(key);
        if (removed==null) throw new EmployeeNotFoundException();
        else return removed;
    }
    public Collection<Employee> getEmployees(){
        return employeesList.values();
    }
}
