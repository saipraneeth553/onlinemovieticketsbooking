import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
const AddTheater=()=>{
    const navigate=useNavigate();
    const [name,setName]=useState("")
    const [location,setLocation]=useState("")
    const [noOfSeats,setNoOfSeats]=useState()
    const [errors, setErrors] = useState("");
    const [endDate,setEndDate]=useState("");

   
     
    
    const HandleSubmit =(e) => {
        
      e.preventDefault();
    if(selectedOptions.length!==0){
        e.preventDefault();
        const t1=selectedOptions[0]===undefined?"00:00:00":selectedOptions[0];
        const t2=selectedOptions[1]===undefined?"00:00:00":selectedOptions[1];
        const t3=selectedOptions[2]===undefined?"00:00:00":selectedOptions[2];
        const t4=selectedOptions[3]===undefined?"00:00:00":selectedOptions[3];
        const t5=selectedOptions[4]===undefined?"00:00:00":selectedOptions[4];
       
        axios.post("http://localhost:8089/api/cinema/add",{
        "name": name,
         "location": location,
        "movieName": localStorage.getItem('mname'),
        "t1": t1,
        "t2": t2,
        "t3": t3,
        "t4": t4,
        "t5": t5,
        "noOfSeats":noOfSeats,
        "date":endDate,
        "email": localStorage.getItem('email')

        }).then(res=>{
          console.log(res.data)
        }).catch(err=>console.log(err))
        navigate('/ahome')
      }
      else{
         setErrors("Please select ShowTimings");
      }
      }
      
  const [selectedOptions, setSelectedOptions] = useState([]);

  const handleOptionChange = (option) => {
    if (selectedOptions.includes(option)) {
      setSelectedOptions(selectedOptions.filter((selectedOption) => selectedOption !== option));
    } else {
      setSelectedOptions([...selectedOptions, option]);
    }
  };
  const [selectedOption, setSelectedOption] = useState('');
      
  const handleSelectChange = (event) => {
    setSelectedOption(event.target.value);
  };
  const handleHome=()=>{
    navigate('/ahome')
    
}
const handleAdd=()=>{
    navigate('/addmovie')
}
const handlelogout=()=>{
  localStorage.clear();
    navigate('/')
}
return(
  <div className="home">
    
  <h1 style={{textAlign:'center'}}>It's Movie Time</h1>
  
  <nav className="navbar" >
    <ul>
      <li>
        <button onClick={handleHome} disabled={true}>Home</button>
      </li>
      <li>
        <button onClick={handleAdd} disabled={true}>Add Movie</button>
      </li>
      <li>
        <button onClick={handlelogout}disabled={true}>Logout</button>
      </li>
    </ul>
  </nav>
  <div className="control">
    <div className="form-container"> {/* Apply the CSS class for styling */}
    {errors&&<p>{errors}</p>}
    <h1>Add Theater Detail</h1>
    <form onSubmit={HandleSubmit}>
      <div>
        <label>
          Name:
          <input value={name} onChange={(e) => setName(e.target.value)} type="text" name="input1"   required/>
        </label>
        
        <label>
          Location:
          <input value={location} onChange={(e) => setLocation(e.target.value)} type="text" name="input1"  required />
        </label>
        
        <label>Selecct Show Timings</label>
        
        <label key={"10:00:00"}>
          <input
            type="checkbox"
            value={"10:00:00"}
            checked={selectedOptions.includes("10:00:00")}
            onChange={() => handleOptionChange("10:00:00")}
          />
          {"10:00:00 AM"}
        </label>
        
        <label key={"1:00:00"}>
          <input
            type="checkbox"
            value={"01:00:00"}
            checked={selectedOptions.includes("01:00:00")}
            onChange={() => handleOptionChange("01:00:00")}
          />
          {"01:00:00 PM"}
        </label>
        <label key={"04:00:00"}>
          <input
            type="checkbox"
            value={"04:00:00"}
            checked={selectedOptions.includes("04:00:00")}
            onChange={() => handleOptionChange("04:00:00")}
          />
          {"04:00:00 PM"}
        </label>
        <label key={"06:00:00"}>
          <input
            type="checkbox"
            value={"06:00:00"}
            checked={selectedOptions.includes("06:00:00")}
            onChange={() => handleOptionChange("06:00:00")}
          />
          {"06:00:00 PM"}
        </label>
        <label key={"09:00:00"}>
          <input
            type="checkbox"
            value={"09:00:00"}
            checked={selectedOptions.includes("09:00:00")}
            onChange={() => handleOptionChange("09:00:00")}
          />
          {"09:00:00 PM"}
        </label>
        <label>
          EndDate:
          <input value={endDate} onChange={(e) => setEndDate(e.target.value)} type="text"  palceholder="yyyy-MM-dd" name="input1"   placeholder="YYYY-MM-DD" required/>
        </label>
         
        <label>
          No_Of_Seats:
          <input value={noOfSeats} onChange={(e) => setNoOfSeats(e.target.value)} type="number" name="input1"   required/>
        </label>
      </div>
     
      <button type="submit">submit</button>
    </form>
  </div>
  </div>
  </div>
)
}

export default AddTheater;