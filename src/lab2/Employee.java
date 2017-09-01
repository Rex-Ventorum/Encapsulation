package lab2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
   
    //Constant Objects 
    private static final DateUtilities DATE_FORMATER = new DateUtilities();
    
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
        System.out.println(firstName + " " + lastName + " met with Hr on "
            + DATE_FORMATER.getFormattedDate(orientationDate));
    }

    // Assume this must be performed first, and assume that an employee
    // would only do this once, upon being hired.:
    public void meetDepartmentStaff() {
        metDeptStaff = true;
        System.out.println(getFullName() + " met with Dept. Staff on "
            + DATE_FORMATER.getFormattedDate(orientationDate));
    }

    // Assume this must be performed third. And assume that because department
    // policies may change that this method may need to be called 
    // independently from other classes.
    public void reviewDeptPolicies() {
        reviewedDeptPolicies = true;       
        System.out.println(getFullName() + " reviewed Dept policies on "
            + DATE_FORMATER.getFormattedDate(orientationDate));
    }

    // Assume this must be performed 4th. And assume that because employees
    // sometimes change office locations that this method may need to be called 
    // independently from other classes.
    public void moveIntoCubicle(String cubeId) {
        this.cubeId = cubeId;
        this.movedIn = true;     
        System.out.println(getFullName() + " moved into cubicle "
                + cubeId + " on " + DATE_FORMATER.getFormattedDate(orientationDate));
    }

    //----------------------//
    //--- GETTER METHODS ---//
    //----------------------//
    public String getFirstName() {return firstName;}
    public String getLastName() { return lastName; }
    public String getFullName(){return firstName + " " + lastName;}
    public String getSsn() { return ssn;}
       
    public boolean isMetWithHr() { return metWithHr;}
    public boolean isMetDeptStaff() {return metDeptStaff;}
    public boolean isReviewedDeptPolicies() {return reviewedDeptPolicies;}
    public boolean isMovedIn() {return movedIn;}
    
    public Date getOrientationDate() {return orientationDate;}
    public String getCubeId() { return cubeId;}

    //----------------------//
    //--- SETTER METHODS ---//
    //----------------------//
    
    // setter methods give the developer the power to control what data is
    // allowed through validation.
    
    public void setFirstName(String firstName) {
        if(stringIsNullOrEmpty(firstName)) 
            throw new IllegalArgumentException("Argument may not be null or empty string");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if(stringIsNullOrEmpty(lastName)) 
            throw new IllegalArgumentException("Argument may not be null or empty string");
        this.lastName = lastName;
    }

    public void setSsn(String ssn) {
        if(stringIsValidSsn(ssn)) 
            throw new IllegalArgumentException("Argument must be non null and \"000-00-0000\" format");
        this.ssn = ssn;
    }
    
    // boolean parameters need no validation
    public void setMetWithHr(boolean metWithHr) {this.metWithHr = metWithHr;}
    public void setMetDeptStaff(boolean metDeptStaff) {this.metDeptStaff = metDeptStaff;}
    public void setReviewedDeptPolicies(boolean reviewedDeptPolicies) {this.reviewedDeptPolicies = reviewedDeptPolicies;}
    public void setMovedIn(boolean movedIn) {this.movedIn = movedIn;}
    
    //Can add a Cube ID Regex check if office has procedures for this
    public void setCubeId(String cubeId) {
        this.cubeId = cubeId;
    }

    public void setOrientationDate(Date orientationDate) {
        //Ensure year is reasonable
        if(orientationDate != null){        
            Calendar cal = Calendar.getInstance();
            int currentYear = cal.get(Calendar.YEAR);
            
            cal.setTime(orientationDate);
            int orientationYear = cal.get(Calendar.YEAR);
            
            int companyFoundation = 1970;            
            if(orientationYear < companyFoundation || orientationYear > currentYear + 20)
                 throw new IllegalArgumentException("Date has an unreasonable year");
            
        }//end of non-null Year validation
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
