package edu.grsu.filters;

import edu.grsu.model.enums.TaskStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterDTO {

    private TaskStatus status = TaskStatus.IN_PROGRESS;

}
