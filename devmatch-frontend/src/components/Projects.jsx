import { useEffect, useState } from "react";
import ProjectCard from "./ProjectCard";

function Projects() {

  const [projects, setProjects] = useState([]);

  useEffect(() => {

    fetch("http://localhost:8080/api/projects")
      .then(response => response.json())
      .then(async data => {

        const projectsWithMatches = await Promise.all(

          data.map(async project => {

            const matchResponse =
              await fetch(
                `http://localhost:8080/api/matches?projectId=${project.id}`
              );

            const matches =
              await matchResponse.json();

            const bestMatch =
              matches.length > 0
                ? matches[0].score
                : 0;

            return {
              id: project.id,
              title: project.name,
              description: project.description,
              skills: project.requiredSkills,
              match: bestMatch
            };

          })

        );

        setProjects(projectsWithMatches);

      })
      .catch(error => {

        console.error(
          "Error connecting to Java backend:",
          error
        );

      });

  }, []);

  return (
    <section className="projects-section">

      <div className="section-heading">

        <p className="eyebrow">
          DISCOVER PROJECTS
        </p>

        <h2>
          Find projects that match your skills.
        </h2>

        <p>
          Explore projects and find opportunities to work
          with people who share your interests.
        </p>

      </div>

      <div className="projects-grid">

        {projects.map((project) => (

          <ProjectCard
            key={project.id}
            id={project.id}
            title={project.title}
            description={project.description}
            skills={project.skills}
            match={project.match}
          />

        ))}

      </div>

    </section>
  );
}

export default Projects;