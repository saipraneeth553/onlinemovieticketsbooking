import axios from "axios";
import { useEffect,useState} from "react";
import { useNavigate } from "react-router-dom";
import { useLocation } from "react-router-dom"

const Details = () => {
    const path = useLocation();
    const[bk,setBk]=useState([]);
    useEffect(() => {
            const url='http://localhost:8089/api/Booking/getdetails/'+localStorage.getItem("email");
            axios.get(url)
                .then(res => {
                    setBk(res.data);
                })
                .catch(err => (console.log(err)))
        })
    const handlebooki=()=>{
        navigate('/bookings')
    }
    const handlelogout=()=>{
        navigate('/')
    }
    const navigate=useNavigate();
    const handleHome=()=>{
        navigate('/home')
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
            <button>Feedback</button>
          </li>
          <li>
            <button onClick={handlelogout}>Logout</button>
          </li>
        </ul>
      </nav>
       
        <div className="details"> 
    
        <h1>Booking Details</h1>

                   {bk.map((b,i)=>(
                    <div key={i} className="d1">
                       <p>Booking ID:{b.id}</p>
                        <p>Theater Name:{localStorage.getItem('theater')}</p>
                        <p>Movie Name:{b.movie}</p> 
                        <p>Show Date:{b.showDate}</p>
                        <p>Show Time:{b.showTime}</p>
                        <p>Count :{b.count}</p>
                        <p>Seats: {b.seats}</p>
                        <p>Amount:{b.amount}</p>
                        <p>Status:{b.status}</p>
                        </div>
                    
               ))
                
                }
        </div>
        </div>
    )
}

export default Details;