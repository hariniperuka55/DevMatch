package com.devmatch.service;

import com.devmatch.model.Project;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ProjectFileService {

    public void saveProjects(
            List<Project> projects,
            String fileName
    ) {

        try {

            FileWriter writer =
                    new FileWriter(fileName);

            for (Project project : projects) {

                writer.write(
                        project.getId()
                        + ","
                        + project.getName()
                        + ","
                        + project.getDescription()
                        + ","
                        + project.getRequiredExperience()
                        + ","
                        + project.getRequiredAvailability()
                        + ","
                        + project.getRequiredRole()
                        + ","
                        + String.join(
                                "|",
                                project.getRequiredSkills()
                        )
                        + ","
                        + String.join(
                                "|",
                                project.getInterests()
                        )
                        + "\n"
                );
            }

            writer.close();

        } catch (IOException e) {

            System.out.println(
                    "Error saving projects: "
                    + e.getMessage()
            );
        }
    }

    public List<Project> loadProjects(String fileName) {

    List<Project> projects = new ArrayList<>();

    try {

        BufferedReader reader =
                new BufferedReader(
                        new FileReader(fileName)
                );

        String line;

        while ((line = reader.readLine()) != null) {

            String[] data = line.split(",");

            Project project = new Project(
                    Integer.parseInt(data[0]),
                    data[1],
                    data[2],
                    Integer.parseInt(data[3]),
                    Integer.parseInt(data[4]),
                    data[5]
            );

            String[] skills = data[6].split("\\|");

            for (String skill : skills) {
                project.addRequiredSkill(skill);
            }

            String[] interests = data[7].split("\\|");

            for (String interest : interests) {
                project.addInterest(interest);
            }

            projects.add(project);
        }

        reader.close();

    } catch (IOException e) {

        System.out.println(
                "Error loading projects: "
                + e.getMessage()
        );
    }

    return projects;
}
}