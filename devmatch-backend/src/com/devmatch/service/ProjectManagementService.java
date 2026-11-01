package com.devmatch.service;

import com.devmatch.model.Project;

import java.util.List;

public class ProjectManagementService {

    // CREATE
    public void addProject(
            List<Project> projects,
            Project project
    ) {
        projects.add(project);
    }

    // READ
    public Project findProjectById(
            List<Project> projects,
            int id
    ) {

        for (Project project : projects) {

            if (project.getId() == id) {
                return project;
            }
        }

        return null;
    }

    // UPDATE
    public boolean updateProject(
            List<Project> projects,
            int id,
            Project updatedProject
    ) {

        for (int i = 0; i < projects.size(); i++) {

            if (projects.get(i).getId() == id) {

                projects.set(i, updatedProject);
                return true;
            }
        }

        return false;
    }

    // DELETE
    public boolean deleteProject(
            List<Project> projects,
            int id
    ) {

        for (int i = 0; i < projects.size(); i++) {

            if (projects.get(i).getId() == id) {

                projects.remove(i);
                return true;
            }
        }

        return false;
    }
}