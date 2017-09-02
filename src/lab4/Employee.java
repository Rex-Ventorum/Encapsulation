package lab4;

import java.util.Calendar;
import java.util.Date;

/**
 * As with the previous lab you should focus on CLASS Encapsulation and the 
 * Single Responsibility Principle (SRP). However what makes this lab DIFFERENT
 * is that in a real program you would need more than just an Employee class 
 * and a EmployeeResportService class. Remember what you learned about OOA/D and 
 * finding the Conceptual Objects in the Problem Domain.
 * 
 * Pay special attention to the following issues:
 *    1. You will need additional classes to simulate the real world. To keep
 *       things simple you should think about adding two more classes. Think
 *       about how employees are hired, who does the hiring and who do those
 *       people work for. Think about the Nouns used in business with respect
 *       to hiring employees and commanding them to go through orientation.
 * 
 *    2. When adding these classes think about the Single Responsibility 
 *       Principle and Class Encapsulation -- hiding classes inside other
 *       classes, similar to what you did with the report service which was
 *       hidden inside the Employee class.
 * 
 *    3. For those who struggle with this final lab a solution is provided.
 *       However, you should not look at the solution unless absolutely 
 *       necessary if you are stuck. Try to do as much of this lab on your 
 *       own by doing critical thinking about the classes you need and the 
 *       responsibilities you are giving each class.
 * 
 * Review the tips in the document "EncapCheckList.pdf" if needed.
 *
 * @author      Jim Lombardo, WCTC Instructor
 * @version     1.02
 */
public class Employee {
    // Use constants for numbers or Strings that are repeated 
    // (all are called 'magic numbers', which are evil). This makes editing
    // these values easier -- one place to do it.
    private final String REQUIRED_MSG = " is mandatory ";
    private final String CRLF = "\n"; // carriage return line feed
    
    //Reqired On Constructon
    private String firstName;
    private String lastName;
    private String ssn;
    
    //Optinonal Objects (can be set later)
    private String cubeId;
    private Date orientationDate;
    
    //Flags
    private boolean metWithHr;
    private boolean metDeptStaff;
    private boolean reviewedDeptPolicies;
    private boolean movedIn;

    /*
        Notice we force certain mandatory properties by using a custom
        constructor. But we use the setter method to peform validation.
    */
    public Employee(String firstName, String lastName, String ssn) {
        // Using setter method guarantees validation will be performed
        // Ignore the warning messages for now. Will be explained later
        setFirstName(firstName);
        setLastName(lastName);
        setSsn(ssn);
    }
    
    //----------------------//
    //--- GETTER METHODS ---//
    //----------------------//
    
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getFullName(){return firstName + " " + lastName;}
    public String getSsn() { return ssn; }
   
    public String getCubeId() {return cubeId; }
    public Date getOrientationDate() {return orientationDate;}

    public boolean hasMetWithHr() { return metWithHr; }
    public boolean hasMetDeptStaff() { return metDeptStaff;}
    public boolean hasReviewedDeptPolicies() {return reviewedDeptPolicies; }
    public boolean hasMovedIn() { return movedIn; }

    //----------------------//
    //--- SETTER METHODS ---//
    //----------------------//
    
    // setter methods give the developer the power to control what data is
    // allowed through validation. Throwing ane exception is the best
    // practice when validation fails. Don't do a System.out.println()
    // to display an error message -- not the job of this class!
    
    public void setFirstName(String firstName) {
        if(stringIsNullOrEmpty(firstName)) 
            throw new IllegalArgumentException("First Name" + REQUIRED_MSG);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if(stringIsNullOrEmpty(lastName)) 
            throw new IllegalArgumentException("Last Name" + REQUIRED_MSG);
        this.lastName = lastName;
    }

    public void setSsn(String ssn) {
        if(!stringIsValidSsn(ssn)) 
            throw new IllegalArgumentException("Ssn" + REQUIRED_MSG + "and must be \"###-##-####\" format");
        this.ssn = ssn;
    }
    
    public void setCubeId(String cubeId) {
        if(!stringIsValidCubeId(cubeId))
            throw new IllegalArgumentException("Cube Id" + REQUIRED_MSG + "and must be \"A###\" format");
        this.cubeId = cubeId;
    }
    
    
    public void setOrientationDate(Date orientationDate) {
        if(orientationDate == null) 
            throw new IllegalArgumentException("Orientation Date" + REQUIRED_MSG);
        this.orientationDate = orientationDate;
    }

    //Boolean methods need no validation
    public void setMetWithHr(boolean metWithHr) {this.metWithHr = metWithHr;}
    public void setMetDeptStaff(boolean metDeptStaff) { this.metDeptStaff = metDeptStaff;}
    public void setReviewedDeptPolicies(boolean reviewedDeptPolicies) {this.reviewedDeptPolicies = reviewedDeptPolicies;}
    public void setMovedIn(boolean movedIn) { this.movedIn = movedIn;}
    
    //----------------------//
    //- VALIDATION HELPERS -//
    //----------------------//
    
    private boolean stringIsNullOrEmpty(String testMe){
        return testMe == null || testMe.isEmpty();
    }

    private boolean stringIsValidSsn(String testSsn){
        return !stringIsNullOrEmpty(testSsn) &&
               testSsn.matches("\\d{3}-\\d{2}-\\d{4}");
    }
    
    private boolean stringIsValidCubeId(String testCubeId){
        return !stringIsNullOrEmpty(testCubeId) &&
                testCubeId.matches("[A-Z]\\d{3}");
    }
    
}