package taskingBoard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 45)
	private String title;

	@Column(columnDefinition = "TEXT")
	private String description;

	@ManyToOne
	@JoinColumn(name = "assignee", nullable = false)
	@JsonBackReference
	private User assignee;

	@ManyToOne
	@JoinColumn(name = "creator", nullable = false)
	@JsonBackReference
	private User creator;

	private boolean done;

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public User getAssignee() {
		return assignee;
	}

	public User getCreator() {
		return creator;
	}

	public boolean isDone() {
		return done;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

}
