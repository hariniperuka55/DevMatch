package com.devmatch.service;

import com.devmatch.model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;


public class UserFileService {

    public void saveUsers(
            List<User> users,
            String fileName
    ) {

        try {

            FileWriter writer =
                    new FileWriter(fileName);

            for (User user : users) {

                writer.write(
        user.getId()
        + ","
        + user.getName()
        + ","
        + user.getEmail()
        + ","
        + user.getExperience()
        + ","
        + user.getAvailability()
        + ","
        + user.getRole()
        + ","
        + String.join("|", user.getSkills())
        + ","
        + String.join("|", user.getInterests())
        + "\n"
);
            }

            writer.close();

        } catch (IOException e) {

            System.out.println(
                    "Error saving users: "
                    + e.getMessage()
            );
        }
    }

    public List<User> loadUsers(String fileName) {

    List<User> users = new ArrayList<>();

    try {

        BufferedReader reader =
                new BufferedReader(
                        new FileReader(fileName)
                );

        String line;

        while ((line = reader.readLine()) != null) {

            String[] data = line.split(",");

            User user = new User(
                    Integer.parseInt(data[0]),
                    data[1],
                    data[2],
                    Integer.parseInt(data[3]),
                    Integer.parseInt(data[4]),
                    data[5]
            );

            String[] skills = data[6].split("\\|");

for (String skill : skills) {
    user.addSkill(skill);
}

String[] interests = data[7].split("\\|");

for (String interest : interests) {
    user.addInterest(interest);
}

            users.add(user);
        }

        reader.close();

    } catch (IOException e) {

        System.out.println(
                "Error loading users: "
                + e.getMessage()
        );
    }

    return users;
}
}