package edu.grsu.repository;


import edu.grsu.model.Task;
import edu.grsu.model.enums.TaskStatus;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {

    Iterable<Task> findAllByStatus(TaskStatus taskStatus);

}
