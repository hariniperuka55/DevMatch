import { useLocation, useNavigate } from "react-router-dom";

function CandidateProfile() {

  const location = useLocation();
  const navigate = useNavigate();

  const person = location.state;

  if (!person) {
    return (
      <section className="profile-section">

        <h1>
          Profile not found
        </h1>

        <button
          className="primary-button"
          onClick={() => navigate("/matches")}
        >
          Back to Matches
        </button>

      </section>
    );
  }

  return (
    <section className="profile-section">

      <div className="profile-header">

        <div className="profile-avatar">
          {person.name.charAt(0)}
        </div>

        <div>

          <p className="eyebrow">
            DEVMATCH CANDIDATE
          </p>

          <h1>
            {person.name}
          </h1>

          <p>
            {person.role}
          </p>

        </div>

      </div>


      <div className="profile-grid">

        <div className="profile-card">

          <h2>
            Match Score
          </h2>

          <h1>
            {person.score}%
          </h1>

          <p>
            Compatibility with your project requirements.
          </p>

        </div>


        <div className="profile-card">

          <h2>
            Skills
          </h2>

          <div className="profile-tags">

            {person.skills.map(skill => (

              <span key={skill}>
                {skill}
              </span>

            ))}

          </div>

        </div>


        <div className="profile-card">

          <h2>
            Role
          </h2>

          <p>
            {person.role}
          </p>

        </div>


        <div className="profile-card">

          <h2>
            Collaboration
          </h2>

          <p>
            This developer is recommended based on
            their skills and compatibility with the
            project requirements.
          </p>

        </div>


        <div className="profile-card profile-action">

          <button
            className="primary-button"
            onClick={() => navigate("/matches")}
          >
            Back to Matches
          </button>

        </div>

      </div>

    </section>
  );
}

export default CandidateProfile;