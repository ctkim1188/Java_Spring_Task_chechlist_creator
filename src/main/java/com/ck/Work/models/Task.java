package com.ck.Work.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tasks")
public class Task {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min=1, message="Task Name must not be empty")
	private String taskName;
	@Column(nullable=false)
	@Size(min =1, max =3, message = "Task priority cannot be empty")
	private Integer priority;
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    // many to one : many tasks can be created by a user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="creator_id")
    private User creator;
    
    // many to one : many tasks can be assigned to the same person (a users can have many tasks)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="assignee_id")
    @Size(min =1, message = "cannot be empty")
    private User assignee;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
	
	//constructor
    public Task() {
    	
    }

    
    //getters and setters
	public Long getId() {
		return id;
	}

	public String getTaskName() {
		return taskName;
	}

	public Integer getPriority() {
		return priority;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public User getCreator() {
		return creator;
	}

	public User getAssignee() {
		return assignee;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}
    
    
    
    
}
