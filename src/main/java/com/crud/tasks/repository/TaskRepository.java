package com.crud.tasks.repository;

import com.crud.tasks.domain.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {//udostępnia met i ligikę pobierania danych z b.d.
	@Override
	List<Task> findAll();
}
