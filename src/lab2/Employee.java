package lab2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * In this lab focus on METHOD encapsulation and fix/add code as necessary.
 * Pay special attention to the following issues:
 *    1. Not all methods need to be public
 *    2. When methods need to be called in a certain order you can do this
 *       by creating a parent method that calls the other, helper methods.
 *    3. There is some duplicate code used that violates the D.R.Y. principle.
 *       Eliminate that by encapsulating the duplicate code in a new method
 *       and then call that method in place of the duplicate code
 *    4. All method parameters should be validated.
 * 
 * Review the tips in the document "EncapCheckList.pdf" if needed.
 *
 * @author      Jim Lombardo, WCTC Instructor
 * @version     1.02
 */
public class Employee {
   
    private String firstName;
    private String lastName;
    private String ssn;
    private boolean metWithHr;
    private boolean metDeptStaff;
    private boolean reviewedDeptPolicies;
    private boolean movedIn;
    private String cubeId;
    private Date orientationDate;

    //---------------------//
    //---- CONSTRUCTOR ----//
    //---------------------//
    
    public Employee(String firstName, String lastName, String ssn) {
        if(stringIsNullOrEmpty(firstName) || stringIsNullOrEmpty(lastName) || stringIsValidSsn(ssn))
            throw new IllegalArgumentException("Argument may not be null or empty. ssn must be \"000-00-0000\"");
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    // Assume this must be performed first, and assume that an employee
    // would only do this once, upon being hired.
    public void meetWithHrForBenefitAndSalryInfo() {
        metWithHr = true;
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        String fmtDate = sdf.format(orientationDate);        
        System.out.println(firstName + " " + lastName + " met with Hr on "
            + fmtDate);
    }

    // Assume this must be performed first, and assume that an employee
    // would only do this once, upon being hired.:
    public void meetDepartmentStaff() {
        metDeptStaff = true;
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        String fmtDate = sdf.format(orientationDate);        
        System.out.println(firstName + " " + lastName + " met with Dept. Staff on "
            + fmtDate);
    }

    // Assume this must be performed third. And assume that because department
    // policies may change that this method may need to be called 
    // independently from other classes.
    public void reviewDeptPolicies() {
        reviewedDeptPolicies = true;
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        String fmtDate = sdf.format(orientationDate);        
        System.out.println(firstName + " " + lastName + " reviewed Dept policies on "
            + fmtDate);
    }

    // Assume this must be performed 4th. And assume that because employees
    // sometimes change office locations that this method may need to be called 
    // independently from other classes.
    public void moveIntoCubicle(String cubeId) {
        this.cubeId = cubeId;
        this.movedIn = true;
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        String fmtDate = sdf.format(orientationDate);        
        System.out.println(firstName + " " + lastName + " moved into cubicle "
                + cubeId + " on " + fmtDate);
    }

    //----------------------//
    //--- GETTER METHODS ---//
    //----------------------//
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getSsn() {
        return ssn;
    }
       
    public boolean isMetWithHr() { return metWithHr;}
    public boolean isMetDeptStaff() {return metDeptStaff;}
    public boolean isReviewedDeptPolicies() {return reviewedDeptPolicies;}
    public boolean isMovedIn() {return movedIn;}
    
    public Date getOrientationDate() {
        return orientationDate;
    }
    
    public String getCubeId() {
        return cubeId;
    }

    //----------------------//
    //--- SETTER METHODS ---//
    //----------------------//
    
    // setter methods give the developer the power to control what data is
    // allowed through validation.
    
    public void setFirstName(String firstName) {
       this.firstName = firstName;
    }
    public void setLastName(String lastName) {
       this.lastName = lastName;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    
    // boolean parameters need no validation
    public void setMetWithHr(boolean metWithHr) {this.metWithHr = metWithHr;}
    public void setMetDeptStaff(boolean metDeptStaff) {this.metDeptStaff = metDeptStaff;}
    public void setReviewedDeptPolicies(boolean reviewedDeptPolicies) {this.reviewedDeptPolicies = reviewedDeptPolicies;}
    public void setMovedIn(boolean movedIn) {this.movedIn = movedIn;}
    
    public void setCubeId(String cubeId) {
        this.cubeId = cubeId;
    }

    public void setOrientationDate(Date orientationDate) {
        this.orientationDate = orientationDate;
    }
    
    //----------------------//
    //- VALIDATION HELPERS -//
    //----------------------//
    
    private boolean stringIsNullOrEmpty(String testMe){
        return testMe == null || testMe.equals("");
    }

    private boolean stringIsValidSsn(String testSsn){
        return !stringIsNullOrEmpty(testSsn) &&
               testSsn.matches("\\d{3}-\\d{2}-\\d{4}");
    }
}
