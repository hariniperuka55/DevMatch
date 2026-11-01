import { Link } from "react-router-dom";

function ProjectCard({ id, title, description, skills, match }) {
  return (
    <div className="project-card">

      <div className="project-top">
        <h3>{title}</h3>

        <span>{match}% Match</span>
      </div>

      <p className="project-description">
        {description}
      </p>

      <div className="project-skills">
        {skills.map((skill) => (
          <span key={skill}>
            {skill}
          </span>
        ))}
      </div>

      <Link
        to={`/projects/${id}`}
        className="view-project"
      >
        View Project
      </Link>

    </div>
  );
}

export default ProjectCard;