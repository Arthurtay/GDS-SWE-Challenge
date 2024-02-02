import React from 'react';
import { AppBar, Toolbar, Button, Container } from '@mui/material';
import { Link } from 'react-router-dom';

const Navigationbar = () => {
  return (
    <AppBar position="static" color="primary">
      
        <Toolbar style={{ justifyContent: 'flex-start' }}>
          <Button component={Link} to="/" color="inherit" style={{ fontWeight: 'bold' }}>
            Home
          </Button>
          <Button component={Link} to="/about" color="inherit" style={{ fontWeight: 'bold' }}>
            About us
          </Button>
        </Toolbar>
     
    </AppBar>
  );
};

export default Navigationbar;