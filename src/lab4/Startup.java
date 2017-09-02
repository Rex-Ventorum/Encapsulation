package lab4;

/**
 * This class is the startup class for the program. But together with the 
 * other classes provided it is not a particularly good simulation of the 
 * real world. Employees don't just hire themselves and them tell themselves
 * to go through orientation. There's usually a company and a HR person involved.
 *
 * @author      Jim Lombardo, WCTC Instructor
 * @version     1.02
 */
public class Startup {
    public static void main(String[] args) {
        Company company = new Company();
        company.hireNewEmployee("John", "Smith", "555-55-5555");
        company.hireNewEmployee("Sally", "Smith", "777-77-7777");
        company.hireNewEmployee("Randy", "Johnson", "444-44-4444");
       
        company.delegateTask("Meet with Client");
        company.delegateTask("Fetch Coffie");
        company.delegateTask("Create Invitory Report");
        
        company.viewHrReport();
        company.viewEmployeeReport();
    }    
}
