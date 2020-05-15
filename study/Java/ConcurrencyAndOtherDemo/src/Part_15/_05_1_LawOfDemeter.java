package Part_15;

import java.util.ArrayList;
import java.util.List;

public class _05_1_LawOfDemeter {
    public static void main(String[] args) {
        SchoolManager manager = new SchoolManager();
        manager.printAllEmployee(new CollegeManager());
    }
}

// 学校总部的员工类
class Employee {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

// 学院的员工类
class CollegeEmployee {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

// 用于管理学院员工的类
class CollegeManager {
    // 返回学院所有的员工 id
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CollegeEmployee emp = new CollegeEmployee();
            emp.setId("学院员工 id = " + i);
            list.add(emp);
        }
        return list;
    }

    public void printEmployee() {
        List<CollegeEmployee> list1 = this.getAllEmployee();
        System.out.println("========学院员工 id ========");
        for (CollegeEmployee e : list1) {
            System.out.println(e.getId());
        }
    }
}

// 用于管理学校的类
class SchoolManager {
    // 返回学校总部的所有员工的 id
    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Employee emp = new Employee();
            emp.setId("学校总部员工 id = " + i);
            list.add(emp);
        }
        return list;
    }

    // 用于输出学院员工 id 和学校总部员工 id
    public void printAllEmployee(CollegeManager manager) {

        manager.printEmployee();

        List<Employee> list2 = this.getAllEmployee();
        System.out.println("========学校总部员工 id ========");
        for (Employee e : list2) {
            System.out.println(e.getId());
        }
    }
}