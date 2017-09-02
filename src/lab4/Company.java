
package lab4;

import java.util.ArrayList;

public class Company {
    
    private final String CRLF = "\n"; // carriage return line feed
    
    private final String MENU_OPTIONS = 
            "(1) - Hire New Employee" + CRLF +
            "(2) - Deligate Task" + CRLF + 
            "(3) - View Human Resources Report" + CRLF + 
            "(4) - View Employee Task Report" + CRLF +
            "ANY - Exit"; 
    
    private final HrDepartment hr;
    private final OutputService outService;
    private final InputService inService;
    private boolean isOperational;
    
    public Company(){
        outService = new OutputService();
        inService = new InputService();
        hr = new HrDepartment();
        isOperational = true;
    }
    
    public void runCompany(){
        do{
            showCompanyMenu();
            String menuOption = inService.getStringData();
            switch(menuOption.charAt(0)){
                case '1': seekNewEmployee(); break;
                case '2': deligateTask(); break;
                case '3': sendOutHrReport(); break;
                case '4': sendOutEmployeeReport(); break;
                default: shutDown();
            }
        }while(isOperational());
    }
    
    private void showCompanyMenu(){
        outService.sendMessage("What would you like To Do?");
        outService.sendMessage(MENU_OPTIONS);
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
    
    public void deligateTask(){
        String task = inService.getStringData();
        hr.deligateTaskToEmployee(task);
        outService.sendMessage("Task Delegated!");
    }
    
    public void shutDown(){
        inService.closeService();
        isOperational = false;
    }
    
    public void sendOutHrReport(){
        outService.sendMessage(hr.getHrReport());
        hr.clearReport();
    }
    
    public void sendOutEmployeeReport(){
        outService.sendMessage(hr.getEmployeeReport());
    }
    
    //----------------------//
    //--- GETTER METHODS ---//
    //----------------------//
    
    public boolean isOperational(){return isOperational;}
    
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
