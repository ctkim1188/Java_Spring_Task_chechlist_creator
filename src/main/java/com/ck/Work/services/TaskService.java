package com.ck.Work.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ck.Work.models.Task;
import com.ck.Work.repositories.TaskRepository;

@Service
public class TaskService {
	private final TaskRepository tskRepo;
	
	public TaskService(TaskRepository tskRepo) {
		this.tskRepo = tskRepo;
	}
	
	// create a task
	public Task createTask(Task myTask) {
		return tskRepo.save(myTask);
	}
	
	// get all tasks and return as a List<Task>
	public List<Task> getAll() {
		return (List<Task>) tskRepo.findAll();
	}
	
	// find a task by id
	public Task findTask(Long id) {
		Optional<Task> mytask = tskRepo.findById(id);
		if (mytask.isPresent()) {
			return mytask.get();
		}else {
			System.out.println("no task you are looking for");
			return null;
		}
	}
	
	// Delete task
	public void deleteTask(Long myId) {
		tskRepo.deleteById(myId);
	}
	
	// Update task
	public void updateTask(Task myTask) {
		tskRepo.save(myTask);
	}
	
	//List all tasks by ASC priority
	public List<Task> lowToHigh(){
		return tskRepo.findAllPriorityLowToHigh();
	}
	
	//List all Tasks by DESC priority
	public List<Task> highToLow(){
		return tskRepo.findAllPriorityHighToLow();
	}
}
