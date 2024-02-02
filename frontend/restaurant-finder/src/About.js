import React from 'react';
import { Container, Typography, Card, CardContent, CardMedia } from '@mui/material';
import finderImage from './finder.jpg';
const About = () => {
  return (
    <Container>
      <Typography variant="h4" style={{ marginTop: '20px', marginBottom: '20px' }}>
        About Us
      </Typography>
      <Card>
        <CardMedia
          component="img"
          src={finderImage} 
          height="400"
          alt="Restaurant Image"
        />
        <CardContent>
          <Typography variant="h6" gutterBottom>
            Welcome to Restaurant Finder!
          </Typography>
          <Typography variant="body1">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed aliquam urna ac ex iaculis, et hendrerit
            tellus fermentum. Nulla facilisi. Fusce at dolor vel urna malesuada luctus. Vestibulum ante ipsum primis in
            faucibus orci luctus et ultrices posuere cubilia Curae; Sed venenatis tellus vel lectus scelerisque
            hendrerit.
          </Typography>
          <Typography variant="body1">
            Our mission is to provide delicious and high-quality food to our valued customers. Whether you're dining in
            or ordering takeout, we strive to create a memorable and enjoyable experience for you.
          </Typography>
          <Typography variant="body1">
            Thank you for choosing [Your Restaurant Name]. We look forward to serving you!
          </Typography>
        </CardContent>
      </Card>
    </Container>
  );
};

export default About;