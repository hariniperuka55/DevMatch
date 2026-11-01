import { BrowserRouter, Routes, Route } from "react-router-dom";

import Navbar from "./components/Navbar.jsx";
import Dashboard from "./components/dashboard.jsx";
import Projects from "./components/Projects.jsx";
import ProjectDetails from "./components/ProjectDetails.jsx";
import Matches from "./components/Matches.jsx";
import CandidateProfile from "./components/CandidateProfile.jsx";
import Profile from "./components/Profile.jsx";
import CreateProject from "./components/CreateProject.jsx";

function App() {
  return (
    <BrowserRouter>

      <Navbar />

      <Routes>

        <Route path="/" element={<Dashboard />} />

        <Route path="/projects" element={<Projects />} />

        <Route
          path="/projects/:id"
          element={<ProjectDetails />}
        />

        <Route path="/matches" element={<Matches />} />

        <Route path="/profile" element={<Profile />} />

        <Route
        path="/profile/:name"
        element={<CandidateProfile />}
      />

        <Route
          path="/create-project"
          element={<CreateProject />}
        />

      </Routes>

    </BrowserRouter>
  );
}

export default App;