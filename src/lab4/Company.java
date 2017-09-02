
package lab4;

/*
    Job Of Class
    Represent a company object. Would be responable for contacting outside world
    is source point for all incoming and outgoing data.
*/

public class Company {
    private final String CRLF = "\n"; // carriage return line feed
    
    private HrDepartment hr;
    private OutputService outService;
    
    public Company(){
        outService = new OutputService();
        hr = new HrDepartment();
    }
    

    public void hireNewEmployee(String firstName,String lastName, String ssn){
        hr.hireNewPersonAsEmployee(firstName, lastName, ssn);
    }
    
    public void delegateTask(String task){
        hr.delegateTaskToEmployee(task);
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

    public HrDepartment getHrDepartment(){return hr;}
    public OutputService getOutputServices(){return outService;}
    
    //----------------------//
    //--- SETTER METHODS ---//
    //----------------------//
    
    public void setHrDepartment(HrDepartment hr){
        this.hr = hr;
    }
    
    public void setOutputServices(OutputService outService){
        this.outService = outService;
    }
    
}
