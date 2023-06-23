import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

const AHome=()=>{


    const handleHome=()=>{
        navigate('/ahome')
          fetcho();
    }
    const fetcho=() => {
      axios.get("http://localhost:8089/api/movie/getByemail/"+localStorage.getItem('email'))
          .then(res => {
              setMovies(res.data);
              console.log(movies);
          })
          .catch(err => (console.log(err)))
  };
    const handleAdd=()=>{
        navigate('/addmovie')
    }
    const handlelogout=()=>{
      localStorage.clear();
        navigate('/')
    }
    const navigate=useNavigate()
    const [movies, setMovies] = useState([]);
    useEffect(() => {
        axios.get("http://localhost:8089/api/movie/getByemail/"+localStorage.getItem('email'))
            .then(res => {
                setMovies(res.data);
                console.log(movies);
            })
            .catch(err => (console.log(err)))
    }, [])
    const [detail,setDetail]=useState(0)
    const getd=(mname) => {
  
    
    axios.get("http://localhost:8089/api/movie/getByemailName/" + localStorage.getItem('email') + '/' + mname)
    .then(res=> {setDetail(res.data.id);
      localStorage.setItem("mId",res.data.id);
      console.log(localStorage.getItem("mId"))
    })
    .catch(err=>console(err))
    };
    const deletem=(mid)=>{
      axios.get("http://localhost:8089/api/movie/del/"+mid)
            .then(res => {
                console.log(res.data);
            })
            .catch(err => (console.log(err)))
             handleHome();
    }
    const update=(mname)=>{
        getd(mname);
        navigate('/umovie');
     
    }
    return(
        <div className="home">
      <h1 style={{textAlign:'center'}}>It's Movie Time</h1>
    
      <nav className="navbar" >
        <ul>
          <li>
            <button onClick={handleHome}>Home</button>
          </li>
          <li>
            <button onClick={handleAdd}>Add Movie</button>
          </li>
          <li>
            <button onClick={handlelogout}>Logout</button>
          </li>
        </ul>
      </nav>
      <div className="movie-list">
      {movies.map((m, i) => (
        <div className="movie-card" key={i}>
          <h2>{m.title}    {"("+m.language+")"}</h2>
          <img src={m.img} alt="Image" className="movie-image" />
          <button className="book-button" onClick={() => {deletem(m.id)}}>
            Delete
          </button>
          <button className="book-button" onClick={() => { update(m.title)}}>
            Update
          </button>
          
        </div>
      ))}
      {movies.length===0?<h1>Hello,Welcome to It's Movie Time</h1>:""}
    </div>
    </div>
    )
}
export default AHome;