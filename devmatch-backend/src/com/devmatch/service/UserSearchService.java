package com.devmatch.service;

import com.devmatch.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserSearchService {

    public List<User> findBySkill(
            List<User> users,
            String skill
    ) {

        List<User> results = new ArrayList<>();

        for (User user : users) {

            for (String userSkill : user.getSkills()) {

                if (userSkill.equalsIgnoreCase(skill)) {
                    results.add(user);
                    break;
                }
            }
        }

        return results;
    }

    public List<User> findByRole(
        List<User> users,
        String role
) {

    List<User> results = new ArrayList<>();

    for (User user : users) {

        if (user.getRole().equalsIgnoreCase(role)) {
            results.add(user);
        }
    }

    return results;
}

public List<User> findByMinimumExperience(
        List<User> users,
        int minimumExperience
) {

    List<User> results = new ArrayList<>();

    for (User user : users) {

        if (user.getExperience() >= minimumExperience) {
            results.add(user);
        }
    }

    return results;
}

public List<User> findByMinimumAvailability(
        List<User> users,
        int minimumAvailability
) {

    List<User> results = new ArrayList<>();

    for (User user : users) {

        if (user.getAvailability() >= minimumAvailability) {
            results.add(user);
        }
    }

    return results;
}

public List<User> advancedSearch(
        List<User> users,
        String skill,
        String role,
        int minimumExperience,
        int minimumAvailability
) {

    List<User> results = new ArrayList<>();

    for (User user : users) {

        boolean hasSkill = false;

        for (String userSkill : user.getSkills()) {

            if (userSkill.equalsIgnoreCase(skill)) {
                hasSkill = true;
                break;
            }
        }

        boolean matchesRole =
                user.getRole().equalsIgnoreCase(role);

        boolean matchesExperience =
                user.getExperience() >= minimumExperience;

        boolean matchesAvailability =
                user.getAvailability() >= minimumAvailability;

        if (hasSkill
                && matchesRole
                && matchesExperience
                && matchesAvailability) {

            results.add(user);
        }
    }

    return results;
}
}