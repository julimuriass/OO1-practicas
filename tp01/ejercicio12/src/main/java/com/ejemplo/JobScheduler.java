package com.ejemplo;

import java.util.ArrayList;
import java.util.List;

public class JobScheduler {
    protected List<JobDescription> jobs;
    protected Strategy strategy;

    public JobScheduler () {
        this.jobs = new ArrayList<>();
        this.strategy = new Fifo();
    }

    public JobScheduler(Strategy strategy) {
        this.jobs = new ArrayList<>();
        this.strategy = strategy;
    }


    //El mensaje schedule(job: JobDescription) recibe un job (trabajo) y lo agrega al final de la colección de trabajos pendientes.
    public void schedule(JobDescription job) {
        this.jobs.add(job);
    }

    public void unschedule(JobDescription job) {
        if (job != null) {
            this.jobs.remove(job);
        }
    }

    public Strategy getStrategy() {
        return this.strategy; 
    }

    public List<JobDescription> getJobs(){
        return jobs;
    }

    public void setStrategy(Strategy aStrategy) {
        this.strategy = aStrategy;
    }


    //El mensaje next() determina cuál es el siguiente trabajo de la colección que debe ser atendido, lo retorna, y lo quita de la colección.
    //En la implementación actual del método next(), el JobScheduler utiliza el valor de la variable strategy para determinar cómo elegir el siguiente trabajo.
    public JobDescription next() {
        
        JobDescription nextJob = strategy.next(jobs);
        if (nextJob != null) {
            this.unschedule(nextJob);
            return nextJob;
        } else {
            return null;
        }
    }

}
