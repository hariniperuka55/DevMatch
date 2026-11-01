package com.devmatch;

import com.devmatch.model.User;
import com.devmatch.model.Project;
import com.devmatch.model.MatchResult;

import com.devmatch.service.UserFileService;
import com.devmatch.service.ProjectFileService;
import com.devmatch.service.MatchingService;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;

public class ApiServer {

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(
                new InetSocketAddress(8080),
                0
        );


        // ==========================================
        // USERS API
        // ==========================================

        server.createContext("/api/users", exchange -> {

            UserFileService userFileService =
                    new UserFileService();

            List<User> users =
                    userFileService.loadUsers(
                            "data/users.txt"
                    );

            StringBuilder json =
                    new StringBuilder();

            json.append("[");

            for (int i = 0; i < users.size(); i++) {

                User user = users.get(i);

                json.append("{");

                json.append("\"id\":")
                        .append(user.getId())
                        .append(",");

                json.append("\"name\":\"")
                        .append(user.getName())
                        .append("\",");

                json.append("\"email\":\"")
                        .append(user.getEmail())
                        .append("\",");

                json.append("\"experience\":")
                        .append(user.getExperience())
                        .append(",");

                json.append("\"availability\":")
                        .append(user.getAvailability())
                        .append(",");

                json.append("\"role\":\"")
                        .append(user.getRole())
                        .append("\"");

                json.append("}");

                if (i < users.size() - 1) {
                    json.append(",");
                }
            }

            json.append("]");

            sendJsonResponse(
                    exchange,
                    json.toString()
            );
        });


        // ==========================================
        // PROJECTS API
        // ==========================================

        server.createContext("/api/projects", exchange -> {

            ProjectFileService projectFileService =
                    new ProjectFileService();

            List<Project> projects =
                    projectFileService.loadProjects(
                            "data/projects.txt"
                    );

            StringBuilder json =
                    new StringBuilder();

            json.append("[");

            for (int i = 0; i < projects.size(); i++) {

                Project project = projects.get(i);

                json.append("{");

                json.append("\"id\":")
                        .append(project.getId())
                        .append(",");

                json.append("\"name\":\"")
                        .append(project.getName())
                        .append("\",");

                json.append("\"description\":\"")
                        .append(project.getDescription())
                        .append("\",");

                json.append("\"requiredExperience\":")
                        .append(project.getRequiredExperience())
                        .append(",");

                json.append("\"requiredAvailability\":")
                        .append(project.getRequiredAvailability())
                        .append(",");

                json.append("\"requiredRole\":\"")
                        .append(project.getRequiredRole())
                        .append("\",");

                json.append("\"requiredSkills\":[");

                for (int j = 0;
                     j < project.getRequiredSkills().size();
                     j++) {

                    json.append("\"")
                            .append(
                                    project.getRequiredSkills().get(j)
                            )
                            .append("\"");

                    if (j < project.getRequiredSkills().size() - 1) {
                        json.append(",");
                    }
                }

                json.append("]");

                json.append("}");

                if (i < projects.size() - 1) {
                    json.append(",");
                }
            }

            json.append("]");

            sendJsonResponse(
                    exchange,
                    json.toString()
            );
        });


        // ==========================================
        // MATCHING API
        // ==========================================

        server.createContext("/api/matches", exchange -> {

            String query =
                    exchange.getRequestURI()
                            .getQuery();

            int projectId = -1;

            if (query != null) {

                String[] parameters =
                        query.split("=");

                if (parameters.length == 2) {

                    projectId =
                            Integer.parseInt(
                                    parameters[1]
                            );
                }
            }


            // Load users

            UserFileService userFileService =
                    new UserFileService();

            List<User> users =
                    userFileService.loadUsers(
                            "data/users.txt"
                    );


            // Load projects

            ProjectFileService projectFileService =
                    new ProjectFileService();

            List<Project> projects =
                    projectFileService.loadProjects(
                            "data/projects.txt"
                    );


            // Find requested project

            Project selectedProject = null;

            for (Project project : projects) {

                if (project.getId() == projectId) {

                    selectedProject = project;
                    break;
                }
            }


            if (selectedProject == null) {

                sendJsonResponse(
                        exchange,
                        "{\"error\":\"Project not found\"}"
                );

                return;
            }


            // Run matching algorithm

            MatchingService matchingService =
                    new MatchingService();

            List<MatchResult> results =
                    matchingService.findBestMatches(
                            selectedProject,
                            users
                    );


            // Build JSON

            StringBuilder json =
                    new StringBuilder();

            json.append("[");


            for (int i = 0; i < results.size(); i++) {

                MatchResult result =
                        results.get(i);

                User user =
                        result.getUser();

                json.append("{");

                json.append("\"userId\":")
                        .append(user.getId())
                        .append(",");

                json.append("\"name\":\"")
                        .append(user.getName())
                        .append("\",");

                json.append("\"role\":\"")
                        .append(user.getRole())
                        .append("\",");

                json.append("\"score\":")
                        .append(result.getScore())
                        .append(",");


                // Matching skills

                json.append("\"matchingSkills\":[");

                for (
                        int j = 0;
                        j < result.getMatchingSkills().size();
                        j++
                ) {

                    json.append("\"")
                            .append(
                                    result.getMatchingSkills().get(j)
                            )
                            .append("\"");

                    if (
                            j <
                            result.getMatchingSkills().size() - 1
                    ) {
                        json.append(",");
                    }
                }

                json.append("],");


                // Missing skills

                json.append("\"missingSkills\":[");

                for (
                        int j = 0;
                        j < result.getMissingSkills().size();
                        j++
                ) {

                    json.append("\"")
                            .append(
                                    result.getMissingSkills().get(j)
                            )
                            .append("\"");

                    if (
                            j <
                            result.getMissingSkills().size() - 1
                    ) {
                        json.append(",");
                    }
                }

                json.append("]");

                json.append("}");


                if (i < results.size() - 1) {
                    json.append(",");
                }
            }

            json.append("]");


            sendJsonResponse(
                    exchange,
                    json.toString()
            );
        });


        // ==========================================
        // START SERVER
        // ==========================================

        server.start();

        System.out.println(
                "DevMatch API Server started!"
        );

        System.out.println(
                "Running at: http://localhost:8080"
        );
    }


    // ==========================================
    // SEND JSON RESPONSE
    // ==========================================

    private static void sendJsonResponse(
            com.sun.net.httpserver.HttpExchange exchange,
            String response
    ) throws IOException {

        exchange.getResponseHeaders()
                .add(
                        "Content-Type",
                        "application/json"
                );

        exchange.getResponseHeaders()
                .add(
                        "Access-Control-Allow-Origin",
                        "*"
                );

        exchange.sendResponseHeaders(
                200,
                response.getBytes().length
        );

        OutputStream outputStream =
                exchange.getResponseBody();

        outputStream.write(
                response.getBytes()
        );

        outputStream.close();
    }
}