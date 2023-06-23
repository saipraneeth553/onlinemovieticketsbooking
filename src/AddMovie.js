import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

const AddMovie = () => {
  const [name, setName] = useState('');
  const [releaseDate, setReleaseDate] = useState('');
  const [duration, setDuration] = useState('');
  const [cast, setCast] = useState('');
  const [imageUrl, setImageUrl] = useState('');
  const [status, setStatus] = useState('');
  const navigate = useNavigate();
  const [selectedOptionC, setSelectedOptionC] = useState('');
  const [selectedOptionL, setSelectedOptionL] = useState('');
  const [errors, setErrors] = useState({});

  const handleSelectChangeC = (event) => {
    setSelectedOptionC(event.target.value);
  };

  const handleSelectChangeL = (event) => {
    setSelectedOptionL(event.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setErrors({});

    // Check if any required field is empty
    if (!name || !releaseDate || !duration || !selectedOptionC || !selectedOptionL || !cast || !imageUrl || !status) {
      setErrors((prevErrors) => ({
        ...prevErrors,
        fill: "All fields are required to fill",
      }));
      return;
    }

    // Check if releaseDate is in the correct format
    const datePattern = /^\d{4}-\d{2}-\d{2}$/;
    if (!datePattern.test(releaseDate)) {
      setErrors((prevErrors) => ({
        ...prevErrors,
        date: "Please enter the release date in the format yyyy-mm-dd",
      }));
      return;
    }

    axios
      .post("http://localhost:8089/api/movie/add", {
        title: name,
        date: releaseDate,
        length: duration,
        category: selectedOptionC,
        language: selectedOptionL,
        description: "a faction on sandalwood",
        cast: cast,
        img: imageUrl,
        status: status,
        email: localStorage.getItem('email')
      })
      .then((res) => {
        console.log(res.data);
        navigate('/addtheater');
      })
      .catch((err) => {
        console.log(err.message);
      });
  };

  const handleHome = () => {
    navigate('/ahome');
  };

  const handleAdd = () => {
    navigate('/addmovie');
  };

  const handleLogout = () => {
    localStorage.clear();
    navigate('/');
  };

  return (
    <div className="home">
      <h1 style={{ textAlign: 'center' }}>It's Movie Time</h1>

      <nav className="navbar">
        <ul>
          <li>
            <button onClick={handleHome}>Home</button>
          </li>
          <li>
            <button onClick={handleAdd}>Add Movie</button>
          </li>
          <li>
            <button onClick={handleLogout}>Logout</button>
          </li>
        </ul>
      </nav>

      <div className="control">
      {errors.fill && <p>{errors.fill}</p>}
        <div className="form-container">
          <h1>Add Movie Detail</h1>
          <form onSubmit={handleSubmit} noValidate>
            <div>
              <label>
                Name:
                <input
                  value={name}
                  onChange={(e) => setName(e.target.value)}
                  type="text"
                  name="input1"
                  required
                />
              </label>
              <label>
                Release Date:
                <input
                  value={releaseDate}
                  onChange={(e) => setReleaseDate(e.target.value)}
                  type="text"
                  name="input1"
                  placeholder="yyyy-mm-dd"
                  required
                />
              </label>
              <label>
                Duration:
                <input
                  value={duration}
                  onChange={(e) => setDuration(e.target.value)}
                  type="text"
                  name="input1"
                  required
                />
              </label>
              <label>
                Category:
                <select
                  id="dropdown"
                  className="c-s"
                  value={selectedOptionC}
                  onChange={handleSelectChangeC}
                >
                  <option value="">Category</option>
                  <option value="Love">Love</option>
                  <option value="Action">Action</option>
                  <option value="Thriller">Thriller</option>
                  <option value="Comedy">Comedy</option>
                </select>
              </label>
              <label>
                Language:
                <select
                  id="dropdown"
                  className="c-s"
                  value={selectedOptionL}
                  onChange={handleSelectChangeL}
                >
                  <option value="">Language</option>
                  <option value="Telugu">Telugu</option>
                  <option value="Hindi">Hindi</option>
                  <option value="English">English</option>
                </select>
              </label>
              <label>
                Cast:
                <input
                  value={cast}
                  onChange={(e) => setCast(e.target.value)}
                  type="text"
                  name="input1"
                  required
                />
              </label>
              <label>
                Image URL:
                <input
                  value={imageUrl}
                  onChange={(e) => setImageUrl(e.target.value)}
                  type="text"
                  name="input1"
                  required
                />
              </label>
              <label>
                Status:
                <input
                  value={status}
                  onChange={(e) => setStatus(e.target.value)}
                  type="text"
                  name="input1"
                  required
                />
              </label>
              {errors.fill && <p>{errors.fill}</p>}
              {errors.date && <p>{errors.date}</p>}
            </div>
            <button type="submit">Next</button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default AddMovie;