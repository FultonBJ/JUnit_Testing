package contact;

///////////////////////////////////
///// CS320 			///////////
///// SNHU				///////////
///// Brian Fulton		///////////
///////////////////////////////////

/////////////////////////////////
//Contact Class Requirements   //
/////////////////////////////////

//contact object shall have a unique contact iD String 
//contact id < 11 characters. 
//contact iD shall not be null 
//contact id shall not be updatable.

//contact object shall have firstName String 
//firstName < 11 characters. 
//firstName shall not be null.

//contact object shall have lastName String 
//lastName < 11 characters. 
//lastName field shall not be null.

//contact object shall have phone String 
//phone String = 10 digits. 
//phone String shall not be null.

//contact object shall have address String
//address < 31 characters. 
//address shall not be null.

public class Contact {
 
protected static String firstName;
protected static String lastName;
protected static String contactID;
protected static String phone;
protected static String address;

public Contact(String contactID, String firstName, String lastName, String phone, String address) {

if(contactID== null || contactID.length() > 10 ) {
throw new IllegalArgumentException("Invalid contactID");
}

if(firstName == null || firstName.length() > 10 ) {
throw new IllegalArgumentException("Invalid First Name");
}


if(lastName == null || lastName.length() > 10 ) {
throw new IllegalArgumentException("Invalid Last Name");
}

if(phone == null || phone.length() != 10 ) {
throw new IllegalArgumentException("Invalid Phone Number");
}

if(address == null || address.length() > 30 ) {
throw new IllegalArgumentException("Invalid Address");
}

Contact.contactID = contactID;
Contact.firstName = firstName;
Contact.lastName = lastName;
Contact.phone = phone;
Contact.address = address;
}

public static String getId() {
return contactID;
}

public static String getFirstName() {
return firstName;
}

public static String getLastName() {
return lastName;
}

public static String getPhone() {
return phone;
}

public static String getAddress() {
return address;
}


public static String setFirstName(String firstName) {
if(firstName == null || firstName.length() > 10 ) {
throw new IllegalArgumentException("Invalid First Name");
}
return firstName;

}

public static String setLastName(String lastName) {
if(lastName == null || lastName.length() > 10 ) {
throw new IllegalArgumentException("Invalid Last Name");
}
return lastName;

}


public static String setPhoneNumber(String phone) {
if(phone == null || phone.length() != 10 ) {
throw new IllegalArgumentException("Invalid Phone Number");
}
return phone;
}

public static String setAddress(String address) {
if(address == null || address.length() > 30 ) {
throw new IllegalArgumentException("Invalid Address");
}
return address;
}

}
