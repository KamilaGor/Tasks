package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {//będzie wstrzykiwała do siebie klasę TaskRepository (za pomocą@Autowired)
	@Autowired
	private TaskRepository repository;

	public List<Task> getAllTasks() { //opakowanie dla met findAll z kl.TR, czyli wywołanie tej met.uruchomiFindAll()ZTaksRepo.
		return repository.findAll();
	}

	public Task getTask(Long id) {
		return repository.findById(id).orElse(null); //w klasie CrudRepository Optional<T> findById(Id id)
	}

}
