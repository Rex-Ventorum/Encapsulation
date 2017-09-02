
package lab4;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HrDepartment {
    
      private final EmployeeReportService reportService;
      
      public HrDepartment(){
          reportService = new EmployeeReportService();
      }
      
    /* 
        This should be private because it is useful only to this class and then,
        only as a helper method to other methods. This is method hiding - a type 
        of encapsulation where we put frequently used code in one place for for
        easy editing later if necessary.
    */
    private String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        return sdf.format(orientationDate);
    }
    
    /*
        This method is public because it must be available to other classes in
        this project. Notice that it controls the order in which the helper methods
        are called. Order isn't always an issue, but here it obviously is, which
        may be an important requirement.
    */
    public void doFirstTimeOrientation(String cubeId) {
        orientationDate = new Date();
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
    // doFirtTimeOrientation()
    private void meetWithHrForBenefitAndSalryInfo() {
        metWithHr = true;
        reportService.addData(firstName + " " + lastName + " met with Hr on "
            + getFormattedDate() + CRLF);
    }

    // Assume this must be performed first, and assume that an employee
    // would only do this once, upon being hired. If that were true, this
    // method should not be public. It should only be available to this class
    // and should only be called as part of the larger task of:
    // doFirtTimeOrientation()
    private void meetDepartmentStaff() {
        metDeptStaff = true;
        reportService.addData(firstName + " " + lastName + " met with Dept. Staff on "
            + getFormattedDate() + CRLF);
    }

    // Assume this must be performed third. And assume that because department
    // policies may change that this method may need to be called 
    // independently from other classes.
    public void reviewDeptPolicies() {
        reviewedDeptPolicies = true;
        reportService.addData(firstName + " " + lastName + " reviewed Dept policies on "
            + getFormattedDate() + CRLF);
    }

    // Assume this must be performed 4th. And assume that because employees
    // sometimes change office locations that this method may need to be called 
    // independently from other classes.
    public void moveIntoCubicle(String cubeId) {
        this.cubeId = cubeId;
        this.movedIn = true;
        reportService.addData(firstName + " " + lastName + " moved into cubicle "
                + cubeId + " on " + getFormattedDate() + CRLF);
    }

}
