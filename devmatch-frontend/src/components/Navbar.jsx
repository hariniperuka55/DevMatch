import { Link } from "react-router-dom";

function Navbar() {
  return (
    <nav>
      <Link to="/" className="logo">
        DevMatch
      </Link>

      <div>
        <Link to="/">
          Dashboard
        </Link>

        <Link to="/projects">
          Projects
        </Link>

        <Link to="/matches">
          Matches
        </Link>

        <Link to="/profile">
          Profile
        </Link>
      </div>
    </nav>
  );
}

export default Navbar;