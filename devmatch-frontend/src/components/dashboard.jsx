import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

function Dashboard() {

  // Store users received from Java backend
  const [users, setUsers] = useState([]);

  const navigate = useNavigate();

  // Fetch users when Dashboard loads
  useEffect(() => {

    fetch("http://localhost:8080/api/users")
      .then(response => response.json())
      .then(data => {

        console.log("Users received from Java backend:");
        console.log(data);

        setUsers(data);
      })
      .catch(error => {

        console.error(
          "Error connecting to Java backend:",
          error
        );

      });

  }, []);


  return (
    <section className="hero">

      <div className="hero-content">

        <p className="eyebrow">
          SMART TEAM FORMATION
        </p>

        <h1>
          Find the right people
          <br />
          for the right project.
        </h1>

        <p className="hero-text">
          DevMatch connects projects with people based on
          skills, experience, interests, and availability.
        </p>

        <div className="hero-buttons">

          <button onClick={() => navigate("/projects")}>
  Explore Projects
</button>

<button onClick={() => navigate("/profile")}>
  My Profile
</button>

        </div>

      </div>


      {/* Existing Match Card */}

      <div className="match-card">

        <div className="match-header">

          <strong>
            AI Waste Detection
          </strong>

          <span>
            82% Match
          </span>

        </div>

        <p className="muted">
          Recommended teammate
        </p>


        <div className="person">

          <div className="avatar">
            A
          </div>

          <div>

            <strong>
              Arjun Kumar
            </strong>

            <p>
              Backend + ML Developer
            </p>

          </div>

        </div>


        <div className="skills">

          <span>Java</span>
          <span>Python</span>
          <span>ML</span>
          <span>React</span>

        </div>

      </div>


      {/* =========================
          REAL USERS FROM BACKEND
         ========================= */}

      <div className="backend-users">

        <h2>
          Users from DevMatch Backend
        </h2>


        {users.map(user => (

          <div
            className="backend-user"
            key={user.id}
          >

            <div className="avatar">
              {user.name.charAt(0)}
            </div>

            <div>

              <strong>
                {user.name}
              </strong>

              <p>
                {user.role}
              </p>

              <small>
                Experience: {user.experience} years
              </small>

              <br />

              <small>
                Availability: {user.availability}%
              </small>

            </div>

          </div>

        ))}

      </div>

    </section>
  );
}

export default Dashboard;