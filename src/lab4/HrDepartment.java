
package lab4;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HrDepartment {
    
      private final String CRLF = "\n"; // carriage return line feed
      
      private String employeeReport;
      private Employee employee;
      
      public HrDepartment(){
      }
      
     /* 
        This should be private because it is useful only to this class and then,
        only as a helper method to other methods. This is method hiding - a type 
        of encapsulation where we put frequently used code in one place for for
        easy editing later if necessary.
    */
    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        return sdf.format(date);
    }
    
    /*
        This method is public because it must be available to other classes in
        this project. Notice that it controls the order in which the helper methods
        are called. Order isn't always an issue, but here it obviously is, which
        may be an important requirement.
    */
    public void doFirstTimeOrientation(String cubeId) {
        employee.setOrientationDate(new Date());
        meetWithHrForBenefitAndSalryInfo();
        meetDepartmentStaff();
        reviewDeptPolicies();
        moveIntoCubicle(cubeId);
    }

    // The following methods may be public or private, depending on whether
    // they need to be called from other classes independently.

    // Assume this must be performed first, and assume that an employee
    // would only do this once, upon being hired. If that were true, this
    // method should not be public. It should only be available to this class
    // and should only be called as part of the larger task of:
    private void meetWithHrForBenefitAndSalryInfo() {
        employee.setMetWithHr(true);
        employeeReport = employee.getFullName() + " met with Hr on "
            + formatDate(employee.getOrientationDate()) + CRLF;
    }

    // Assume this must be performed first, and assume that an employee
    // would only do this once, upon being hired. If that were true, this
    // method should not be public. It should only be available to this class
    // and should only be called as part of the larger task of:
    // doFirtTimeOrientation()
    private void meetDepartmentStaff() {
        employee.setMetDeptStaff(true);
        employeeReport = employee.getFullName() + " met with Dept. Staff on "
            + formatDate(employee.getOrientationDate()) + CRLF;
    }

    // Assume this must be performed third. And assume that because department
    // policies may change that this method may need to be called 
    // independently from other classes.
    public void reviewDeptPolicies() {
        employee.setReviewedDeptPolicies(true);
        employeeReport = employee.getFullName() + " reviewed Dept policies on "
            + formatDate(new Date()) + CRLF;
    }

    // Assume this must be performed 4th. And assume that because employees
    // sometimes change office locations that this method may need to be called 
    // independently from other classes.
    public void moveIntoCubicle(String cubeId) {
        employee.setCubeId(cubeId);
        employee.setMovedIn(true);
        employeeReport = employee.getFullName() + " moved into cubicle "
                + cubeId + " on " + formatDate(new Date()) + CRLF;
    }

    public void sendEmployeeToHr(Employee sent){
        employee = sent;
        employeeReport = "";
    }
    
    public String getEmployeeReport(){
        return employeeReport;
    }
}
