import './App.css';
import { useNavigate } from 'react-router-dom';
import { FaBars,FaCalendar,FaTimes } from 'react-icons/fa';
import { useRef, useState ,useEffect} from 'react';
import axios from 'axios';
import { useLocation } from 'react-router-dom';
import Calendar from 'react-calendar';
import 'react-calendar/dist/Calendar.css';

import { CalendarContainer } from 'react-datepicker';
function Bookings(){
    const navigate=useNavigate();
    const path=useLocation();
    const name=path.state.mname;
    localStorage.setItem("moviename",name);
    console.log(name)
    const handleHome=()=>{
        navigate('/home')
    }
    const handlebooki=()=>{
        navigate('/bookings')
    }
    const handlelogout=()=>{
        navigate('/')
    }
    const [date, setDate] = useState(new Date());
const year = date.getFullYear();
const month = String(date.getMonth() + 1).padStart(2, '0'); // Month starts from 0 (January is 0)
const day = String(date.getDate()).padStart(2, '0');
const [d,setD] = useState(year+'-'+month+'-'+day);
    const [theater, setTheater] = useState([]);
    useEffect(() => {
        var url="http://localhost:8089/api/cinema/getBymnane/"+name+'/'+d;
        axios.get(url)
            .then(res => {
                setTheater(res.data)
            })
            .catch(err =>{
              setTheater([])
            })
    },[d])
   
    const setSt=(n,st,th)=>{
      localStorage.setItem('showtime',st);
      localStorage.setItem('theater',th);

  
      navigate('/seats',{state:{n:60}})
    }
    const [showCalendar, setShowCalendar] = useState(false);
 
  
  const handleDateChange = (newDate) => {
    
    setDate(()=>{
      const sd=newDate;
      return sd;
    });
    console.log(newDate);
    
    const year = newDate.getFullYear();
    const month = String(newDate.getMonth() + 1).padStart(2, '0'); 
    const day = String(newDate.getDate()).padStart(2, '0');
   setD(year+'-'+month+'-'+day);
  toggleCalendar();
  };

  const toggleCalendar = () => {
    
    setShowCalendar(!showCalendar);
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
            <button>Feedback</button>
          </li>
          <li>
            <button onClick={handlelogout}>Logout</button>
          </li>
        </ul>
      </nav>
      <div className='ct'>
        <div className='Date'>
          
      <label onClick={toggleCalendar}>Show Date:{d}</label>
      
      </div>
       <div className={`calendar-container ${showCalendar ? 'show' : ''}`}>
        
        <Calendar  onChange={handleDateChange}  value={date}/>
      </div>
      <div className='theater'>
        
        <h1>Threaters </h1>
        
        {theater.map((m, i) => (
      <div className="container">
      <div className="left">
        <h2 key={m.id}>{m.name}</h2>
      </div>
      <div className="right">
        <h3>{m.location}</h3>
      </div>
      <div className="button-row">
      
      { m.t1!=="00:00:00"?
              <button onClick={()=>{setSt(60,m.t1,m.name)}} >{m.t1}</button>:""}       
   { 
m.t2!=="00:00:00"?
              <button onClick={()=>{setSt(60,m.t2,m.name)}} >{m.t2}</button>:""
        }
{ 
        m.t3!=="00:00:00"?
              <button onClick={()=>{setSt(m.noOfSeats,m.t3,m.name)}} >{m.t3}</button>:""
        }        
        { 
        m.t4!=="00:00:00"?
              <button onClick={()=>{setSt(m.noOfSeats,m.t2,m.name)}} >{m.t4}</button>:""
        }   
        { 
        m.t5!=="00:00:00"?
              <button onClick={()=>{setSt(m.noOfSeats,m.t2,m.name)}} >{m.t5}</button>:""
        }   </div>
        
      {/* onClick={()=>{navigate('/seats',{state:{n:50}})}} */}
    </div>
    
))}
</div>
{theater.length===0?<h1>No Theater Found</h1>:""}
     </div> 
     </div>
  );

}
export default Bookings;