package taskingBoard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import taskingBoard.model.Task;
import taskingBoard.model.User;

@Transactional
public interface TaskRepository extends JpaRepository<Task, Integer> {
	@Transactional(readOnly = true)
	List<Task> findByAssignee(User assignee);

}
