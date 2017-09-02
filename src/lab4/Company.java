
package lab4;

import java.util.ArrayList;

public class Company {
    private final HrDepartment hr;
    private final OutputService outService;
    private final InputService inService;
    
    public Company(){
        outService = new OutputService();
        inService = new InputService();
        hr = new HrDepartment();
    }
    
    public void seekNewEmployee(){

        
    }
}
