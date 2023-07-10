package com.example.hm15;

import exception.EmployeeStorageIsFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.EmployeeService;


import static com.example.hm15.Constants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

public class EmployeeServiceTest {
    private final EmployeeService employeeService = new EmployeeService();

    @BeforeEach
    public void setUp() {
        /**создаем сотрудника в мапе с заданными параметрами, он будет expected*/
        employeeService.addEmployee(FULL_NAME_1, SALARY_1, DEPARTMENT_1);
    }

    @Test
    public void getEmployees() {
        /**сотрудник добавлен через beforeEach */
        /**т.к. сотрудник добавлен проверяем что мапа не пустая*/
        assertNotNull(employeeService.getEmployees());
        /**сравниваю ожидаемого сотрудника и сотрудника из коллекции*/
        assertEquals(FULL_NAME_1, employeeService.getEmployees().get(FULL_NAME_1).getFullName());
        /**сравниваю ожидаемую зарплату сотрудника и зарплату соответствующего сотрудника из коллекции*/
        assertEquals(SALARY_1, employeeService.getEmployees().get(FULL_NAME_1).getSalary());
        /**сравниваю ожидаемый отдел сотрудника и отдел соответствующего сотрудника из коллекции*/
        assertEquals(DEPARTMENT_1, employeeService.getEmployees().get(FULL_NAME_1).getDept());
    }



    @Test
    public void addEmployeeTest() {
        /**сотрудник добавлен через beforeEach */
        /**получаю сотрудника из коллекции и проверяю есть ли в ней соответствующий ключ*/
        assertTrue(employeeService.getEmployees().containsKey(FULL_NAME_1));
        /**получаю сотрудника из коллекции и проверяю есть ли в ней соответствующий сотрудник*/
        assertTrue(employeeService.getEmployees().containsValue(EMPLOYEE1));
        /**сравниваю ожидаемого сотрудника и сотрудника из коллекции*/
        assertEquals(EMPLOYEE1, employeeService.getEmployees().get(FULL_NAME_1));
        /**сравниваю ожидаемое имя сотрудника и имя соответствующего сотрудника из коллекции*/
        assertEquals(FULL_NAME_1, employeeService.getEmployees().get(FULL_NAME_1).getFullName());
        /**сравниваю ожидаемую зарплату сотрудника и зарплату соответствующего сотрудника из коллекции*/
        assertEquals(SALARY_1, employeeService.getEmployees().get(FULL_NAME_1).getSalary());
        /**сравниваю ожидаемый отдел сотрудника и отдел соответствующего сотрудника из коллекции*/
        assertEquals(DEPARTMENT_1, employeeService.getEmployees().get(FULL_NAME_1).getDept());
    }

    @Test
    public void addEmployeeTestException() {
        /**заполняем мапу до предела*/
        int keyCounter = 0;
        String keyFullName = "Имя";
        for (int i = 0; i < 20; i++) {
            keyCounter++;
            keyFullName += keyCounter;
            employeeService.getEmployees().put(keyFullName, new Employee(keyFullName, SALARY_1, DEPARTMENT_1));
        }
        /**проверяем метод на выброс исключения*/
        assertThrows(EmployeeStorageIsFullException.class, () -> employeeService.addEmployee(FULL_NAME_2, SALARY_2, DEPARTMENT_2));
    }

    @Test
    public void removeEmployee() {
        /**сотрудник добавлен через beforeEach */
        /**получаю TRUE если в мапе есть соответствующий ключ*/
        assertTrue(employeeService.getEmployees().containsKey(FULL_NAME_1));
        /**удаляю сотрудника из мапы*/
        employeeService.removeEmployee(FULL_NAME_1);
        /**получаю FALSE если в мапе не найдено соответствующего ключа*/
        assertFalse(employeeService.getEmployees().containsKey(FULL_NAME_1));

    }

    @Test
    public void changeEmployee() {
        /**сотрудник добавлен через beforeEach */
        /**проверяю количество сотрудников в мапе: ожидаемое 11 чел*/
        assertEquals(11, employeeService.getEmployees().size());
        /**проверяю что в мапу добавился именно тот сотрудник из BeforeEach с FULL_NAME1*/
        assertTrue(employeeService.getEmployees().containsKey(FULL_NAME_1));
        /**использую метод changeEmployee, чтобы изменить сотрудника в мапе*/
        employeeService.changeEmployee(FULL_NAME_1, FULL_NAME_2, SALARY_2, DEPARTMENT_2);
        /**получаю FALSE если добавленного ранее сотрудника нет в мапе, то есть сотрудник удален*/
        assertFalse(employeeService.getEmployees().containsKey(FULL_NAME_1));
        /**проверяю что в мапу добавился именно сотрудник с FULL_NAME2*/
        assertTrue(employeeService.getEmployees().containsKey(FULL_NAME_2));
        /**Должно остаться столько же сотрудников сколько и было: ожидаемое 11 чел. */
        assertEquals(11, employeeService.getEmployees().size());
    }

    @Test
    public void printEmployeeTest() {
        String expected = "- Карчемный Владимир Георгиевич, зарплата: 72000, отдел: 1\n";
        String expected1 = "- Петрова Елена Павловна, зарплата: 87000, отдел: 2\n";
        String expected2 = "- Скворцов Сергей Денисович, зарплата: 63000, отдел: 4\n";
        String expected3 = "- Александров Михаил Богданович, зарплата: 99000, отдел: 2\n";
        String expected4 = "- Юницин Сергей Михайлович, зарплата: 76000, отдел: 5\n";
        String expected5 = "- Васильев Денис Андреевич, зарплата: 65000, отдел: 1\n";
        String expected6 = "- Лянге Александр Григорьевич, зарплата: 90000, отдел: 3\n";
        String expected7 = "- Попова Варвара Богдановна, зарплата: 85000, отдел: 5\n";
        String expected8 = "- Кузнцов Александр Семенович, зарплата: 67000, отдел: 4\n";
        String expected9 = "- Рыбкин Данил Амвросиевич, зарплата: 75000, отдел: 3\n";
        String expected10 = "- Иванов Иван Иванович, зарплата: 200000, отдел: 1\n";

        StringBuilder actual = employeeService.printEmployees();

        assertTrue(actual.toString().contains(expected));
        assertTrue(actual.toString().contains(expected1));
        assertTrue(actual.toString().contains(expected2));
        assertTrue(actual.toString().contains(expected3));
        assertTrue(actual.toString().contains(expected4));
        assertTrue(actual.toString().contains(expected5));
        assertTrue(actual.toString().contains(expected6));
        assertTrue(actual.toString().contains(expected7));
        assertTrue(actual.toString().contains(expected8));
        assertTrue(actual.toString().contains(expected9));
        assertTrue(actual.toString().contains(expected10));
    }
}