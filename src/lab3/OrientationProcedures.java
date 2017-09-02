
package lab3;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
    This class is responcable for ensuring that an Employee has preformed proper Orentatiom
*/
public class OrientationProcedures {
    
    
    private Employee employee; 
    private final OutputService output;
    
    public OrientationProcedures(Employee emp){
        employee = emp;
        output = new OutputService();
    }
    
    /* 
        This should be private because it is useful only to this class and then,
        only as a helper method to other methods. This is method hiding - a type 
        of encapsulation where we put frequently used code in one place for for
        easy editing later if necessary.
    */
    private String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        return sdf.format(employee.getOrientationDate());
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
        output.simpleOutput(employee.getFullName() + " met with Hr on "
            + getFormattedDate());
    }

    // Assume this must be performed first, and assume that an employee
    // would only do this once, upon being hired. If that were true, this
    // method should not be public. It should only be available to this class
    // and should only be called as part of the larger task of:
    // doFirtTimeOrientation()
    private void meetDepartmentStaff() {
        employee.setMetDeptStaff(true);
        output.simpleOutput(employee.getFullName() + " met with Dept. Staff on "
            + getFormattedDate());
    }

    // Assume this must be performed third. And assume that because department
    // policies may change that this method may need to be called 
    // independently from other classes.
    public void reviewDeptPolicies() {
        employee.setReviewedDeptPolicies(true);
        output.simpleOutput(employee.getFullName() + " reviewed Dept policies on "
            + getFormattedDate());
    }

    // Assume this must be performed 4th. And assume that because employees
    // sometimes change office locations that this method may need to be called 
    // independently from other classes.
    public void moveIntoCubicle(String cubeId) {
        employee.setCubeId(cubeId);
        employee.setMovedIn(true);
        output.simpleOutput(employee.getFullName() + " moved into cubicle "
                + cubeId + " on " + getFormattedDate());
    }
}
