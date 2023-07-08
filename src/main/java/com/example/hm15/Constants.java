package com.example.hm15;


import java.util.*;

public class Constants {
    public final static String NAME_1 = "Иван";
    public final static String SURNAME_1 = "Иванов";
    public final static String PATRONYMIC_1 = "Иванович";
    public final static String NAME_2 = "Петр";
    public final static String SURNAME_2 = "Петров";
    public final static String PATRONYMIC_2 = "Птрович";
    public final static String FULL_NAME_1 = "Иванов Иван Иванович";
    public final static String FULL_NAME_2 = "Петров Петр Петрович";
    public final static Integer SALARY_1 = 200_000;
    public final static Integer SALARY_2 = 190_000;
    public final static Integer DEPARTMENT_1 = 1;
    public final static Integer DEPARTMENT_2 = 2;
    public final static Employee EMPLOYEE1 = new Employee(SURNAME_1, NAME_1, PATRONYMIC_1, SALARY_1, DEPARTMENT_1);
    public final static Employee EMPLOYEE2 = new Employee(SURNAME_2, NAME_2, PATRONYMIC_2, SALARY_2, DEPARTMENT_2);

    public final static List<Employee> LIST1_EXP = new ArrayList<>(List.of(
            new Employee("Васильев", "Денис", "Андреевич", 1, 65_000),
            new Employee("Иванович", "Дмитрий", "Васильевич", 1, 72_000),
            ));
    public final static List<Employee> LIST2_EXP = new ArrayList<>(List.of(
            new Employee("Александров", "Михаил", "Богданович", 2, 99_000),
            new Employee("Петрова", "Елена", "Павловна", 2, 87_000)
    ));

    public final static List<Employee> LIST3_EXP = new ArrayList<>(List.of(
            new Employee("Лянге", "Александр", "Григорьевич", 3, 90_000),
            new Employee("Рыбкин", "Данил", "Амвросиевич", 3, 75_000)
    ));

    public final static List<Employee> LIST4_EXP = new ArrayList<>(List.of(
            new Employee("Скворцов", "Сергей", "Денисович", 4, 63_000),
            new Employee("Кузнцов", "Александр", "Семенович", 4, 67_000)
    ));

    public final static List<Employee> LIST5_EXP = new ArrayList<>(List.of(
            new Employee("Попова", "Варвара", "Богдановна", 5, 85_000),
            new Employee("Юницин", "Сергей", "Михайлович", 5, 76_000)
    ));
    public final static Map<String, Employee> EMPLOYEE_MAP_MOCK_TEST = new LinkedHashMap<>(Map.of(
            "Попова Варвара Богдановна",
            new Employee("Попова", "Варвара", "Богдановна", 5, 85_000),
            "Петрова Елена Павловна",
            new Employee("Петрова", "Елена", "Павловна", 2, 87_000),
            "Васильев Денис Андреевич",
            new Employee("Васильев", "Денис", "Андреевич", 1, 65_000),
            "Лянге Александр Григорьевич",
            new Employee("Лянге", "Александр", "Григорьевич", 3, 90_000),
            "Кузнецов Александр Семенович",
            new Employee("Кузнцов", "Александр", "Семенович", 4, 67_000),
            "Скворцов Сергей Денисович",
            new Employee("Скворцов", "Сергей", "Денисович", 4, 63_000),
            "Александров Михаил Богданович",
            new Employee("Александров", "Михаил", "Богданович", 2, 99_000),
            "Карчемный Владимир Георгиевич",
            new Employee("Карчемный", "Владимир", "Георгиевич", 1, 72_000),
            "Юницин Сергей Михайлович",
            new Employee("Юницин", "Сергей", "Михайлович", 5, 76_000),
            "Рыбкин Данил Амвросиевич",
            new Employee("Рыбкин", "Данил", "Амвросиевич", 3, 75_000)
    ));

}
