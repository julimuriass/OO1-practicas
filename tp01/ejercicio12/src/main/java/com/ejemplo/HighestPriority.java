package com.ejemplo;

import java.util.List;

public class HighestPriority implements Strategy {

    public JobDescription next(List<JobDescription> jobs) {
        if (jobs.isEmpty()) {
            return null;
        } else {
            //Recorrer jobs y quedarme con el de más prioridad.
            return jobs.stream()
                            .max((j1, j2)-> Double.compare(
                                 j1.getPriority(), j2.getPriority()))
                            .orElse(null);
        }
    }
    
}
