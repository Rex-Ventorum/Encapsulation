package lab4;

import java.util.Scanner;

public class InputService {
    private final Scanner scanner;
    
    public InputService(){
        scanner = new Scanner(System.in);
    }
    
    public String getStringData(){
        return scanner.next();
    }
    
    public void closeService(){
        scanner.close();
    }
}
