import axios from "axios";
import React, { useEffect,useState } from "react";
import { useNavigate } from "react-router-dom";

const Bookings = () => {
    const [bk, setBk] = useState([]);
    

    useEffect(() => {
        const url = 'http://localhost:8089/api/Booking/getAll/' + localStorage.getItem("email");     
           axios.get(url)
            .then(res => {
                setBk(res.data);
            })
            .catch(err => (console.log(err)))
    }, [])
    const navigate=useNavigate();
  const handleHome=()=>{
      navigate('/home')
  }
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
      </ul>
    </nav>
        <div className="book">
            {bk.map((b, index) => (
                <div key={index} className="movie-ticket">
                    <h3>{b.movie}</h3>
                    <p>Booking ID:{b.id}</p>
                    <p>Theater Name:{localStorage.getItem('theater')}</p>
                    <p>Show Date:{b.showDate}</p>
                    <p>Show Time:{b.showTime}</p>
                    <p>Seats: {b.seats}</p>
                    <p>Amount:{b.amount}</p>
                    <p>Status:{b.status}</p>
                </div>
            ))}
            {bk.length===0?<h1>No bookings Found</h1>:""}
        </div>
        </div>
    )

}
export default Bookings;