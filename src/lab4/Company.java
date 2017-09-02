
package lab4;

import java.util.ArrayList;

public class Company {
    
    private final String CRLF = "\n"; // carriage return line feed
    
    private final HrDepartment hr;
    private final OutputService outService;
    private final InputService inService;
    
    public Company(){
        outService = new OutputService();
        inService = new InputService();
        hr = new HrDepartment();
    }
    
    public void seekNewEmployee(){
        String firstName, lastName, ssn;
        outService.sendMessage("Welcome To We're Hiring Incorperated!" + CRLF);
        
        do{
            outService.sendMessage("Input First Name (Non Null Or Empty): ");
            firstName = inService.getStringData();
        }while(stringIsNullOrEmpty(firstName));
        
        do{
            outService.sendMessage("Input Last Name (Non Null Or Empty): ");
            lastName = inService.getStringData();
        }while(stringIsNullOrEmpty(lastName));
        
        do{
            outService.sendMessage("Input Ssn (\"###-##-####\" format Only): ");
            ssn = inService.getStringData();
        }while(!stringIsValidSsn(ssn));
        
        hr.hireNewPersonAsEmployee(firstName, lastName, ssn);
    }
    
    public void shutDown(){
        inService.closeService();
    }
    
    public void sendOutHrReport(){
        outService.sendMessage(hr.getHrReport());
        hr.clearReport();
    }
    
    private boolean stringIsNullOrEmpty(String testMe){
        return testMe == null || testMe.isEmpty();
    }
    
    private boolean stringIsValidSsn(String testSsn){
        return !stringIsNullOrEmpty(testSsn) &&
               testSsn.matches("\\d{3}-\\d{2}-\\d{4}");
    }
}
