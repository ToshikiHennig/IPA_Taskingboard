package taskingBoard.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(length = 31)
	public String username;

	@OneToMany(mappedBy = "assignee")
	private Set<Task> task;

	@OneToMany(mappedBy = "creator")
	private Set<Task> taskcreator;

	public String getUsername() {
		return username;
	}

	public Set<Task> getTask() {
		return task;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
