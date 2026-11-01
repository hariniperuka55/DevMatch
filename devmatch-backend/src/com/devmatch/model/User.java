package com.devmatch.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String name;
    private String email;
    private int experience;
    private int availability;
    private String role;

    private List<String> skills = new ArrayList<>();
    private List<String> interests = new ArrayList<>();

    public User(
        int id,
        String name,
        String email,
        int experience,
        int availability,
        String role
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.experience = experience;
        this.availability = availability;
        this.role = role;
    }

    public void addSkill(String skill) {
        skills.add(skill);
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

    public String getEmail() {
        return email;
    }

    public List<String> getSkills() {
        return skills;
    }

    public List<String> getInterests() {
        return interests;
    }

    public int getExperience() {
        return experience;
    }

    public int getAvailability() {
        return availability;
    }

    public String getRole() {
        return role;
    }
}