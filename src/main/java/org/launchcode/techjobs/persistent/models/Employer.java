package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {
    @NotBlank(message="Location cannot be left blank.")
    @Size(min = 3,max = 50, message = "Description too long!")
    private String location;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employer_id")
    @NotNull(message = "Employer does not have a jobs field")
    private  List<Job> jobs = new ArrayList<>();

    public Employer(){

    }
    public Employer(String location) {
        this.location = location;
    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

}