
package lab4;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/*
    Job Of Class:
    Manage Employee Objects and Delgate Tasks accordingly
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
      
      /*
        Takes in employee info and creates a new employee object then puts that employee through 
        orientation procedures
      */
      public void hireNewPersonAsEmployee(String firstName, String lastName, String ssn){
          Employee newEmployee = new Employee(firstName,lastName,ssn);
          doFirstTimeOrientation(newEmployee);
          employeeList.add(newEmployee);
          addToReport(newEmployee.getFullName() + " completed orientation and was Hired!");
      }   

      /*
        Method simulates employee orination where HR would likely ensure the employee
        completed the tasks delegated to them with a check off (setting flags to true)
      */
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
    
    /*
        delegates a "Review Dept. Polices" task to all employees
    */
    public void haveEmployeesReviewNewPolices(){
        for(Employee employee : employeeList){
            employee.doTask("Review Dept. Polices");
        }
    }
    
    /*
        finds a random employee and posts them to the new cublice with
        "Move to Cublicle" task
    */
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

    /*
        Delegates generic task to an employee
    */
    public void delegateTaskToEmployee(String task){
        if(employeeList.isEmpty()){
            addToReport("No Employee's Found To Deligate Work.");
        }else{
            Employee employee = employeeList.get(random.nextInt(employeeList.size()));
            employee.doTask(task);
            addToReport("Delegated \"" + task + "\" to " + employee.getFullName());
        }
    }
    
    /*
        Adds line of text to hrReport
    */
    private void addToReport(String data){
        hrReport += data + CRLF;
    }
    
    /*
        Clears the hrReport
    */
    public void clearReport(){
        hrReport = "";
    }
    
    /*
        Creates and returns a full hrReport object
    */
    public String getHrReport(){
        String fullReport = "Human Resources Report:" + CRLF;
        fullReport += DIVIDE_LINE;
        fullReport += hrReport;
        fullReport += DIVIDE_LINE;
        return fullReport;
    }
    
    /*
        Creates and returns a full Employee Report from Every Employee
    */
    public String getEmployeeReport(){
        String fullReport = "Employee Task Report: " + CRLF;
        for(Employee employee : employeeList){
            fullReport += DIVIDE_LINE;
            fullReport += employee.getFullName() + ": Cube " + employee.getCubeId() + CRLF;
            fullReport += employee.getTaskReport();
            employee.clearTaskReport();
        }
        fullReport += DIVIDE_LINE;
        return fullReport;
    }
    
    /*
        Creates a random cubeId 
    */
    private String getRandomCubeId(){
        char letter = (char)(random.nextInt(26) + (int)'A');
        String number = random.nextInt(4) + "" + random.nextInt(9) + "" + random.nextInt(9);
        return letter+number;
    }
}
