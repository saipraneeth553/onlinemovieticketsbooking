import axios, { Axios } from "axios";
import React,{useEffect, useState} from "react";
import Welcome from "./Welcome";
import Home from "./Home";
import {useNavigate} from "react-router-dom";

const Login=(props)=>{
    
    const navigate=useNavigate()
    const [email,setEmail]=useState("");
    const [password,setPassword]=useState("");
    const handleSubmit=(e)=>{
        e.preventDefault();
    }
    const [user,setUser]=useState(false);
    useEffect(() => {
        
      }, []);
    
      const checkUser = () => {
        const url = "http://localhost:8089/api/userregcheck/" + email;
        axios
          .get(url)
          .then((res) => {
            if(res.data){
              setErrors((prevErrors) => ({
                ...prevErrors,
                password: ' entered   password is wrong',
              })); 
            }
          })
          .catch((err) => console.log(err));
      };
    const [udata,setUdata]=useState([]);
    
    let bool=false;
    function Check(){ 
        localStorage.setItem('email', email);
        const url="http://localhost:8089/api/user/getById/"+email;
        axios.get(url)
      .then((response) => {
        // Store the response data in a variable
        const userData = response.data;
        if(userData.roleString==="Admin")
              navigate('/ahome');
        else{
            navigate('/home');
        }
      })
        // navigate('/home');
    }
    const [errors, setErrors] = useState({v:'verify'});
    const clearErr=()=>{
      console.log(Object.keys(errors).length);
      setErrors({});
     
    }
const verify= async (e)=>{
  
        clearErr();
  
  if (email === '') {
    setErrors((prevErrors) => ({
      ...prevErrors,
      email: 'Please enter your email',
    }));
    return;
  }

  // Check if password field is empty
  if (password === '') {
    setErrors((prevErrors) => ({
      ...prevErrors,
      password: 'Please enter your password',
    })); 
    return;
}
// console.log(Object.keys(errors).length);
    if(Object.keys(errors).length === 1){
        try{
             await axios.post("http://localhost:8089/api/user/check",{
                
                "userEmail": email,
                "password": password,
            }).then((response) => {
                if(response.data){
                    Check();
                    setEmail("");
                     setPassword("");
                }
                else{
                checkUser()
                }
            
            });
           
        }
        catch(err){
          setErrors((prevErrors) => ({
            ...prevErrors,
            email: err.response.data.messageString,
          }));;
        }


      
    }
    }
    return (
        <div className="start">
        <div className="formContainer">
            <h2>Login</h2>
            <form className="login-form" onSubmit={handleSubmit}>
                <label htmlFor="Email">Email :</label>
                <input value={email} onChange={(e) => setEmail(e.target.value)} type="email" placeholder="Enter Your email" name="email"/>
                {errors.email && <p className="error">{errors.email}</p>}
                <label htmlFor="password">Password :</label>
                <input value={password} onChange={(e) => setPassword(e.target.value)} type="password" placeholder="Enter Your password" name="password"/>
                {errors.password && <p className="error">{errors.password}</p>}
               
                <button onClick={()=>{verify()}}>Log In</button>
                
            </form>
            <button className="link-btn" onClick={()=>{navigate("/reg")}}>If not register ? click here </button>
    </div>
    </div>
    )
                


}

export default Login;
