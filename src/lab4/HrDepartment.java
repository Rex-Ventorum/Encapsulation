
package lab4;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/*
    Job Of Class:
    Keep Record of Employees and tasks that they have completed

*/
public class HrDepartment {
    
      private final String CRLF = "\n"; // carriage return line feed
      private final String DIVIDE_LINE = "-----------------------------" + CRLF;
      private final Random random;
      
      private String hrReport;
      private final ArrayList<Employee> employeeList;
      
      public HrDepartment(){
          employeeList = new ArrayList<>();
          random = new Random(System.nanoTime());
      }
      
      
      public boolean hireNewPersonAsEmployee(String firstName, String lastName, String ssn){
          Employee newEmployee = new Employee(firstName,lastName,ssn);
          boolean succsefullyHired = doFirstTimeOrientation(newEmployee);
          if(succsefullyHired){
              employeeList.add(newEmployee);
              addToReport(newEmployee.getFullName() + " completed orientation and was Hired!");
          }else{
              addToReport(newEmployee.getFullName() + " failed orientation and was NOT Hired!");
          }
          return succsefullyHired;
      }   

    private boolean doFirstTimeOrientation(Employee employee) {
        employee.setOrientationDate(new Date());
        
        //Task 1
        employee.setMetWithHr(
                employee.doTask("Meet with Hr For Benefits and Salry Info"));
        //Task 2
        employee.setMetDeptStaff(
                employee.doTask("Meet with Dept. Staff"));
        
        //Task 3
        employee.setReviewedDeptPolicies(
                employee.doTask("Review Dept. Polices"));
        
        //Task 4
        String cubeId = getRandomCubeId();
        if(employee.doTask("Move into Cublicle " + cubeId)){
            employee.setCubeId(cubeId);
            employee.setMovedIn(true);
        }
        
        return employee.hasMetWithHr() &&
               employee.hasMetDeptStaff() &&
               employee.hasReviewedDeptPolicies() &&
               employee.hasMovedIn();
    }

    public void deligateTaskToEmployee(String task){
        Employee employee;
        int maxAttempts = 5;
        do{
            maxAttempts--;
            employee = employeeList.get(random.nextInt(employeeList.size()));
        }while(!employee.doTask(task) || maxAttempts <= 0);
        addToReport("Delegated " + task + " to " + employee.getFullName());
    }
    
    private void addToReport(String data){
        hrReport += data + CRLF;
    }
    
    public void clearReport(){
        hrReport = "";
    }
    
    public String getHrReport(){
        String fullReport = "Human Resources Report:" + CRLF;
        fullReport += DIVIDE_LINE;
        fullReport += hrReport;
        fullReport += DIVIDE_LINE;
        return fullReport;
    }
    
    private String getRandomCubeId(){
        char letter = (char)(random.nextInt(26) + (int)'A');
        String number = random.nextInt(4) + "" + random.nextInt(9) + "" + random.nextInt(9);
        return letter+number;
    }
}
