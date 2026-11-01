# 🚀 DevMatch

### Smart Team Formation & Project Matching Platform

**DevMatch** is a project-matching and team-formation platform that connects developers with suitable projects and teammates based on their **skills, experience, interests, availability, and role**.

The system uses a weighted matching algorithm to calculate compatibility scores and recommend the most suitable candidates for each project.

---

## ✨ Features

- 👤 User profile management
- 📋 Project browsing
- 🔍 User search and filtering
- 🤝 Intelligent teammate matching
- 📊 Compatibility score calculation
- 🧩 Matching skills and missing skills analysis
- 👥 Team formation based on project requirements
- 💾 File-based data persistence
- 🌐 React frontend integrated with a Java backend
- ⚡ REST-style HTTP API
- 🎨 Modern midnight + purple user interface

---

## 🧠 Matching Algorithm

DevMatch calculates a compatibility score using multiple factors:

| Factor | Weight |
|---|---:|
| Skills | 45% |
| Experience | 20% |
| Interests | 15% |
| Availability | 10% |
| Role | 10% |

The final score is used to rank candidates and recommend the best teammates for a project.

The system also identifies:

- ✅ Matching skills
- ❌ Missing skills
- 📈 Overall compatibility score

---

## 🏗️ Architecture

```text
                 ┌──────────────────────┐
                 │   React Frontend     │
                 │      Port 5173       │
                 └──────────┬───────────┘
                            │
                         HTTP API
                            │
                            ▼
                 ┌──────────────────────┐
                 │    Java Backend      │
                 │      Port 8080       │
                 └──────────┬───────────┘
                            │
                ┌───────────┴───────────┐
                ▼                       ▼
        Matching Services          File Services
                │                       │
                └───────────┬───────────┘
                            ▼
                     data/users.txt
                     data/projects.txt
```

---

## 🛠️ Technologies Used

### Frontend

- React.js
- Vite
- JavaScript
- HTML
- CSS
- React Router

### Backend

- Java
- Java OOP
- Java Collections
- File Handling
- HTTP Server
- REST-style API

### Development Tools

- Visual Studio Code
- Git
- GitHub
- npm

---

## 📁 Project Structure

```text
DevMatch/
│
├── devmatch-frontend/
│   ├── public/
│   ├── src/
│   │   ├── components/
│   │   ├── App.jsx
│   │   ├── main.jsx
│   │   └── index.css
│   ├── package.json
│   ├── package-lock.json
│   └── vite.config.js
│
├── devmatch-backend/
│   ├── data/
│   │   ├── users.txt
│   │   └── projects.txt
│   │
│   └── src/
│       └── com/
│           └── devmatch/
│               ├── Main.java
│               ├── ApiServer.java
│               │
│               ├── model/
│               │   ├── User.java
│               │   ├── Project.java
│               │   └── MatchResult.java
│               │
│               └── service/
│                   ├── MatchingService.java
│                   ├── TeamFormationService.java
│                   ├── UserSearchService.java
│                   ├── UserFileService.java
│                   ├── ProjectFileService.java
│                   ├── ValidationService.java
│                   ├── UserManagementService.java
│                   └── ProjectManagementService.java
│
└── README.md
```

---

# ⚙️ Setup & Installation

## Prerequisites

Make sure the following are installed:

- Java JDK
- Node.js
- npm
- Git
- Visual Studio Code

You can verify the installations using:

```bash
java --version
node --version
npm --version
git --version
```

---

# ▶️ Running the Backend

Open a terminal inside:

```text
devmatch-backend
```

Compile the backend:

```bash
javac -d out src/com/devmatch/ApiServer.java src/com/devmatch/model/User.java src/com/devmatch/model/Project.java src/com/devmatch/model/MatchResult.java src/com/devmatch/service/MatchingService.java src/com/devmatch/service/TeamFormationService.java src/com/devmatch/service/UserSearchService.java src/com/devmatch/service/UserFileService.java src/com/devmatch/service/ProjectFileService.java src/com/devmatch/service/ValidationService.java src/com/devmatch/service/UserManagementService.java src/com/devmatch/service/ProjectManagementService.java
```

Then start the API server:

```bash
java -cp out com.devmatch.ApiServer
```

Expected output:

```text
DevMatch API Server started!
Running at: http://localhost:8080
```

Keep this terminal running.

---

# ▶️ Running the Frontend

Open a **second terminal** inside:

```text
devmatch-frontend
```

Install the dependencies:

```bash
npm install
```

Start the development server:

```bash
npm run dev
```

Vite will display a local URL similar to:

```text
http://localhost:5173
```

Open that URL in your browser.

---

# 🔗 API Endpoints

The Java backend currently provides the following endpoints:

### Get Users

```http
GET /api/users
```

### Get Projects

```http
GET /api/projects
```

### Get Project Matches

```http
GET /api/matches?projectId=101
```

The frontend consumes these APIs to display projects, candidate recommendations, compatibility scores, and matching information.

---

# 🔄 Application Flow

```text
User opens DevMatch
        ↓
React frontend loads
        ↓
Frontend requests project data
        ↓
Java backend processes request
        ↓
Project/user data loaded from files
        ↓
Matching algorithm calculates compatibility
        ↓
Candidates ranked by score
        ↓
React displays recommendations
```

---

# 🎯 Main Use Case

A project requires a team with specific skills.

DevMatch:

1. Reads the project's requirements.
2. Evaluates available users.
3. Compares their skills with project requirements.
4. Calculates experience compatibility.
5. Compares interests.
6. Considers availability.
7. Evaluates role compatibility.
8. Produces a final compatibility score.
9. Ranks potential teammates.
10. Displays the most suitable candidates.

---

# 🔮 Future Enhancements

Potential future improvements include:

- Spring Boot backend
- MySQL/PostgreSQL database
- User authentication
- Real-time collaboration
- Advanced team optimization
- AI-powered project recommendations
- Skill-gap recommendations
- Cloud deployment
- Notifications and messaging

---

## 👩‍💻 Project

**DevMatch — Smart Team Formation & Project Matching Platform**

Built as a full-stack academic/project MVP using **React.js and Java**.

---

## 📌 Note

This repository contains the MVP version of DevMatch. The project currently uses file-based persistence for simplicity and can be extended to a database-backed Spring Boot architecture in future development.