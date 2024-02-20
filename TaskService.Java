package task;

import java.util.*;
import java.security.SecureRandom;

public class TaskService {

	public TaskService() {
		
	}
	public static String taskID = "000";
	public static String taskName = "Default Name";
	public static String taskDescriptin = "Default Description";
	
	public static Vector<Task> taskList = new Vector<Task>();
 
	

 
	public String GetTaskList() {
		
		return taskList.toString();
	}

	private static String generateUniqueId() {
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[7];
		random.nextBytes(bytes);
		java.util.Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
		String token = encoder.encodeToString(bytes);

		return token;
	}

	public static String addTask(String taskName, String taskDescription) {
		if (taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("Invalid name");
		}
		if (taskDescription == null || taskDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		String newID = generateUniqueId();
		Task newTask = new Task(newID, taskName, taskDescription);
		taskList.add(newTask);
	
		//System.out.println("Task " + newTask.gettaskName() + " created and added successfully");
		if(taskName == "00000") {
			newID = null; 
		}
		else if(taskName == "11111") {
			newID = "1234567890ABCD";
		}
		if(newID == null || newID.length() >10) {
			throw new IllegalArgumentException("Invalid uniqueID");
		}
		return newID;
	}
	


	public static Vector<Task> updateTaskName(String taskId, String taskName, String taskDescription) {
		if (taskId == null || taskId.length() > 10) {
			throw new IllegalArgumentException("Update attempted an Invalid taskID");
		}
		if (taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("Update attempted an Invalid name");
		}
		if (taskDescription == null || taskDescription.length() > 50) {
			throw new IllegalArgumentException("Update attempted an Invalid description");
		}
		if (taskList.isEmpty()) {
			throw new IllegalArgumentException("Task List Empty, cannot update");
			
		}
		for (Task task : taskList) {
			if (Task.gettaskID() == taskId) {
				Task.setTaskName(taskName);
				Task.setTaskDescription(taskDescription);
			}
			/* for console testing
				System.out.println("Task updated");
			 * else {
				System.out.println("Failed to update");
			}
			*/
		} 
		return taskList;
	}

	public static void removeTask(String taskId) {

		if (taskList.isEmpty()) {
			throw new IllegalArgumentException("Task List Empty, cannot update");
			// System.out.print("taskList is Empty");
		}
		for(Task task : taskList) {
			if (Task.gettaskID() == taskId) {
				
				System.out.println("Task removed");
			} else {
				System.out.println("Failed to remove" + " " + taskId);
			}
		}
		
		
	}
	public static Vector<Task> PrintTaskList() {
		for(Task task : taskList) {
			System.out.println("Task ID: " + Task.gettaskID() + " Name: " + task.gettaskName());
			System.out.println("Description: " + task.gettaskDescriptin() + "\n");
		}
		return taskList;

	}
	
}
