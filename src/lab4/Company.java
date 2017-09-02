
package lab4;

import java.util.ArrayList;
import java.util.Scanner;

public class Company {
    private final ArrayList<Employee> EmployeeList;
    private final HrDepartment hr;
    
    public Company(){
        EmployeeList = new ArrayList<>();
        hr = new HrDepartment();
    }
    
    public void seekNewEmployee(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to We're Hiring Incorperated!");
        System.out.println("What is your first name: ");
        
    }
}
