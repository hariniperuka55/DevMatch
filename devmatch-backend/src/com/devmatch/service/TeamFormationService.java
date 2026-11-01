package com.devmatch.service;

import com.devmatch.model.Project;
import com.devmatch.model.User;

import java.util.ArrayList;
import java.util.List;

public class TeamFormationService {

    public List<User> formTeam(
            Project project,
            List<User> users
    ) {

        List<User> team = new ArrayList<>();

        List<String> coveredSkills = new ArrayList<>();

        for (User user : users) {

            if (coveredSkills.size() == project.getRequiredSkills().size()) {
                break;
            }

            boolean contributes = false;

            for (String skill : user.getSkills()) {

                for (String requiredSkill : project.getRequiredSkills()) {

                    if (skill.equalsIgnoreCase(requiredSkill)
                        && !coveredSkills.contains(requiredSkill)) {

                    coveredSkills.add(requiredSkill);
                    contributes = true;
                        }
                }
             }

            if (contributes) {
            team.add(user);
            }
        }
        
        if (coveredSkills.size() < project.getRequiredSkills().size()) {
            System.out.println("Warning: Team does  not cover all required skills.");
        }
        return team;
    }

    public List<String> getCoveredSkills(
        Project project,
        List<User> team
) {

    List<String> coveredSkills = new ArrayList<>();

    for (User user : team) {

        for (String skill : user.getSkills()) {

            for (String requiredSkill : project.getRequiredSkills()) {

                if (skill.equalsIgnoreCase(requiredSkill)
                        && !coveredSkills.contains(requiredSkill)) {

                    coveredSkills.add(requiredSkill);
                }
            }
        }
    }

    return coveredSkills;
}

public int getTeamCoverage(
        Project project,
        List<User> team
) {

    List<String> coveredSkills =
            getCoveredSkills(project, team);

    if (project.getRequiredSkills().isEmpty()) {
        return 0;
    }

    return (coveredSkills.size() * 100)
            / project.getRequiredSkills().size();
}
}