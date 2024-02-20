package appointment;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;


public class AppointmentService {
	
    public static HashMap<String, String> appointments = new HashMap<>();

    protected static LocalDate checkDate;
    protected static LocalDate today = LocalDate.now();
    static String entry = " ";

    public static LocalDate convertDate(String Date) {
    	LocalDate newformat;
    	DateTimeFormatter format = DateTimeFormatter.ofPattern( "dd/MM/uuuu" );
		newformat = LocalDate.parse( Date , format );
		
		return newformat;
    	
    }
    
    public static void addAppt(String apptID, String apptDate, String apptDescription) {
    	
    	if (apptID == null) {
    		throw new IllegalArgumentException("Invalid apptID");
    	}
    	if (apptID.length() > 10) {
    		throw new IllegalArgumentException("Long apptID");
    	}
    	if (apptDate == null) {
    		throw new IllegalArgumentException("Invalid apptDate");
    	}
    	
    	if (apptDescription == null) {
    		throw new IllegalArgumentException("Invalid apptDescription");
    	}
        if (appointments.containsKey(apptID)) {
            throw new IllegalArgumentException("Appointment with ID " + apptID + " already exists.");
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern( "dd/MM/uuuu" );
		checkDate = LocalDate.parse( apptDate , format );
    	
		if(checkDate.isBefore(today)) {
			throw new IllegalArgumentException("Date must be in the future");
		}
		
        entry = Appointment.getAppointmentDate() + " " + Appointment.getAppointmentDescription();
        apptID =Appointment.getAppointmentID();
        getappointments().put(apptID, entry);
        
    }
    public static void removeAppt(String apptID) {
    	if (appointments.containsKey(apptID)) {
    		appointments.remove(apptID);
    	}
    }

    public static HashMap<String, String> getappointments() {
		
		return appointments;
	}

    public static void setAppointments(HashMap<String, String> appointments) {
    	AppointmentService.appointments = appointments;
    }
}
