
package lab4;

import java.util.ArrayList;

public class Company {
    private final String CRLF = "\n"; // carriage return line feed
    
    private final HrDepartment hr;
    private final OutputService outService;
    
    public Company(){
        outService = new OutputService();
        hr = new HrDepartment();
    }
    
    public void hireNewEmployee(String firstName,String lastName, String ssn){
        hr.hireNewPersonAsEmployee(firstName, lastName, ssn);
    }
    
    public void delegateTask(String task){
        hr.deligateTaskToEmployee(task);
        outService.sendMessage("Task Delegated!");
    }
        
    public void viewHrReport(){
        outService.sendMessage(CRLF + hr.getHrReport());
        hr.clearReport();
    }
    
    public void viewEmployeeReport(){
        outService.sendMessage(CRLF + hr.getEmployeeReport());
    }
    
    //----------------------//
    //--- GETTER METHODS ---//
    //----------------------//
    
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
}
