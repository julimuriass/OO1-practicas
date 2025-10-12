package com.ejemplo;

import java.util.List;

public interface Strategy {
    
    JobDescription next(List<JobDescription> jobs);
}
