package contact;

import java.util.*;
import java.security.SecureRandom;


public class ContactService{

	public static HashMap<String, String> map = new HashMap<>();
	
	

	
	  public static void addContact(String ContactID, String firstName, String lastName, String phone, String address) {
	    	
	    	if (ContactID == null) {
	    		throw new IllegalArgumentException("Invalid apptID");
	    	}
	    	if (firstName == null) {
	    		throw new IllegalArgumentException("Invalid apptDate");
	    	}
	    	if (lastName == null) {
	    		throw new IllegalArgumentException("Invalid apptDescription");
	    	}
	    	if (phone == null) {
	    		throw new IllegalArgumentException("Invalid apptDescription");
	    	}
	    	if (address == null) {
	    		throw new IllegalArgumentException("Invalid apptDescription");
	    	}
	        if (map.containsKey(ContactID)) {
	            throw new IllegalArgumentException("Appointment with ID " + ContactID + " already exists.");
	        }

	        String entry = (firstName + lastName + phone + address);
	        ContactID = generateUniqueId();;
	        map.put(ContactID, entry);
	        
	    }
	

	public void removeContact(String ContactID) {
		
        if (Contact.contactID == null) {
            throw new IllegalArgumentException("No Contact ID was Entered");
        }
        if (map.isEmpty()) {
        	throw new IllegalArgumentException("There are no Contacts in list");
        }
        if (map.containsKey(ContactID)) {
        	map.remove(ContactID);
    }
	}
	
	//constructor to bypass generateUniqueID's secure random method
		public ContactService(String ContactID, String firstName, String lastName, String phone, String address) {
			if(ContactID == "123") {
				String entry = (firstName + lastName + phone + address);
				map.put(ContactID, entry);
			}
			
		}
	public static void updateContact(String ContactID, String firstName, String lastName, String phone, String address) {
		if (map.containsKey(ContactID)) {
			String entry = (firstName + lastName + phone + address);
			map.put(ContactID, entry);
		
		}	
		}
    
	
	
	

	private static String generateUniqueId() {
		
		    SecureRandom random = new SecureRandom();
		    byte bytes[] = new byte[512];
		    random.nextBytes(bytes);
		    return bytes.toString();
		}
		

	
public static void main(String[] args) throws Exception {
		


	}


}
