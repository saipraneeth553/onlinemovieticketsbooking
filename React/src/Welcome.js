import { useLocation, useNavigate } from "react-router-dom";
import { FaBars, FaTimes } from "react-icons/fa";
import { useRef } from "react";
import { useState, useEffect } from "react";
import './App.css';
import Image from "react";
import axios from "axios";
function Welcome() {
    const navigate = useNavigate();
    const path = useLocation();
    const {e}= path.state;


    const navref = useRef();
    const showNavBar = () => {
        navref.current.classList.toggle("responsive_nav")

    }
    const [movies, setMovies] = useState([]);
    useEffect(() => {
        axios.get("http://localhost:8089/api/user/movie/getAll")
            .then(res => {
                setMovies(res.data);
                console.log(movies);
            })
            .catch(err => (console.log(err)))
    }, [])
    const handlebook=()=>{
        navigate("/bookings", { state: { em: "example@gmail.com" } });
    }
    return (
        <div className="home">
            <div className="top">
                <h1>It's Movie Time</h1>
            </div>
            <div>


                <header>

                    <nav ref={navref}>
                        <a href="/home">Home</a>
                        <a href="/home">Booking Details</a>
                        <a href="/home">Feedback</a>
                        <a className="logout" href="/">LogOut</a>
                        <button className="nav-btn nav-close-btn" onClick={showNavBar}>
                            <FaTimes />
                        </button>
                    </nav>
                    <button className="nav-btn" onClick={showNavBar}>
                        <FaBars />
                    </button>
                </header>
            </div>
            <div>
            
                {movies.map((m, i) => (

                          
                    <div style={{ margin: '0.5rem',position:'relative', borderBlockColor: "red", backgroundColor:'lightskyblue', width: '32%', height: '50%', float: 'left', display: 'flex' }}>
                        <img src={m.img} width="200" height="200" alt="Image" style={{padding:'1rem', float: 'left' }} />
                        <div style={{ flex: '1', display: 'flex', flexDirection: 'column', float:'right' }}>
                            <p style={{ maxWidth: '100%', wordWrap: 'break-word' }}>
                             Name: {m.title}<br/>
                             Language: {m.language}<br/>
                             Duration: {m.length}<br/>
                             Cast: {m.cast}<br/>
                             </p>
                        
                            <button style={{color:'white', backgroundColor:'orangered', width:'50%',display:'flex',flexDirection:'column',marginRight:'0.5rem'}} 
                            onClick={handlebook}>Book Tickets</button>
                        </div>
                    </div>


                ))
                }






            </div>
        </div>

    )
}
export default Welcome;