import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

function ProjectDetails() {

  const { id } = useParams();

  const [project, setProject] = useState(null);
  const [matches, setMatches] = useState([]);

  useEffect(() => {

    // Get project details
    fetch("http://localhost:8080/api/projects")
      .then(response => response.json())
      .then(data => {

        const selectedProject =
          data.find(project => project.id === Number(id));

        setProject(selectedProject);

      })
      .catch(error => {

        console.error(
          "Error fetching project:",
          error
        );

      });


    // Get matching users
    fetch(`http://localhost:8080/api/matches?projectId=${id}`)
      .then(response => response.json())
      .then(data => {

        console.log("Matches received:");
        console.log(data);

        setMatches(data);

      })
      .catch(error => {

        console.error(
          "Error fetching matches:",
          error
        );

      });

  }, [id]);


  if (!project) {

    return (
      <section className="project-details">

        <h2>
          Loading project...
        </h2>

      </section>
    );
  }


  return (
    <section className="project-details">

      <div className="details-header">

        <p className="eyebrow">
          PROJECT DETAILS
        </p>

        <h1>
          {project.name}
        </h1>

        <p>
          {project.description}
        </p>

      </div>


      <div className="details-layout">

        <div className="details-main">


          <div className="details-card">

            <h2>
              Required Skills
            </h2>

            <div className="project-skills">

              {project.requiredSkills.map(skill => (

                <span key={skill}>
                  {skill}
                </span>

              ))}

            </div>

          </div>


          <div className="details-card">

            <h2>
              Recommended Teammates
            </h2>

            {matches.map((match, index) => (

              <div
                className="backend-user"
                key={match.userId}
              >

                <div className="avatar">
                  {match.name.charAt(0)}
                </div>

                <div>

                  <strong>
                    {index + 1}. {match.name}
                  </strong>

                  <p>
                    {match.role}
                  </p>

                  <strong>
                    {match.score}% Match
                  </strong>

                  <div className="project-skills">

                    {match.matchingSkills.map(skill => (

                      <span key={skill}>
                        {skill}
                      </span>

                    ))}

                  </div>

                </div>

              </div>

            ))}

          </div>


          <div className="details-card">

            <h2>
              Missing Skills
            </h2>

            {matches.length > 0 && (

              <div className="project-skills">

                {matches[0].missingSkills.map(skill => (

                  <span key={skill}>
                    {skill}
                  </span>

                ))}

              </div>

            )}

          </div>


        </div>


        <div className="details-side">

          <div className="match-box">

            <p className="muted">
              Best compatibility
            </p>

            <h2>
              {matches.length > 0
                ? `${matches[0].score}%`
                : "0%"}
            </h2>

            <p>
              Best current match for this project
              based on skills, experience, interests,
              availability and role.
            </p>

            <button className="primary-button">
              Request to Join
            </button>

          </div>

        </div>

      </div>

    </section>
  );
}

export default ProjectDetails;