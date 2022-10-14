package Ex002Phonebook.Core.Infrastructure;

import Ex002Phonebook.Core.Models.Contact;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {

    private List<Contact> contacts;
    
    public Phonebook() {
        contacts = new ArrayList<Contact>();
    }

    // create
    public boolean add(Contact contact) {
        boolean flag = false;
        if (!contacts.contains(contact)) {
            contacts.add(contact);
            flag = true;
        }
        return flag;
    }

    // read
    public Contact getCotact(int index) {
        return contains(index) ? contacts.get(index) : null;
    }

    // update
    // ???...

    // delete
    public boolean remove(Contact contact) {
        boolean flag = false;
        System.out.println("not OK");
        if (contacts.indexOf(contact) != -1) {
            System.out.println("OK");
            contacts.remove(contact);
            System.out.println("true");
            flag = true;
        }
        return flag;
    }


    private boolean contains(int index) {
        return contacts != null
                && contacts.size() > index;
    }

    public List<Contact> getContacts() {
        // if ???...
        return contacts;
    }


    public int count() {
        return contacts.size();
    }

}
