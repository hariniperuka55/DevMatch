package com.devmatch.model;

import java.util.List;

public class MatchResult {

    private User user;
    private int score;

    private List<String> matchingSkills;
    private List<String> missingSkills;

    public MatchResult(
            User user,
            int score,
            List<String> matchingSkills,
            List<String> missingSkills
    ) {
        this.user = user;
        this.score = score;
        this.matchingSkills = matchingSkills;
        this.missingSkills = missingSkills;
    }

    public User getUser() {
        return user;
    }

    public int getScore() {
        return score;
    }

    public List<String> getMatchingSkills() {
        return matchingSkills;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }
}