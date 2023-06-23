import { useState } from "react";
import axios from "axios";
import { useEffect } from "react";
import { useNavigate } from "react-router-dom";
const Register=()=>{
    const navigate=useNavigate();
    const [email,setEmail]=useState("");
    const [password,setPassword]=useState("");
    const [name,setName]=useState("")
const [errors, setErrors] = useState({v:"ggjjh"});

const Checkdetailsr = () => {
  
  setErrors({});
  if (name === "") {
    setErrors((prevErrors) => ({
      ...prevErrors,
      name: "Please enter your name",
    }));
    return;
  }

  if (!email.includes("@")) {
    setErrors((prevErrors) => ({
      ...prevErrors,
      email: "Please enter a valid email address",
    }));
    return;
  }

  
  const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%#*?&]{8,}$/;
  if (!passwordRegex.test(password)) {
    setErrors((prevErrors) => ({
      ...prevErrors,
      password:
        "Password must contain at least 8 characters, including one uppercase letter, one lowercase letter, one digit, and one special character",
    }));
    return;
  }
  if (selectedOption === "") {
    setErrors((prevErrors) => ({
      ...prevErrors,
      role: "Please select a role",
    }));
    return;
  }
  checkUser();
    if(user){
        setErrors((prevErrors) => ({
            ...prevErrors,
            email: "Email Already exist",
          }));

    }
    else{
        if (Object.keys(errors).length === 0) {
            save();
          }
    }

};

    const [user,setUser]=useState();
    const checkUser=() => {
            const url='http://localhost:8089/api/userregcheck/'+email;
            axios.get(url)
                .then(res => {
                    setUser(res.data);
                })
                .catch(err => (console.log(err)))
        };
    const save=async ()=>{
        
            await axios.post("http://localhost:8089/api/user/add",{
                
                "email": email,
                "password": password,
                "name": name,
                "roleString":selectedOption
            }).then(res=>{
                if(res){
                    navigate('/')
                    setEmail("");
            setName("");
            setPassword("");
            setSelectedOption("")
        }})
        .catch(err=>console.log(err))
        }
        

    
    const handleSubmit=(e)=>{
        e.preventDefault();
        
        console.log(email);
    }
    const [selectedOption, setSelectedOption] = useState('');

  const handleOptionChange = (event) => {
    setSelectedOption(event.target.value);
  };
  const Checkdetails=()=>{
    Checkdetailsr();
    }
  
    return (
        <div className="start">
        <div className="formContainer">
            <h2>Register</h2>
            <form className="Register-form" onSubmit={handleSubmit} noValidate>
                <label htmlFor="Name">Name :</label>
                <input value={name} onChange={(e) => setName(e.target.value)} type="text" placeholder="Enter Your name" name="name"/>
                <label htmlFor="Email">Email :</label>
                <input value={email} onChange={(e) => setEmail(e.target.value)} type="email" placeholder="Enter Your email" name="email"/>
                {errors.email && <p className="error">{errors.email}</p>}
                <label htmlFor="password">Password :</label>
                <input value={password} onChange={(e) => setPassword(e.target.value)} type="password" placeholder="Enter Your password" name="password"/>
                {errors.password && <p className="errorR">{errors.password}</p>}
                <label>
                <input type="radio" name="options" value="user" checked={selectedOption === "user"} onChange={handleOptionChange}/>user</label>
                <label>
                <input type="radio" name="options" value="Admin"checked={selectedOption === "Admin"}onChange={handleOptionChange}/>Admin</label>
                {errors.role && <p className="error">{errors.role}</p>}
                <button onClick={() => Checkdetails()}>Register</button>
            </form>
            <button className="link-btn" onClick={()=>{navigate("/")}}>if already have account Login </button>
        </div>
        </div>
    )
};
export default Register;