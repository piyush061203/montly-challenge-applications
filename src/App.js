
import { useEffect, useState } from 'react';
import './App.css';
import ChallengeList from './ChallengeList';
import axios from 'axios';
import AddChallenge from './AddChallenge';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  const[Challenges,setChallenges]=useState([]);

  useEffect(()=>{
    
    fetchChallenges();
  },[])

  const fetchChallenges=async ()=>{
    const response =await axios.get('http://localhost:8080/challenges');
    setChallenges(response.data);
  };

const handleChallengeAdded =()=>{
   fetchChallenges();
}

  return (
   <div className='container mt-5'>
   <h1 className='text-center mb-4'>Monthly Challenge Application</h1>
    <AddChallenge onChallengeAdded={handleChallengeAdded}/>
   <ChallengeList challenges={Challenges}/>
   </div>
  );
}

export default App;
