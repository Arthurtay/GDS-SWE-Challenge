import React from 'react';
import { AppBar, Toolbar, Typography, Container } from '@mui/material';

const Footer = () => {
  return (
    <div style={{ marginTop: '450px' }}>
    <AppBar position="fixed" style={{ top: 'auto', bottom: 0, backgroundColor: '#000', color: '#fff' }}>
      <Container>
        <Toolbar>
          <Typography variant="body1" color="inherit" style={{ fontFamily: 'cursive', fontWeight: 'bold' }}>
            © 2024 Restaurant Finder. All rights reserved.
          </Typography>
        </Toolbar>
      </Container>
    </AppBar>
    </div>
  );
};

export default Footer;