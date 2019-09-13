package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/task")
public class TaskController {
	@Autowired //wsktrzyknięcieDbService i wywołanie z niego metody getAllTasks()
	private DbService service;
	@Autowired // wstrzyknięcie TaskMapper i dokaonaie mapowania z typu list<Task> na List<TaskDto>
	private TaskMapper taskMapper;

	@RequestMapping(method = RequestMethod.GET, value = "getTasks")
	public List<TaskDto> getTasks() {
		return new ArrayList<>();
	}

	@RequestMapping(method = RequestMethod.GET, value = "getTask")
	public TaskDto getTask(@RequestParam Long taskId) throws TaskNotFoundException {
		return taskMapper.mapToTaskDto(service.getTask(taskId).orElseThrow(TaskNotFoundException::new));
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "deleteTask")
	public void deleteTask(@RequestParam Long taskId) {
		System.out.println("Task is deleted");
	}

	@RequestMapping(method = RequestMethod.PUT, value = "updateTask")
	public TaskDto updateTask(@RequestBody TaskDto taskDto) {
		return taskMapper.mapToTaskDto(service.saveTask(taskMapper.mapToTask(taskDto)));
	}

	@RequestMapping(method = RequestMethod.POST, value = "createTask", consumes = APPLICATION_JSON_VALUE)
	public void createTask(@RequestBody TaskDto taskDto) {
		service.saveTask(taskMapper.mapToTask(taskDto));
	}
}
