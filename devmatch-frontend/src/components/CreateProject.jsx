function CreateProject() {
  return (
    <section className="create-project-section">

      <div className="section-heading">
        <p className="eyebrow">CREATE PROJECT</p>

        <h1>Start a new project</h1>

        <p>
          Describe your project and find people with the
          skills you need.
        </p>
      </div>


      <div className="create-project-card">

        <div className="form-group">
          <label>Project Name</label>

          <input
            type="text"
            placeholder="Enter project name"
          />
        </div>


        <div className="form-group">
          <label>Description</label>

          <textarea
            placeholder="Describe your project..."
            rows="5"
          ></textarea>
        </div>


        <div className="form-row">

          <div className="form-group">
            <label>Category</label>

            <select>
              <option>Web Development</option>
              <option>AI / Machine Learning</option>
              <option>Mobile Development</option>
              <option>Data Science</option>
              <option>Other</option>
            </select>
          </div>


          <div className="form-group">
            <label>Team Size</label>

            <select>
              <option>2 Members</option>
              <option>3 Members</option>
              <option>4 Members</option>
              <option>5 Members</option>
              <option>6+ Members</option>
            </select>
          </div>

        </div>


        <div className="form-group">
          <label>Required Skills</label>

          <input
            type="text"
            placeholder="Java, React, SQL, Spring Boot..."
          />
        </div>


        <div className="form-row">

          <div className="form-group">
            <label>Experience Required</label>

            <select>
              <option>Beginner</option>
              <option>Intermediate</option>
              <option>Advanced</option>
            </select>
          </div>


          <div className="form-group">
            <label>Project Duration</label>

            <select>
              <option>1 - 4 Weeks</option>
              <option>1 - 2 Months</option>
              <option>2 - 4 Months</option>
              <option>4+ Months</option>
            </select>
          </div>

        </div>


        <button className="primary-button create-button">
          Create Project
        </button>

      </div>

    </section>
  );
}

export default CreateProject;