package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {//konwerter mapujący typ Task na Task Dto i odwrotnie i mapowanie dla list ob. Taks (List<Task> na List<TaskDto>)
	public Task mapToTask(final TaskDto taskDto) {
		return new Task(
				taskDto.getId(),
				taskDto.getTitle(),
				taskDto.getContent());
	}

	public TaskDto mapToTaskDto(final Task task) {
		return new TaskDto(
				task.getId(),
				task.getTitle(),
				task.getTitle());
	}

	public List<TaskDto> mapToTaskDtoToList(final List<Task> taskList) {
		return taskList.stream()
				.map(t -> new TaskDto(t.getId(), t.getTitle(), t.getContent()))
				.collect(Collectors.toList());
	}
}
