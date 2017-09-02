
package lab4;

import java.util.ArrayList;

public class Company {
    
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
    
    public void hireNewEmployee(String firstName,String lastName, String ssn){
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
