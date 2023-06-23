import React,{useState} from 'react';
import Login from './Login';
import Register from './Register';
import Welcome from './Welcome';
import './App.css';
import { Route, Router, Routes } from 'react-router-dom';
import Theaters from './Theaters';
import Home from './Home';
import Seats from './Seats';
import Details from './Details';
import Bookings from './Bookings';
import AHome from './AHome';
import AddMovie from './AddMovie';
import AddTheater from './AddTheater';
import FeedbackForm from './FeedBackForm';
import Updatemovie from './UpdateMovie';
function App() {
 
  const [currentForm ,setCurrentForm]=useState('login');
  
  const toogleForm=(formname)=>{
    setCurrentForm(formname);
  }
  return (
    
    <div className='App'>
     {
        
        //  currentForm === "login" ? <Login onFormSwitch={toogleForm}/>:<Register onFormSwitch={toogleForm}/>
        <Routes >
        <Route path='/' element={<Login/>}/>
        <Route path='/reg' element={<Register/>}/>
        <Route path="/home" element={<Home/>}/>
        <Route path='/theaters' element={<Theaters/>}></Route>
        <Route path='/wel' element={<Welcome/>}/>
        <Route path='/seats' element={<Seats/>}></Route>
        <Route path='/details' element={<Details/>}></Route>
        <Route path='/bookings' element={<Bookings/>}/>
        <Route path='/ahome' element={<AHome/>}/>
        <Route path='/addmovie' element={<AddMovie/>}/>
        <Route path='/addtheater' element={<AddTheater/>}/>
        <Route path='/feedback' element={<FeedbackForm/>}/>
        <Route path='/umovie'  element={<Updatemovie/>}/>
        
        </Routes>
     
    } 
    </div>
    
    
    
  );
  
}

export default App;
