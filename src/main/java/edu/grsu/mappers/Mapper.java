package edu.grsu.mappers;

import edu.grsu.model.Task;
import edu.grsu.dtos.TaskDTO;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static Task toEntity(TaskDTO taskDTO){
        Task task = new Task();

        task.setId(taskDTO.getId());
        task.setTask(taskDTO.getTask());
        task.setStatus(taskDTO.getStatus());

        return task;
    }

    public static TaskDTO toDTO(Task task){
        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setId(task.getId());
        taskDTO.setTask(task.getTask());
        taskDTO.setStatus(task.getStatus());

        return taskDTO;
    }

    public static List<TaskDTO> toListDTO(Iterable<Task> tasks){
        List<TaskDTO> taskDTOS = new ArrayList<>();

        for (Task task : tasks){
            TaskDTO taskDTO = toDTO(task);
            taskDTOS.add(taskDTO);
        }

        return taskDTOS;
    }

}
