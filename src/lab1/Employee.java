package lab1;

import java.util.Date;

/**
 * Fix the code in this class to do PROPERTY encapsulation correctly. Also
 * consider if any of the properties should be mandatory and use a 
 * constructor to enforce that. Review the tips in the document 
 * "EncapCheckList.pdf" if needed.
 *
 * @author      Jim Lombardo, WCTC Instructor
 * @version     1.02
 */
public class Employee {
    
    //Reqired Objects
    private String firstName;
    private String lastName;
    private String ssn;
    
    //Optinal Objects ("Can Be null)
    private String cubeId;
    private Date orientationDate;
    
    //Flags 
    private boolean metWithHr;
    private boolean metDeptStaff;
    private boolean reviewedDeptPolicies;
    private boolean movedIn;

    //---------------------//
    //---- CONSTRUCTOR ----//
    //---------------------//
    
    public Employee(String firstName, String lastName, String ssn){
        if(stringIsNullOrEmpty(firstName) || stringIsNullOrEmpty(lastName) || stringIsNullOrEmpty(ssn))
            throw new IllegalArgumentException("Argument may not be null or empty string");
        this.firstName = firstName; this.lastName = lastName; this.ssn = ssn;
    }
    
    //----------------------//
    //--- GETTER METHODS ---//
    //----------------------//
    
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getSsn() { return ssn; }
   
    public String getCubeId() {return cubeId; }
    public Date getOrientationDate() {return orientationDate; }

    public boolean hasMetWithHr() { return metWithHr; }
    public boolean hasMetDeptStaff() { return metDeptStaff;}
    public boolean hasReviewedDeptPolicies() {return reviewedDeptPolicies; }
    public boolean hasMovedIn() { return movedIn; }
    
    
    //----------------------//
    //---- OTHER METHODS ---//
    //----------------------//
    private boolean stringIsNullOrEmpty(String testMe){
        return testMe == null || testMe.equals("");
    }

}
