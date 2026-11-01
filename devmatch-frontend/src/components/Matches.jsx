import { useNavigate } from "react-router-dom";

function Matches() {

  const navigate = useNavigate();

  const matches = [
    {
      name: "Rahul Sharma",
      role: "Backend Developer",
      skills: ["Java", "Spring Boot", "MySQL"],
      score: 94
    },
    {
      name: "Ananya Reddy",
      role: "Frontend Developer",
      skills: ["React", "JavaScript", "CSS"],
      score: 89
    },
    {
      name: "Vikram Kumar",
      role: "Full Stack Developer",
      skills: ["Java", "React", "SQL"],
      score: 84
    },
    {
      name: "Priya Singh",
      role: "ML Developer",
      skills: ["Python", "Machine Learning", "AI"],
      score: 78
    }
  ];

  return (
    <section className="matches-section">

      <div className="section-heading">

        <p className="eyebrow">
          SMART MATCHING
        </p>

        <h1>
          Your Best Matches
        </h1>

        <p>
          People whose skills and interests match your
          project requirements.
        </p>

      </div>


      <div className="matches-grid">

        {matches.map((person) => (

          <div
            className="match-result-card"
            key={person.name}
          >

            <div className="match-person">

              <div className="match-avatar">
                {person.name.charAt(0)}
              </div>

              <div>
                <h3>{person.name}</h3>
                <p>{person.role}</p>
              </div>

            </div>


            <div className="match-score">

              <strong>
                {person.score}%
              </strong>

              <span>
                Match
              </span>

            </div>


            <div className="match-skills">

              {person.skills.map((skill) => (

                <span key={skill}>
                  {skill}
                </span>

              ))}

            </div>


            <button
  className="connect-button"
  onClick={() => {
    navigate(
      `/profile/${person.name.toLowerCase().replaceAll(" ", "-")}`,
      {
        state: person
      }
    );
  }}
>
  View Profile
</button>

          </div>

        ))}

      </div>

    </section>
  );
}

export default Matches;