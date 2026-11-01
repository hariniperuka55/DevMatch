package com.devmatch.service;

import java.util.Comparator;
import com.devmatch.model.User;
import com.devmatch.model.Project;
import com.devmatch.model.MatchResult;

import java.util.ArrayList;
import java.util.List;

public class MatchingService {

    public MatchResult calculateMatch(User user, Project project) {

        List<String> matchingSkills = new ArrayList<>();
        List<String> missingSkills = new ArrayList<>();

        for (String requiredSkill : project.getRequiredSkills()) {

            boolean hasSkill = user.getSkills()
                    .stream()
                    .anyMatch(userSkill ->
                            userSkill.equalsIgnoreCase(requiredSkill));

            if (hasSkill) {
                matchingSkills.add(requiredSkill);
            } else {
                missingSkills.add(requiredSkill);
            }
        }

        int totalRequiredSkills =
        project.getRequiredSkills().size();

        int skillScore = 0;

        if (totalRequiredSkills > 0) {
            skillScore =
            (matchingSkills.size() * 100)
            / totalRequiredSkills;
        }

    int experienceScore = 0;

if (user.getExperience() >= project.getRequiredExperience()) {
    experienceScore = 100;
}

int matchingInterests = 0;

for (String projectInterest : project.getInterests()) {

    boolean hasInterest = user.getInterests()
            .stream()
            .anyMatch(userInterest ->
                    userInterest.equalsIgnoreCase(projectInterest));

    if (hasInterest) {
        matchingInterests++;
    }
}

int interestScore = 0;

        if (!project.getInterests().isEmpty()) {
        interestScore =
                (matchingInterests * 100)
                / project.getInterests().size();
        }

        int availabilityScore = 0;

        if (user.getAvailability() >= project.getRequiredAvailability()) {
            availabilityScore = 100;
        }

        int roleScore = 0;

        if (user.getRole().equalsIgnoreCase(
                project.getRequiredRole())) {
            roleScore = 100;
        }

        int score =
                (skillScore * 45 / 100)
                + (experienceScore * 20 / 100)
                + (interestScore * 15 / 100)
                + (availabilityScore * 10 / 100)
                + (roleScore * 10 / 100);

        return new MatchResult(
                user,
                score,
                matchingSkills,
                missingSkills
        );
    }

    public List<MatchResult> findBestMatches(
        Project project,
        List<User> users
    ) {

    List<MatchResult> results = new ArrayList<>();

    for (User user : users) {

        MatchResult result =
                calculateMatch(user, project);

        results.add(result);
    }

    results.sort(
            Comparator.comparingInt(MatchResult::getScore)
                    .reversed()
    );

    return results;
    }
}