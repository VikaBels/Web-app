package edu.grsu.repository;

import edu.grsu.filters.FilterDTO;
import edu.grsu.model.TaskDTO;
import edu.grsu.model.enums.TaskStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Repository {

    private List<TaskDTO> tasks;

    @Autowired
    private IdGenerator idGenerator;

    public Repository(){
        tasks = new ArrayList<>();
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTask("Поти гулть");
        taskDTO.setStatus(TaskStatus.COMPLETED);
        taskDTO.setId(0L);
        tasks.add(taskDTO);
        TaskDTO taskDTO1 = new TaskDTO();
        taskDTO1.setTask("Уйти гулять");
        taskDTO1.setStatus(TaskStatus.IN_PROGRESS);
        taskDTO1.setId(1L);
        tasks.add(taskDTO1);
        TaskDTO taskDTO3 = new TaskDTO();
        taskDTO3.setTask("aubdinadinaxiaij");
        taskDTO3.setStatus(TaskStatus.DELETED);
        taskDTO3.setId(1L);
        tasks.add(taskDTO3);

    }

    public Long create(TaskDTO taskDTO){
        taskDTO.setStatus(TaskStatus.IN_PROGRESS);
        taskDTO.setId(idGenerator.generateId());
        tasks.add(taskDTO);
        return taskDTO.getId();
    }

    public void delete(Long id){
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getId().equals(id)){
                tasks.remove(i);
                break;
            }
        }
    }

    public List<TaskDTO> getTasks(FilterDTO filterDTO){

        List<TaskDTO> selected = new ArrayList<>();

        for (TaskDTO task : tasks) {
            if (task.getStatus() == filterDTO.getStatus()) {
                selected.add(task);
            }
        }

        return selected;
    }

}