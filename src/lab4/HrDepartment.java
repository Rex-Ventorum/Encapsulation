
package lab4;

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
          hrReport = "";
      }
      
      
      public void hireNewPersonAsEmployee(String firstName, String lastName, String ssn){
          Employee newEmployee = new Employee(firstName,lastName,ssn);
          doFirstTimeOrientation(newEmployee);
          employeeList.add(newEmployee);
          addToReport(newEmployee.getFullName() + " completed orientation and was Hired!");
      }   

    private void doFirstTimeOrientation(Employee employee) {
        employee.setOrientationDate(new Date());
        
        //Task 1
        employee.doTask("Meet with Hr For Benefits and Salry Info");
        employee.setMetWithHr(true);
       
        //Task 2
        employee.doTask("Meet with Dept. Staff");
        employee.setMetDeptStaff(true);
        
        //Task 3
        employee.doTask("Review Dept. Polices");
        employee.setReviewedDeptPolicies(true);
        
        //Task 4
        String cubeId = getRandomCubeId();
        employee.doTask("Move into Cublicle " + cubeId);
        employee.setCubeId(cubeId);
        employee.setMovedIn(true);
    }
    
    public void haveEmployeesReviewNewPolices(){
        for(Employee employee : employeeList){
            employee.doTask("Review Dept. Polices");
        }
    }
    
    public void fillCubical(String cubeId){
        if(employeeList.isEmpty()){
            addToReport("No Employee's Found To Fill Cubical With");
        }else{
            Employee employee = employeeList.get(random.nextInt(employeeList.size()));
            employee.doTask("Move To Cublicle "+ cubeId);
            employee.setCubeId(cubeId);
            addToReport(employee.getFullName() + " was reassgined to " + cubeId);
        }
    }

    public void deligateTaskToEmployee(String task){
        if(employeeList.isEmpty()){
            addToReport("No Employee's Found To Deligate Work.");
        }else{
            Employee employee = employeeList.get(random.nextInt(employeeList.size()));
            addToReport("Delegated " + task + " to " + employee.getFullName());
        }
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
    
    public String getEmployeeReport(){
        String fullReport = "Employee Task Report: " + CRLF;
        for(Employee employee : employeeList){
            fullReport += DIVIDE_LINE;
            fullReport += employee.getFullName() + ": Cube " + employee.getCubeId() + CRLF;
            fullReport += employee.getTaskReport() + CRLF;
            employee.clearTaskReport();
        }
        fullReport += DIVIDE_LINE;
        return fullReport;
    }
    
    private String getRandomCubeId(){
        char letter = (char)(random.nextInt(26) + (int)'A');
        String number = random.nextInt(4) + "" + random.nextInt(9) + "" + random.nextInt(9);
        return letter+number;
    }
}
