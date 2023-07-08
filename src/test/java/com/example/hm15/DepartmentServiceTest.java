package com.example.hm15;


import exception.EmployeeNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import service.DepartmentService;
import service.EmployeeService;

import java.util.*;

import static com.example.hm15.Constants.EMPLOYEE_MAP_MOCK_TEST;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private EmployeeService emplServ;
    private DepartmentService deptServ;

    @BeforeEach
    public void BeforeEach() {
        deptServ = new DepartmentService(emplServ);
    }

    @Test
    public void getEmployeeByDeptTest() {
        /**делаю заглушку для метода*/
        Mockito.when(emplServ.getEmployees()).thenReturn(EMPLOYEE_MAP_MOCK_TEST);

        int deptNum = 1; //номер отдела

        /**верхний цикл while перебирает номера отделов*/
        while (deptNum <= 5) {
            int employeesCounter = 0; //счетчик суммирует сотрудников в листе
            /**список куда попадают сотрудники сортированные по отделу*/
            List<Employee> employeeListTest = new ArrayList<>(deptServ.allDepartment(deptNum));

            /**цикл for проходит по сотрудникам в списке...*/
            for (int i = 0; i < employeeListTest.size(); i++) {
                /**...получает номер отдела каждого сотрудника*/
                int actual = employeeListTest.get(0).getDepartment();
                /**...и сравнивает номер отдела deptNum(expected) с полученным actual для каждого сотрудника*/
                assertEquals(deptNum, actual);
                /**увеличиваем счетчик в каждой итерации*/
                employeesCounter++;
            }
            /**проверяем что в списке столько же сотрудников сколько мы проверили во внутреннем цикле
             * и ни кого не забыли проверить*/
            assertEquals(employeesCounter, employeeListTest.size());
            /**номер отдела увеличиваем на 1, чтобы в следующей итерации проверить следующий отдел*/
            deptNum++;
        }
    }

    @Test
    public void getSalarySumByDeptTest() {
        /**делаю заглушку для метода*/
        Mockito.when(emplServ.getEmployees()).thenReturn(EMPLOYEE_MAP_MOCK_TEST);

        /**список ожидаемых значений сумм зарплат по отделам*/
        List<Integer> expected = new ArrayList<>(List.of(137_000, 186_000, 165_000, 130_000, 161_000));
        int deptNum = 1; //номер отдела

        /**циклом проходим по списку с суммами зарплат*/
        for (int i = 0; i < 5; i++) {
            /**получаем сумму зарплат из метода и кладем ее в actual*/
            int actual = deptServ.sumSalary(deptNum);
            /**сравниваем ожидаемое i-ое значение с фактическим, полученным из метода*/
            assertEquals(expected.get(i), actual);
            deptNum++;
        }
    }

    @Test
    public void getMaxSalaryByDeptTest() {
        /**делаю заглушку для метода*/
        Mockito.when(emplServ.getEmployees()).thenReturn(EMPLOYEE_MAP_MOCK_TEST);

        /**список ожидаемых значений сумм зарплат по отделам*/
        List<Integer> expected = new ArrayList<>(List.of(72_000, 99_000, 90_000, 67_000, 85_000));
        int deptNum = 1; //номер отдела

        /**циклом проходим по списку с суммами зарплат*/
        for (int i = 0; i < 5; i++) {
            /**получаем сумму зарплат из метода и кладем ее в actual*/
            Employee actual = deptServ.maxSalary(deptNum);
            /**сравниваем ожидаемое i-ое значение с фактическим, полученным из метода*/
            assertEquals(expected.get(i), actual);
            deptNum++;
        }
    }

    @Test
    public void getMinSalaryByDeptTest() {
        /**делаю заглушку для метода*/
        Mockito.when(emplServ.getEmployees()).thenReturn(EMPLOYEE_MAP_MOCK_TEST);

        /**список ожидаемых значений сумм зарплат по отделам*/
        List<Integer> expected = new ArrayList<>(List.of(65_000, 87_000, 75_000, 63_000, 76_000));
        int deptNum = 1; //номер отдела

        /**циклом проходим по списку с суммами зарплат*/
        for (int i = 0; i < 5; i++) {
            /**получаем сумму зарплат из метода и кладем ее в actual*/
            int actual = deptServ.minSalary(deptNum);
            /**сравниваем ожидаемое i-ое значение с фактическим, полученным из метода*/
            assertEquals(expected.get(i), actual);
            deptNum++;
        }
    }

    @Test
    public void getAllEmployeesTest() {
        /**делаю заглушку для метода*/
        Mockito.when(emplServ.getEmployees()).thenReturn(EMPLOYEE_MAP_MOCK_TEST);
        /**создаю ожидаемую мапу*/
        Map<Integer, List<Employee>> expected = new HashMap<>(Map.of(
                1, new ArrayList<>(deptServ.allDepartment(1)),
                2, new ArrayList<>(deptServ.allDepartment(2)),
                3, new ArrayList<>(deptServ.allDepartment(3)),
                4, new ArrayList<>(deptServ.allDepartment(4)),
                5, new ArrayList<>(deptServ.allDepartment(5))
        ));
        /**кладу в actual мапу из тестируемого метода*/
        Map<Integer, List<Employee>> actual = deptServ.allDepartment();
        /**сравниваю результаты*/
        assertEquals(expected, actual);
    }

    @Test
    public void getEmployeeByDeptExceptionTest1() {
        /**Проверка на выброс исключения при неверном вводе номера отдела*/
        assertThrows(EmployeeNotFoundException.class, () -> deptServ.allDepartment(0));
        assertThrows(EmployeeNotFoundException.class, () -> deptServ.allDepartment(6));

        assertThrows(EmployeeNotFoundException.class, () -> deptServ.sumSalary(0));
        assertThrows(EmployeeNotFoundException.class, () -> deptServ.sumSalary(6));

        assertThrows(EmployeeNotFoundException.class, () -> deptServ.maxSalary(0));
        assertThrows(EmployeeNotFoundException.class, () -> deptServ.maxSalary(6));

        assertThrows(EmployeeNotFoundException.class, () -> deptServ.minSalary(0));
        assertThrows(EmployeeNotFoundException.class, () -> deptServ.minSalary(6));
    }

    @Test
    public void getEmployeeByDeptExceptionTest2() {
        /**Проверка на выброс исключения при пустой мапе*/
        /**создаю пустую мапу*/
        Map<String, Employee> testMap = new HashMap<>();
        /**делаю заглушку для метода; теперь getEmployees будет возвращать пустую мапу testMap*/
        Mockito.when(emplServ.getEmployees()).thenReturn(testMap);

        /**подставляем номера отделав в тест поочередно*/
        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            assertThrows(NullPointerException.class, () -> deptServ.allDepartment(finalI));
            assertThrows(NullPointerException.class, () -> deptServ.sumSalary(finalI));
            assertThrows(NullPointerException.class, () -> deptServ.maxSalary(finalI));
            assertThrows(NullPointerException.class, () -> deptServ.minSalary(finalI));
        }
        assertThrows(NullPointerException.class, () -> deptServ.allDepartment());
    }

}
