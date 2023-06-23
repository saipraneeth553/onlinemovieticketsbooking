
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

const ButtonClick = () => {
  const path=useLocation();
  const num=path.state.n;
  const navigation=useNavigate();
  const [output, setOutput] = useState([]);
  const [clickedButtons, setClickedButtons] = useState([]);

  const printValue = (value) => {
    const newArray = output.includes(value)
      ? output.filter((item) => item !== value)
      : [...output, value];
    setOutput(newArray);
    toggleButton(value);
  };

  const toggleButton = (value) => {
    if (clickedButtons.includes(value)) {
      setClickedButtons(clickedButtons.filter((btn) => btn !== value));
    } else {
        
      setClickedButtons([...clickedButtons, value]);
    }
   
  };

  
  const renderButton = (number) => {
    const isActive = clickedButtons.includes(number);
    
    
    return (
      
      <button
        key={number}
        onClick={() => printValue(number)}
        className={rs.includes(number)?"style1":isActive?"styleA":"styleiA"}
        disabled={rs.includes(number)}
      >
      </button>
    );
  };

  const numbers = Array.from({ length:num  }, (_, index) => index + 1);
  const [currentDateTime, setCurrentDateTime] = useState([]);
    const [date,setDate]=useState('');
    useEffect(() => {
      const timer = setInterval(() => {
        const now = new Date();
       
        const formattedDateTime =formatDate(now)+ 'T' + formatTime(now);
        setCurrentDateTime(formattedDateTime);
      }, 1000); 
      return () => clearInterval(timer); 
    }, []);
  
    const formatDate = (date) => {
      const year = date.getFullYear();
      const month = String(date.getMonth() + 1).padStart(2, '0');
      const day = String(date.getDate()).padStart(2, '0');
      return `${year}-${month}-${day}`;
    };
  
    const formatTime = (date) => {
      const hours = String(date.getHours()).padStart(2, '0');
      const minutes = String(date.getMinutes()).padStart(2, '0');
      const seconds = String(date.getSeconds()).padStart(2, '0');
      return `${hours}:${minutes}:${seconds}`;
    };
    const amount = (output.length) * 200

    const string = output.join(',');
    const[bk,setBk]=useState([]);
    const[errors,setErrors]=useState({})
  const GotoDeatails=()=>{
         if(output.length>0){
          
          axios.post('http://localhost:8089/api/Booking/add', {

            "date": currentDateTime,
            "amount": amount,
            "count": output.length,
            "showDate": formatDate(new Date()),
            "showTime": localStorage.getItem('showtime'),
            "movie": localStorage.getItem("moviename"),
            "status": "sucess",
            "seats": string,
            "email": localStorage.getItem("email")

        }).then(res => {
            console.log(res.data);
        }
        )
        .catch(err=>console.log(err))
        
        
          output.map((m,i)=>(
               axios.post('http://localhost:8089/api/seat/add', {
            "time": localStorage.getItem('showtime'),
            "mname": localStorage.getItem('moviename'),
            "cinemaHallName": localStorage.getItem('theater'),
            "seatNo":m
            

        }).then(res => {
            console.log(res.data);
        })
        ))

       
        navigation('/details',{state:{out:bk}})
      }
      else{
        setErrors((prevErrors) => ({
          ...prevErrors,
          seat: 'Please select seats',
        })); 
         }
  }
  const [rs,setRs]=useState([])
  useEffect(() => {
    const url='http://localhost:8089/api/seat/getBtId/'+localStorage.getItem("moviename")+"/"+localStorage.getItem("theater")+"/"+localStorage.getItem("showtime");
    axios.get(url)
        .then(res => {
            setRs(res.data);
        })
        .catch(err => (console.log(err)))
}, [])


  useEffect(() => {
    const url='http://localhost:8089/api/Booking/getdetails/'+localStorage.getItem("email");
    axios.get(url)
        .then(res => {
            setBk(res.data);
        })
        .catch(err => (console.log(err)))
}, [])

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
    {errors.seat && <h3 className="error">{errors.seat}</h3>}
    <div className='c1'>
      <h1>Screen</h1>
    <div className='button-container'>
      {numbers.map((number) => renderButton(number))}
    </div>
    
    <button onClick={GotoDeatails}>confirm</button>
    
    </div>
    </div>
  );
};

export default ButtonClick;