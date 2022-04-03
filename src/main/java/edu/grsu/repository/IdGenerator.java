package edu.grsu.repository;

import edu.grsu.model.TaskDTO;
import org.springframework.stereotype.Component;

@Component
public class IdGenerator {

    private static long ID_KEY;

    public long generateId(){
        return ID_KEY++;
    }

}

