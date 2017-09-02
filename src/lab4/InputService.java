package lab4;

import java.util.Scanner;

public class InputService {
    
    public String getStringData(){
        Scanner scanner = new Scanner(System.in);
        String inData = scanner.nextLine();
        scanner.close();
        return inData;
    }
}
