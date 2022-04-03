package edu.grsu.model;

import edu.grsu.model.enums.TaskStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDTO {

    private Long id;

    private String task;

    private TaskStatus status;

}
