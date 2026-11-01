package com.devmatch.service;

import com.devmatch.model.User;

import java.util.List;

public class UserManagementService {

    // CREATE
    public void addUser(
            List<User> users,
            User user
    ) {
        users.add(user);
    }

    // READ
    public User findUserById(
            List<User> users,
            int id
    ) {

        for (User user : users) {

            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    // UPDATE
    public boolean updateUser(
            List<User> users,
            int id,
            User updatedUser
    ) {

        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getId() == id) {

                users.set(i, updatedUser);
                return true;
            }
        }

        return false;
    }

    // DELETE
    public boolean deleteUser(
            List<User> users,
            int id
    ) {

        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getId() == id) {

                users.remove(i);
                return true;
            }
        }

        return false;
    }
}