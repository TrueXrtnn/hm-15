package service;

import com.example.hm15.Employee;
import exception.EmployeeAlreadyAddedException;
import exception.EmployeeNotFoundException;
import exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class EmployeeService {
    private static final int MAX_SIZE = 100;
    Map<String, Employee> employeesList = new HashMap(MAX_SIZE);
    String[] departments = new String[]{"1", "2", "3", "4", "5"};

    public Employee addEmployee(String surname, String name, String patronymic, int departmentId, int salary) {
        if (employeesList.size() > MAX_SIZE) throw new EmployeeStorageIsFullException();
        var key = (surname + " " + name+ " "+patronymic).toLowerCase();
        if (employeesList.containsKey(key)) throw new EmployeeAlreadyAddedException();
        Employee employee = new Employee(surname, name, patronymic, departmentId, salary);
        employeesList.put(key, employee);
        return employee;
    }

    public Employee findEmployee(String surname, String name) {
        var key = (surname + " " + name).toLowerCase();
        var person = employeesList.get(key);
        if (person != null) return person;
        else throw new EmployeeNotFoundException();
    }

    public Employee deleteEmployee(String surname, String name) {
        var key = (surname + " " + name).toLowerCase();
        var removed = employeesList.remove(key);
        if (removed == null) throw new EmployeeNotFoundException();
        else return removed;
    }

    public Collection<Employee> getEmployees() {
        return employeesList.values();
    }

   // public String validateInput(String name, String surname) {
    //    return StringUtils.isAlpha(name) && StringUtils.isAlpha(surname);
    //}
}
