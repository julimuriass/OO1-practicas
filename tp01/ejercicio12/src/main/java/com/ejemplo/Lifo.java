package com.ejemplo;

import java.util.List;

public class Lifo implements Strategy{

    public JobDescription next(List<JobDescription> jobs) {
        if (jobs.isEmpty()) {
            return null;
        } else {
            return jobs.get(jobs.size() - 1);
        }
    }
    
}
