package com.devmatch.model;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private int id;
    private String name;
    private String description;
    private int requiredExperience;
    private int requiredAvailability;
    private String requiredRole;

    private List<String> requiredSkills = new ArrayList<>();

    private List<String> interests = new ArrayList<>();

    public Project(
        int id,
        String name,
        String description,
        int requiredExperience,
        int requiredAvailability,
        String requiredRole
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.requiredExperience = requiredExperience;
        this.requiredAvailability = requiredAvailability;
        this.requiredRole = requiredRole;
    }

    public void addRequiredSkill(String skill) {
        requiredSkills.add(skill);
    }

    public void addInterest(String interest) {
        interests.add(interest);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    public List<String> getInterests() {
        return interests;
    }

    public int getRequiredExperience() {
        return requiredExperience;
    }

    public int getRequiredAvailability() {
        return requiredAvailability;
    }

    public String getRequiredRole() {
        return requiredRole;
    }
}