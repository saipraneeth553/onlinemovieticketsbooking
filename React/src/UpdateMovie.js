import { faMartiniGlassEmpty } from "@fortawesome/free-solid-svg-icons"
import axios from "axios"
import { useEffect, useState } from "react"
import { useLocation, useNavigate } from "react-router-dom"
import Details from "./Details"

const UpdateMovie=()=>{
    const [se,setSe]=useState("")
    const url=useLocation();
  const [name,setName]=useState('')
  const [releaseDate,setReleaseDate]=useState('')
  const [duriation,setDuriation]=useState('')
  const [cast,setCast]=useState('')
  const [imageUrl,setImageUrl]=useState('')
  const [status,setStatus]=useState('')
  const navigate=useNavigate();
  const [av,setAv]=useState("")
  
  
  const add=()=>{
    console.log()
    axios.post("http://localhost:8089/api/movie/update",{
      "id":localStorage.getItem('mId'),
      "title": name,
        "date": releaseDate,
        "length": duriation,
        "category":selectedOptionC ,
        "language": selectedOptionL,
        "description": "a faction on sandal wood",
        "cast": cast,
        "img": imageUrl,
        "status": status,
        "email": localStorage.getItem('email')
    }).then(res=>{
      setAv(res.data);
    }).catch(err=>{
      console.log(err.mesage)
    })
  }
    const handleSubmit = (e) => {
        e.preventDefault();
        add();
        navigate('/ahome')
        }
      const [selectedOptionC, setSelectedOptionC] = useState('');
      const [selectedOptionL, setSelectedOptionL] = useState('');

  const handleSelectChangeC = (event) => {
    setSelectedOptionC(event.target.value);
  };
  const handleSelectChangeL = (event) => {
    setSelectedOptionL(event.target.value);
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
              <button onClick={handleHome}>Home</button>
            </li>
            <li>
              <button onClick={handleAdd}>Add Movie</button>
            </li>
            <li>
              <button onClick={handlelogout}>Logout</button>
            </li>
          </ul>
        </nav>
        <div className="control">
          <div className="form-container"> {/* Apply the CSS class for styling */}
         
          <form onSubmit={handleSubmit}>
              <h1>Update Movie Detail</h1>
            <div>
              <label>
                Name:
                <input value={name} onChange={(e) => setName(e.target.value)}  type="text" name="input1"  required={true} />
              </label>
              <label>
                ReleaseDate:
                <input value={releaseDate} onChange={(e) => setReleaseDate(e.target.value)}  type="text" name="input1" placeholder="yyyy-mm-dd" required={true} />
              </label>
              <label>
                Duration:
                <input value={duriation} onChange={(e) => setDuriation(e.target.value)}  type="text" name="input1"required={true}  />
              </label>
              <label>
                Catagory:
                <select id="dropdown" className="c-s" value={selectedOptionC} onChange={handleSelectChangeC}>
              <option value="">-- Select --</option>
              <option value="Love">Love</option>
              <option value="Action">Action</option>
              <option value="Thriler">Thriler</option>
              <option value="Thriler">Comedy</option>
            </select>
              </label>
              <label>
                Language:
              <select id="dropdown" className="c-s" value={selectedOptionL} onChange={handleSelectChangeL}>
              <option value="">-- Select --</option>
              <option value="Telugu">Telugu</option>
              <option value="Hindi">Hindi</option>
              <option value="English">English</option>
            </select>
              </label>
              <label>
                Cast:
                <input value={cast} onChange={(e) => setCast(e.target.value)}  type="text" name="input1"  required={true} />
              </label>
              <label>
                Image URL:
                <input value={imageUrl} onChange={(e) => setImageUrl(e.target.value)}  type="text" name="input1" required={true} />
              </label>
              <label>
                Status:
                <input value={status} onChange={(e) => setStatus(e.target.value)}  type="text" name="input1" required={true} />
              </label>
            </div>
           
            <button type="submit">submit</button>
          </form>
        </div>
        </div>
        </div>
      )
}
export default UpdateMovie;