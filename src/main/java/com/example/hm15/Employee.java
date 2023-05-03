package com.example.hm15;

import java.util.Objects;

public class Employee { // класс для создания объекта работник

    private String surname;
    private String name;


    public Employee(String surname, String name){
        this.surname= surname;
        this.name=name;

    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return surname.equals(employee.surname) && name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name);
    }

    @Override
    public String toString() {
        return "Emploee{" +
                "Фамилия='" + surname + '\'' +
                ", Имя='" + name + '\'' + '}';
    }


}