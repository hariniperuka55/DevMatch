package com.devmatch;

import com.devmatch.model.User;
import com.devmatch.model.Project;
import com.devmatch.model.MatchResult;

import com.devmatch.service.MatchingService;
import com.devmatch.service.TeamFormationService;
import com.devmatch.service.UserSearchService;
import com.devmatch.service.UserFileService;
import com.devmatch.service.ProjectFileService;
import com.devmatch.service.ValidationService;
import com.devmatch.service.UserManagementService;
import com.devmatch.service.ProjectManagementService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // =========================
        // CREATE USERS
        // =========================

        User rahul = new User(
                1,
                "Rahul",
                "rahul@gmail.com",
                2,
                10,
                "Backend Developer"
        );

        rahul.addSkill("Java");
        rahul.addSkill("Spring Boot");
        rahul.addSkill("MySQL");

        rahul.addInterest("Web Development");
        rahul.addInterest("Backend");


        User priya = new User(
                2,
                "Priya",
                "priya@gmail.com",
                1,
                15,
                "ML Engineer"
        );

        priya.addSkill("Python");
        priya.addSkill("Machine Learning");
        priya.addSkill("React");

        priya.addInterest("Artificial Intelligence");
        priya.addInterest("Environment");


        // =========================
        // USER MANAGEMENT
        // =========================

        List<User> users = new ArrayList<>();

        users.add(rahul);
        users.add(priya);

        UserManagementService userManagementService =
                new UserManagementService();


        // CREATE

        User testUser = new User(
                3,
                "Amit",
                "amit@gmail.com",
                2,
                20,
                "Frontend Developer"
        );

        testUser.addSkill("React");
        testUser.addSkill("JavaScript");

        testUser.addInterest("Web Development");


        userManagementService.addUser(
                users,
                testUser
        );

        System.out.println(
                "\nUser added: " + testUser.getName()
        );


        // READ

        User foundUser =
                userManagementService.findUserById(
                        users,
                        3
                );

        if (foundUser != null) {

            System.out.println(
                    "User found: "
                    + foundUser.getName()
            );
        }


        // UPDATE

        User updatedAmit = new User(
                3,
                "Amit",
                "amit_new@gmail.com",
                3,
                25,
                "Full Stack Developer"
        );

        updatedAmit.addSkill("React");
        updatedAmit.addSkill("JavaScript");
        updatedAmit.addSkill("Java");

        updatedAmit.addInterest("Web Development");
        updatedAmit.addInterest("Backend");


        boolean updated =
                userManagementService.updateUser(
                        users,
                        3,
                        updatedAmit
                );

        if (updated) {

            System.out.println(
                    "User updated: "
                    + updatedAmit.getName()
            );
        }


        // DELETE

        boolean deleted =
                userManagementService.deleteUser(
                        users,
                        3
                );

        if (deleted) {

            System.out.println(
                    "User deleted successfully!"
            );
        }


        // =========================
        // VALIDATION
        // =========================

        ValidationService validationService =
                new ValidationService();

        System.out.println("\nUSER VALIDATION");

        for (User user : users) {

            if (validationService.validateUser(user)) {

                System.out.println(
                        user.getName()
                        + " -> Valid"
                );

            } else {

                System.out.println(
                        user.getName()
                        + " -> Invalid"
                );
            }
        }


        // =========================
        // CREATE PROJECT
        // =========================

        Project aiProject = new Project(
                101,
                "AI Waste Detection",
                "Detect waste using Artificial Intelligence",
                1,
                10,
                "ML Engineer"
        );

        aiProject.addRequiredSkill("Java");
        aiProject.addRequiredSkill("Python");
        aiProject.addRequiredSkill("Machine Learning");
        aiProject.addRequiredSkill("React");

        aiProject.addInterest("Artificial Intelligence");
        aiProject.addInterest("Environment");


        // =========================
        // PROJECT VALIDATION
        // =========================

        System.out.println("\nPROJECT VALIDATION");

        if (validationService.validateProject(aiProject)) {

            System.out.println(
                    aiProject.getName()
                    + " -> Valid"
            );

        } else {

            System.out.println(
                    aiProject.getName()
                    + " -> Invalid"
            );
        }


        // =========================
        // PROJECT MANAGEMENT
        // =========================

        List<Project> projects = new ArrayList<>();

        projects.add(aiProject);

        ProjectManagementService projectManagementService =
                new ProjectManagementService();


        // CREATE TEST PROJECT

        Project testProject = new Project(
                102,
                "Smart Campus",
                "Build a smart campus management system",
                2,
                20,
                "Backend Developer"
        );

        testProject.addRequiredSkill("Java");
        testProject.addRequiredSkill("MySQL");
        testProject.addRequiredSkill("React");

        testProject.addInterest("Technology");


        projectManagementService.addProject(
                projects,
                testProject
        );

        System.out.println(
                "\nProject added: "
                + testProject.getName()
        );


        // READ TEST PROJECT

        Project foundProject =
                projectManagementService.findProjectById(
                        projects,
                        102
                );

        if (foundProject != null) {

            System.out.println(
                    "Project found: "
                    + foundProject.getName()
            );
        }


        // =========================
        // PROJECT FILE PERSISTENCE
        // =========================

        ProjectFileService projectFileService =
                new ProjectFileService();


        projectFileService.saveProjects(
                projects,
                "data/projects.txt"
        );

        System.out.println(
                "\nProjects saved successfully!"
        );


        // LOAD PROJECTS

        List<Project> loadedProjects =
                projectFileService.loadProjects(
                        "data/projects.txt"
                );

        System.out.println("\nLOADED PROJECTS");

        for (Project project : loadedProjects) {

            System.out.println(
                    project.getName()
                    + " -> "
                    + project.getRequiredSkills()
            );
        }


        // =========================
        // DISPLAY USER
        // =========================

        System.out.println("\nUSER");

        System.out.println(
                "Name: "
                + rahul.getName()
        );

        System.out.println(
                "Skills: "
                + rahul.getSkills()
        );


        // =========================
        // DISPLAY PROJECT
        // =========================

        System.out.println("\nPROJECT");

        System.out.println(
                "Name: "
                + aiProject.getName()
        );

        System.out.println(
                "Required Skills: "
                + aiProject.getRequiredSkills()
        );


        // =========================
        // MATCHING
        // =========================

        MatchingService matchingService =
                new MatchingService();

        List<MatchResult> results =
                matchingService.findBestMatches(
                        aiProject,
                        users
                );


        for (MatchResult result : results) {

            System.out.println(
                    result.getUser().getName()
                    + " -> "
                    + result.getScore()
                    + "%"
            );
        }


        // =========================
        // RANKING
        // =========================

        System.out.println("\nRANKING");

        int rank = 1;

        for (MatchResult result : results) {

            System.out.println(
                    rank
                    + ". "
                    + result.getUser().getName()
                    + " -> "
                    + result.getScore()
                    + "%"
            );

            System.out.println(
                    "   Matching Skills: "
                    + result.getMatchingSkills()
            );

            System.out.println(
                    "   Missing Skills: "
                    + result.getMissingSkills()
            );

            System.out.println();

            rank++;
        }


        // =========================
        // TEAM FORMATION
        // =========================

        TeamFormationService teamFormationService =
                new TeamFormationService();

        List<User> team =
                teamFormationService.formTeam(
                        aiProject,
                        users
                );

        System.out.println("\nRECOMMENDED TEAM");

        for (User user : team) {

            System.out.println(
                    user.getName()
                    + " -> "
                    + user.getSkills()
            );
        }


        // =========================
        // TEAM SKILL COVERAGE
        // =========================

        List<String> coveredSkills =
                teamFormationService.getCoveredSkills(
                        aiProject,
                        team
                );

        System.out.println(
                "\nTEAM SKILL COVERAGE"
        );

        for (String skill : aiProject.getRequiredSkills()) {

            if (coveredSkills.contains(skill)) {

                System.out.println(
                        skill + " -> Covered"
                );

            } else {

                System.out.println(
                        skill + " -> Missing"
                );
            }
        }

        System.out.println(
                "Coverage: "
                + coveredSkills.size()
                + "/"
                + aiProject.getRequiredSkills().size()
        );


        int teamCoverage =
                teamFormationService.getTeamCoverage(
                        aiProject,
                        team
                );

        System.out.println(
                "Team Coverage: "
                + teamCoverage
                + "%"
        );


        // =========================
        // ADVANCED SEARCH
        // =========================

        UserSearchService userSearchService =
                new UserSearchService();

        List<User> searchResults =
                userSearchService.advancedSearch(
                        users,
                        "Java",
                        "Backend Developer",
                        2,
                        10
                );

        System.out.println(
                "\nADVANCED SEARCH RESULTS"
        );

        for (User user : searchResults) {

            System.out.println(
                    user.getName()
                    + " -> "
                    + user.getRole()
                    + " -> "
                    + user.getSkills()
            );
        }


        // =========================
        // USER FILE PERSISTENCE
        // =========================

        UserFileService userFileService =
                new UserFileService();

        userFileService.saveUsers(
                users,
                "data/users.txt"
        );


        // LOAD USERS

        List<User> loadedUsers =
                userFileService.loadUsers(
                        "data/users.txt"
                );

        System.out.println(
                "\nLOADED USERS"
        );

        for (User user : loadedUsers) {

            System.out.println(
                    user.getName()
                    + " -> "
                    + user.getSkills()
            );
        }

        System.out.println(
                "\nUsers saved successfully!"
        );
    }
}