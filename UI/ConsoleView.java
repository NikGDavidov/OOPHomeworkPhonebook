package Ex002Phonebook.UI;

import Ex002Phonebook.Core.MVP.View;

import java.util.Scanner;

public class ConsoleView implements View {
    Scanner sc;
    public ConsoleView() {
        sc = new Scanner(System.in);
    }
    @Override
    public String getFirstName() {
        System.out.printf("FirstName: ");
        return sc.nextLine();
    }

    @Override
    public void setFirstName(String value) {
        System.out.printf("FirstName: %s\n", value);
    }

    @Override
    public String getLastName() {
        System.out.printf("LastName: ");
        return sc.nextLine();
    }

    @Override
    public void setLastName(String value) {
        System.out.printf("LastName: %s\n", value);
    }

    @Override
    public String getDescription() {
        System.out.printf("Description: ");
        return sc.nextLine();
    }

    @Override
    public void setDescription(String value) {
        System.out.printf("Description: %s\n", value);        
    }
    
}
