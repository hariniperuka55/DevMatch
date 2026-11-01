function Profile() {
  const skills = [
    "Java",
    "React",
    "SQL",
    "Data Structures",
    "Git"
  ];

  const interests = [
    "Web Development",
    "AI",
    "Open Source"
  ];

  return (
    <section className="profile-section">

      <div className="profile-header">

        <div className="profile-avatar">
          H
        </div>

        <div>
          <p className="eyebrow">MY PROFILE</p>

          <h1>Harshavardhan</h1>

          <p>
            Java Developer • Full Stack Enthusiast
          </p>
        </div>

      </div>


      <div className="profile-grid">

        {/* ABOUT */}

        <div className="profile-card">

          <h2>About Me</h2>

          <p>
            I am a developer interested in building
            real-world applications and collaborating
            with other developers on meaningful projects.
          </p>

        </div>


        {/* EXPERIENCE */}

        <div className="profile-card">

          <h2>Experience</h2>

          <div className="experience-item">
            <strong>Development Experience</strong>

            <p>
              Beginner / Intermediate
            </p>
          </div>

        </div>


        {/* SKILLS */}

        <div className="profile-card">

          <h2>Skills</h2>

          <div className="profile-tags">

            {skills.map((skill) => (
              <span key={skill}>
                {skill}
              </span>
            ))}

          </div>

        </div>


        {/* INTERESTS */}

        <div className="profile-card">

          <h2>Interests</h2>

          <div className="profile-tags">

            {interests.map((interest) => (
              <span key={interest}>
                {interest}
              </span>
            ))}

          </div>

        </div>


        {/* AVAILABILITY */}

        <div className="profile-card">

          <h2>Availability</h2>

          <div className="availability">

            <span className="availability-dot"></span>

            Available for projects

          </div>

        </div>


        {/* EDIT */}

        <div className="profile-card profile-action">

          <button className="primary-button">
            Edit Profile
          </button>

        </div>

      </div>

    </section>
  );
}

export default Profile;