
import './App.css';

import React from 'react';
import { BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import Navigationbar from './Navigationbar';
import Home from './Home';
import About from './About';
import Footer from './Footer';


function App() {
  return (
  <div>
      <Router>
        <Navigationbar></Navigationbar>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
        </Routes>
      </Router>

    <Footer/>
  </div>

  
  );
}

export default App;
