package taskingBoard.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import taskingBoard.Exception.EmptyDataException;
import taskingBoard.Exception.NoTaskFoundException;
import taskingBoard.Exception.NoUserFoundException;
import taskingBoard.model.Task;
import taskingBoard.model.User;
import taskingBoard.repository.TaskRepository;
import taskingBoard.repository.UserRepository;

@Controller
@PreAuthorize("isAuthenticated()")
public class RestController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	TaskRepository taskRepository;

	@GetMapping("/login")
	public String login() {
		return "/login";
	}

	@GetMapping("/newTask")
	public String newTask() {

		return "/newTask";
	}

	@GetMapping("/home")
	public String home() {
		return "/home";
	}

	@GetMapping("/")
	public String home1() {
		// return "redirect:/home?error";
		return "/home";
	}

	@GetMapping("/getalluser")
	@ResponseBody
	public List<User> getAllUser() {
		List<taskingBoard.model.User> list = new ArrayList<User>();
		list = userRepository.findAll();
		if (list.size() == 0)
			throw new NoUserFoundException();
		return list;
	}

	@GetMapping("/getalltasks")
	@ResponseBody
	public List<Task> getAllTasksforUser(final HttpServletRequest request, Principal principal) {
		List<Task> list = new ArrayList<Task>();
		final User user = new User();
		user.setUsername(principal.getName());
		list = taskRepository.findByAssignee(user);
		if (list.size() == 0)
			throw new NoTaskFoundException(principal.getName());
		return list;
	}

	@GetMapping("/gettask")
	@ResponseBody
	public Task getTask(Task newtask) {
		final Task task = taskRepository.getOne(newtask.getId());
		if (task == null) {
			System.out.println("keinen Task gefunden");
			throw new NoTaskFoundException(newtask.getId());
		}
		return task;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/newTask")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<HttpStatus> newTask(Task newtask, final HttpServletRequest request, Principal principal) {
		final User user = userRepository.findByUsername(principal.getName());
		if (user == null) {
			throw new NoUserFoundException();
		}
		if (!stringIsEmpty(newtask.getTitle()) && !stringIsEmpty(newtask.getDescription())
				&& newtask.getAssignee() != null) {
			final Task task = new Task();
			task.setAssignee(newtask.getAssignee());
			task.setTitle(newtask.getTitle());
			task.setDone(false);
			task.setDescription(newtask.getDescription());
			task.setCreator(user);
			taskRepository.save(task);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			System.out.println("Da ist was schief gelaufen");
			throw new EmptyDataException();
		}

	}

	@RequestMapping(method = RequestMethod.POST, value = "/updateTask")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<HttpStatus> updateTask(Task newtask) {
		final Task task = taskRepository.findOne(newtask.getId());
		if (task == null) {
			System.out.println("keinen Task gefunden");
			throw new NoTaskFoundException(newtask.getId());
		} else {
			task.setDone(!task.isDone());
			taskRepository.save(task);
			return new ResponseEntity<>(HttpStatus.OK);

		}

	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No User Found")
	@ExceptionHandler(NoUserFoundException.class)
	public void handleUserNotFound(NoUserFoundException e) {
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Task Found")
	@ExceptionHandler(NoTaskFoundException.class)
	public void handleTaskNotFound(NoTaskFoundException e) {
	}

	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Not all required fields are filled")
	@ExceptionHandler(EmptyDataException.class)
	public void handleEmptyData(EmptyDataException e) {
	}

	// Übernommen aus einer Antwort von Stackoverflow:
	// https://stackoverflow.com/questions/3598770/check-whether-a-string-is-not-null-and-not-empty
	public static boolean stringIsEmpty(final String s) {
		return s == null || s.trim().isEmpty();
	}

}
