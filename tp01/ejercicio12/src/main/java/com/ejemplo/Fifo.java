package com.ejemplo;

import java.util.List;

public class Fifo implements Strategy{

    public JobDescription next(List<JobDescription> jobs) {
        if (jobs.isEmpty()) {
            return null;
        } else {
            return jobs.get(0);
        }
    }
}


