package task;
/*
 * The task object shall have a required unique task ID String that cannot be longer than 10 characters. 
 * The task ID shall not be null and shall not be updatable.
The task object shall have a required name String field that cannot be longer than 20 characters. 
The name field shall not be null.
The task object shall have a required description String field that cannot be longer than 50 characters. 
The description field shall not be null.
 */
 
public class Task {

	public static String taskID = "000";
	public static String taskName = "Default Name";
	public static String taskDescriptin = "Default Description";

	public Task(String taskID, String taskName, String taskDescription) {
 
		/////////////////////
		if (taskID == null || taskID.length() > 10) {
			throw new IllegalArgumentException("Invalid Task ID");
		}
		Task.taskID = taskID; 

		if (taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("Invalid Task Name");
		}
		Task.taskName = taskName;

		if (taskDescription == null || taskDescription.length() > 50) { // taskDescription== null ||
			throw new IllegalArgumentException("Invalid Task Description");
		}
		Task.taskDescriptin = taskDescription;

	}

	///////////////////////
	public static String gettaskID() {
		return taskID;
	}

	public String gettaskName() {
		return taskName;
	}

	public String gettaskDescriptin() {
		return taskDescriptin;
	}

	/////////////////////
	public static String setTaskID(String taskID) {
		if (taskID == null || taskID.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		} 
		return Task.taskID = taskID;
	}

	public static void setTaskName(String taskName) {
		if (taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		Task.taskName = taskName;
	}

	public static void setTaskDescription(String taskDescription) {
		if (taskDescription == null || taskDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		Task.taskDescriptin = taskDescription;
	}
}
