package Ex002Phonebook.Core.MVP;

import Ex002Phonebook.Core.Infrastructure.Phonebook;
import Ex002Phonebook.Core.Models.Contact;

import java.io.*;
import java.util.Scanner;

public class Model {

    Phonebook currentBook;
    private int currentIndex;
    private String path;

    public Model(String path) {
        currentBook = new Phonebook();
        currentIndex = 0;
        this.path = path;
    }

    public Contact currentContact() {
        if (currentIndex >= 0) {
            return currentBook.getCotact(currentIndex);
        } else {
            // ???...
            return null;
        }
    }

    public void load() {
        String delimeter = " ";
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String cont = reader.readLine();
            while (cont != null) {
                if (cont.split(",").length == 3) delimeter = ",";
                if (cont.split(".").length == 3) delimeter = ".";
                if (cont.split(";").length == 3) delimeter = ";";
                if (cont.split("/").length == 3) delimeter = "/";

                String[] temp = cont.split(delimeter);

                String fname = temp[0];
                String lname = temp[1];
                String description = temp[2];

                this.currentBook.add(new Contact(fname, lname, description));
                cont = reader.readLine();
            }

//            String fname = reader.readLine();
//            while (fname != null) {
//                String lname = reader.readLine();
//                String description = reader.readLine();
//                this.currentBook.add(new Contact(fname, lname, description));
//                fname = reader.readLine();
//            }
            reader.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Файл с контактами еще не создан, запишите хотя бы один контакт");;
        }
    }

    public void save() {
        System.out.println("Choose delimeter  (/ , ;)");
        String delimeter =" ";
        System.out.print("\033[H\033[J");
        Scanner scn = new Scanner(System.in);

                String key1 = scn.nextLine();
            System.out.print("\033[H\033[J");
                switch (key1) {
                    case "/":
                        delimeter = "/";
                        break;
                    case ",":
                        delimeter = ",";
                        break;

                    case ";":
                        delimeter = ";";
                        break;

                    default:
                        delimeter = " ";
                        break;
                }


        try (FileWriter writer = new FileWriter(path, false)) {
            for (int i = 0; i < currentBook.count(); i++) {
                Contact contact = currentBook.getCotact(i);
                writer.append(String.format("%s", contact.firstName + delimeter ));
                writer.append(String.format("%s", contact.lastName + delimeter));
                writer.append(String.format("%s\n", contact.description));
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Phonebook currentBook() {
        return this.currentBook;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public void setCurrentIndex(int value) {
        this.currentIndex = value;
    }
}