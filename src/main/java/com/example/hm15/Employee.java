package com.example.hm15;

import java.util.Objects;

public class Employee {
    private static int number;
    private final int id;
    private String surname;
    private String name;
    private String patronymic;
    private String department;
    private String fullName;
    private int salary;
    private int departmentId;


    public Employee(String surname, String name, String patronymic, int departmentId, int salary) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.salary = salary;
        this.departmentId = departmentId;
        number++;
        this.fullName = surname + " " + name + " " + patronymic;
        this.id = getNumber();
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return departmentId;
    }

    public int getSalary() {
        return salary;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emploee{" + "Фамилия='" + surname + '\'' + ", Имя='" + name + '\'' + ", Отчество='" + patronymic + '\'' + ", Отдел='" + department + '\'' + ", Зарплата=" + salary + '}';
    }

    private int getNumber() {
        return number;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && salary == employee.salary && departmentId == employee.departmentId && surname.equals(employee.surname) && name.equals(employee.name) && patronymic.equals(employee.patronymic) && department.equals(employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, patronymic, department, salary, departmentId);
    }
}