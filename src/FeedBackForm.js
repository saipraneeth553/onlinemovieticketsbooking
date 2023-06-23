import axios from 'axios';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const FeedbackForm = () => {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [message, setMessage] = useState('');
  const [errors, setErrors] = useState({v:'verify'});
  const handleSubmit = (e) => {
    setErrors({})
    e.preventDefault();
       axios.post("http://localhost:8089/api/feed/add",{
        "name":name,
        "email":email,
        "feedback":message
       }).then(res=>{
        setErrors((prevErrors) => ({
          ...prevErrors,
          feed: 'Your Feedback Added Succesfully',
        })); 
        setName('');
        setEmail('');
        setMessage('');
       })
   
  };
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
    <div className="feedback-form-container">
    {errors.feed && <h3>{errors.feed}</h3>}
      <div className="feedback-form">
        <h2>Feedback Form</h2>
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label htmlFor="name">Name:</label>
            <input
              type="text"
              id="name"
              value={name}
              onChange={(e) => setName(e.target.value)}
              placeholder="Enter your name"
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="email">Email:</label>
            <input
              type="email"
              id="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              placeholder="Enter your email"
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="message">What would You like to Share About App</label>
            <textarea
              id="message"
              value={message}
              onChange={(e) => setMessage(e.target.value)}
              placeholder="Enter your Feedback Here"
              required
            ></textarea>
          </div>
          <button type="submit">Submit</button>
        </form>
      </div>
    </div>
    </div>
  );
};

export default FeedbackForm;