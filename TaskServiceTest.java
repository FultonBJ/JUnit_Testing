package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Spliterator;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import task.task;
import task.taskService;

public class TestTaskService {
	
	private String TaskID = "123";
	private String TaskName = "Name";
	private String TaskDescription = "Description";
 
	


	@Test
	void TestNullTaskName() {
		taskService service = new taskService();
		assertThrows(IllegalArgumentException.class, () -> 
	    service.addTask(null, TaskDescription));
	    
	  }
	  @Test
	  void TestlongTaskName() {
	    taskService service = new taskService();
	    assertThrows(IllegalArgumentException.class, () -> 
	    service.addTask("Task Name Must be fewer than twenty characters", TaskDescription));
	  }
 
	@Test
	  void TestupdateTaskName() {
	    taskService service = new taskService();
	    service.addTask(TaskName, TaskDescription);
	    TaskID = task.getTaskID();
	    service.updateTaskName(TaskID, "newName");
	    assertFalse(service.GetTaskList().contains(TaskID));
	    	
	    
	  }

	  @Test
	  void TestlongDescription() {
	    taskService service = new taskService();
	    assertThrows(IllegalArgumentException.class, () -> 
	    service.addTask(null, TaskDescription));
	  }
	   
	  @Test
	  void TestlongTaskDescription() {
	    taskService service = new taskService();
	    assertThrows(IllegalArgumentException.class, () -> 
	    service.addTask(TaskName, "Task Description must be fewer than fifty characters"));
	  }

	  @Test
	  void TestfindTaskNotFound() {
		  taskService service = new taskService();
		  assertThrows(IllegalArgumentException.class, () -> 
		  service.findTask("A48484848"));
	  }
	  
	   
	  @Test
	  void TesttaskID() {
		  taskService service = new taskService();  
		   service.addTask(TaskName, TaskDescription);
		   assertEquals(TaskID, service.GetTaskList().get(0).getTaskID());
		  
	  }

	  @Test
	  void TestremoveTask() {
	 	taskService service = new taskService();
		service.addTask(TaskName, TaskDescription);
		assertFalse(service.GetTaskList().contains(TaskID));

	}
}

/*
 *   @Test
	  void TestupdateTaskDescription() throws Exception {
	    taskService service = new taskService();
	    service.newTask(taskID);
	    service.updateTaskDescription("654", "Name", "Description");
	    assertTrue(service.searchForTask("654").equals(service.searchForTask("654")));
	  }
 * 
*/
