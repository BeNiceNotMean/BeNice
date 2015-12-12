package ec327.benice;
import java.util.ArrayList;

/**
 * Created by ericmooney on 12/1/15.
 */

public class Globals{
    private static Globals instance;

    // Global variable
    private ArrayList<Contact> contacts_sent = new ArrayList<Contact>();
    private ArrayList<Compliment> messages_sent = new ArrayList<Compliment>();

    // Restrict the constructor from being instantiated
    private Globals(){}

    public void add_contacts_sent(Contact contact){
        this.contacts_sent.add(contact);
    }

    public ArrayList<Contact> get_contacts_sent(){
        return this.contacts_sent;
    }

    public void add_messages_sent(Compliment compliment){
        this.messages_sent.add(compliment);
    }

    public ArrayList<Compliment> get_messages_sent(){
        return this.messages_sent;
    }

    public void clear_contacts(){
        this.contacts_sent.clear();
    }

    public void clear_messages(){
        this.messages_sent.clear();
    }

    public static synchronized Globals getInstance(){
        if(instance==null){
            instance=new Globals();
        }
        return instance;
    }
}