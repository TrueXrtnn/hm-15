package com.example.hm15;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    List<Employee> employeesList = new ArrayList<>();

    public EmployeeService() {

    }

    public Employee addEmployee(String surname, String name) {
        Employee employee = new Employee(surname, name);
        for (int i = 0; i < employeesList.size(); i++) {
            if (surname.equals(employeesList.get(i).getSurname()) && name.equals(employeesList.get(i).getName())) {
                throw new EmployeeAlreadyAddedException();
            }
        }
        employeesList.add(employee);
        return employee;
    }

    public Employee findEmployee(String surname, String name) {
        for (int i = 0; i < employeesList.size(); i++) {
            if (surname.equals(employeesList.get(i).getSurname()) && name.equals(employeesList.get(i).getName())) {
                return employeesList.get(i);
            }
        }
        throw new EmployeeNotFoundException();
    }

    public Employee deleteEmployee(String surname, String name) {
        employeesList.remove(findEmployee(surname, name));
        Employee employee = new Employee(surname, name);
        return employee;
    }
}
