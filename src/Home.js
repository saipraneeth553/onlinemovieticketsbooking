import React from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { useEffect,useState } from 'react';
import axios from 'axios';
import { layer } from '@fortawesome/fontawesome-svg-core';

function Home() {
    const navigate=useNavigate();
    const [searchvalue,setSearchValue]=useState('');
    const handleHome=()=>{
        navigate('/home')
       fetchMovies();
    }
    const fetchMovies = () => {
      axios
        .get("http://localhost:8089/api/movie/getAll")
        .then((res) => {
          setMovies(res.data);
          console.log(res.data);
        })
        .catch((err) => {(console.log(err));
          setMovies([]);});
    };
    const handlebooki=()=>{
        navigate('/bookings')
    }
    const handlelogout=()=>{
      localStorage.clear();
        navigate('/')
    }
    const handlefeed=()=>{
      navigate("/feedback")
    }
    const [movies, setMovies] = useState([]);
    useEffect(() => {
        axios.get("http://localhost:8089/api/movie/getAll")
            .then(res => {
                setMovies(res.data);
                console.log(movies);
            })
            .catch(err => {(console.log(err));
              setMovies([]);})
    },[]);
    const [moviesC, setMoviesC] = useState([]);
    const [lan,setLan]=useState("")
const fetchMoviesBylanguage = async (lan) => {
console.log(localStorage.getItem('language'))

      await axios.get("http://localhost:8089/api/movie/getByLanguage/"+lan)
          .then(res => {
              setMovies(res.data);
          
          })
          .catch(err =>{ 
            console.log(err);
              setMovies([]);
          
          })
  };
    const handlebook=()=>{
        navigate("/bookings");
    }
    const handleSearch = (event) => {
      const searchTerm = event.target.value;
      // Perform search logic
    };
  
    const handleLanguageSelect = (language) => {
      fetchMoviesBylanguage(language);
    };
    const SearchIt=(searchvalue) => {
      axios.get("http://localhost:8089/api/movie/getsearch/"+searchvalue)
          .then(res => {
              setMovies(res.data);
              console.log(movies);          })
          .catch(err=>{
            console.log(err);
            setMovies([])})
  };
  
    const handleButtonClick = () => {
      SearchIt(searchvalue);
      
      setSearchValue("");

    };
  return (
    
    <div className="home">
      <h1 style={{textAlign:'center'}}>It's Movie Time</h1>
      
      <nav className="navbar" >
        <ul>
          <li>
            <button onClick={handleHome}>Home</button>
          </li>
          <li>
            <button onClick={handlebooki}>Booking Details</button>
          </li>
          <li>
            <button onClick={handlefeed}>Feedback</button>
          </li>
          <li>
            <button onClick={handlelogout}>Logout</button>
          </li>
          <div className='search'>
          <input value={searchvalue} onChange={(e) => setSearchValue(e.target.value)}   type="text" placeholder="Type here"  />
          <button onClick={handleButtonClick}>search</button>
          </div>
        </ul>
      </nav>
      
      

      <div className="button-group">
        <button onClick={() => handleLanguageSelect('Telugu')}>Telugu</button>
        <button onClick={() => handleLanguageSelect('Hindi')}>Hindi</button>
        <button onClick={() => handleLanguageSelect('English')}>English</button>
      </div>
    
      
    <div className="movie-list">
    
      {movies.map((m, i) => (
        <div className="movie-card" key={i}>
          <h2>{m.title}    {"("+m.language+")"}</h2>
          <img src={m.img} alt={m.title} className="movie-image" />
          <button className="book-button" onClick={() => { navigate("/theaters", { state: { mname: m.title } }); }}>
            Book Tickets
          </button>
        </div>
      ))}
      {movies.length===0?<h1>No movies Found</h1>:""}
    </div>
    
            </div>

)
}
export default Home;