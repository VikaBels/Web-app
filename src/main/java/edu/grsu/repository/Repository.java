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
        tasks=new ArrayList<>();
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

    public Long update(TaskDTO taskDTO){

        for (TaskDTO task: tasks) {
            if(task.getId().equals(taskDTO.getId())){
                task.setStatus(taskDTO.getStatus());
                return task.getId();
            }
        }
        return -1L;
    }

}