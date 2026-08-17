import java.util.*;


public class ContactManager {
    public static void main(String[] args){
        HashMap<String, Contact> contacts = new HashMap<>();

        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.put("Ash William", new Contact("Ash William", "+1 327 525 2131"));
        contacts.put("Bob Armin", new Contact("Bob Armin", "+1 627 545 0561"));
        contacts.put("Betty Tualip", new Contact("Betty Tualip", "+1 706 555 0203"));
        contacts.put("Carl Winslow", new Contact("Carl Winslow", "+1 867 865 5309"));
        
         
        if(contacts.get("Noname") == null){
            System.err.println("Contact not found");
        }else{
            System.out.println(contacts.get("Ada Lovelace"));
        }

        if(contacts.get("Ada Lovelace") == null){
            System.err.println("Contact not found");
        }else{
            System.out.println(contacts.get("Ada Lovelace"));
        }


        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a,b) -> a.getName().compareTo(b.getName()));

        System.out.println("=== All Contacts ===");
        for(int i = 0; i < sorted.size(); i++){
            System.out.println(sorted.get(i));
        }

        contacts = removeContact("Carl Winslow", contacts);

        ArrayList<Contact> sorted2 = new ArrayList<>(contacts.values());
        sorted2.sort((a,b) -> a.getName().compareTo(b.getName()));

        System.out.println("=== All Contacts ===");
        for(int i = 0; i < sorted2.size(); i++){
            System.out.println(sorted2.get(i));
        }

    }

    public static HashMap<String,Contact> removeContact(String name, HashMap<String,Contact> contacts){

        contacts.remove(name);

        return contacts;
    }
}
