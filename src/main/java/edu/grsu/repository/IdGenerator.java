package edu.grsu.repository;

import org.springframework.stereotype.Component;

@Component
public class IdGenerator {

    private static long ID_KEY = 3;

    public long generateId(){
        return ID_KEY++;
    }

}

