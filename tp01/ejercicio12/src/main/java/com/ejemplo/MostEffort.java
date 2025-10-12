package com.ejemplo;

import java.util.List;

public class MostEffort implements Strategy {

    public JobDescription next(List<JobDescription> jobs){
        if (jobs.isEmpty()) {
            return null;
        } else {
            return jobs.stream()
                    .max((j1,j2) -> Double.compare(j1.getEffort(), j2.getEffort()))
                    .orElse(null);
        }
    }
    
}
