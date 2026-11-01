package com.devmatch.service;

import com.devmatch.model.User;
import com.devmatch.model.Project;

public class ValidationService {

    public boolean validateUser(User user) {

        if (user.getId() <= 0) {
            return false;
        }

        if (user.getName() == null
                || user.getName().isEmpty()) {
            return false;
        }

        if (user.getEmail() == null
                || user.getEmail().isEmpty()) {
            return false;
        }

        if (user.getExperience() < 0) {
            return false;
        }

        if (user.getAvailability() < 0
                || user.getAvailability() > 100) {
            return false;
        }

        if (user.getRole() == null
                || user.getRole().isEmpty()) {
            return false;
        }

        return true;
    }

    public boolean validateProject(Project project) {

        if (project.getId() <= 0) {
            return false;
        }

        if (project.getName() == null
                || project.getName().isEmpty()) {
            return false;
        }

        if (project.getDescription() == null
                || project.getDescription().isEmpty()) {
            return false;
        }

        if (project.getRequiredExperience() < 0) {
            return false;
        }

        if (project.getRequiredAvailability() < 0
                || project.getRequiredAvailability() > 100) {
            return false;
        }

        if (project.getRequiredRole() == null
                || project.getRequiredRole().isEmpty()) {
            return false;
        }

        return true;
    }
}