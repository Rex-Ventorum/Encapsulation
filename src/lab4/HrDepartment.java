
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
      
      private String employeeReport;
      private final ArrayList<Employee> employeeList;
      
      public HrDepartment(){
          employeeList = new ArrayList<>();
      }
      
      
      public boolean hireNewPersonAsEmployee(String firstName, String lastName, String ssn){
          Employee newEmployee = new Employee(firstName,lastName,ssn);
          boolean succsefullyHired = doFirstTimeOrientation(newEmployee);
          if(succsefullyHired) employeeList.add(newEmployee);
          return succsefullyHired;
      }

    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        return sdf.format(date);
    }
    

    public boolean doFirstTimeOrientation(Employee employee) {
        employee.setOrientationDate(new Date());
        
        
        
        
        
        meetWithHrForBenefitAndSalryInfo();
        meetDepartmentStaff();
        reviewDeptPolicies();
        moveIntoCubicle(cubeId);
    }

    private void meetWithHrForBenefitAndSalryInfo() {
        employeeInHr.setMetWithHr(true);
        employeeReport = employeeInHr.getFullName() + " met with Hr on "
            + formatDate(employeeInHr.getOrientationDate()) + CRLF;
    }

    private void meetDepartmentStaff() {
        employeeInHr.setMetDeptStaff(true);
        employeeReport = employeeInHr.getFullName() + " met with Dept. Staff on "
            + formatDate(employeeInHr.getOrientationDate()) + CRLF;
    }

    public void reviewDeptPolicies() {
        employeeInHr.setReviewedDeptPolicies(true);
        employeeReport = employeeInHr.getFullName() + " reviewed Dept policies on "
            + formatDate(new Date()) + CRLF;
    }

    public void moveIntoCubicle(String cubeId) {
        employeeInHr.setCubeId(cubeId);
        employeeInHr.setMovedIn(true);
        employeeReport = employeeInHr.getFullName() + " moved into cubicle "
                + cubeId + " on " + formatDate(new Date()) + CRLF;
    }

    public void sendEmployeeToHr(Employee sent){
        employeeInHr = sent;
        employeeReport = "";
    }
    
    public String getEmployeeReport(){
        return employeeReport;
    }
    
    private String getRandomCubeId(){
        Random random = new Random(System.nanoTime());
        char letter = (char)(random.nextInt(26) + (int)'A');
        String number = random.nextInt(4) + "" + random.nextInt(9) + "" + random.nextInt(9);
        return letter+number;
    }
}
