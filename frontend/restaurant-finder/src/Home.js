import React, { useState } from 'react';
import { Container, Typography, TextField, Button } from '@mui/material';
import DataDisplay from './DataDisplay';


const Home = () => {
    
  const [area, setArea] = useState('');
  const [category, setCategory] = useState('');
  const [data, setData] = useState(null);

  const handleSearch = async () => {
    try {
      const requestBody = {
        area:area,
        category: category
      };

      const response = await fetch(`http://localhost:9090/restaurant/get`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Accept': 'application/json',
        },
        body: JSON.stringify(requestBody),
      });
      const result = await response.json();
      setData(result);
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };

  return (
    
    <Container>
      <Typography variant="h4" style={{ marginTop: '20px', marginBottom: '20px' }}>
        Restaurant Finder
      </Typography>
      <form>

        <TextField
          label="Area"
          variant="outlined"
          value={area}
          onChange={(e) => setArea(e.target.value)}
          style={{ marginRight: '10px' }}
        />
        <TextField
          label="Category"
          variant="outlined"
          value={category}
          onChange={(e) => setCategory(e.target.value)}
          style={{ marginRight: '10px' }}
        />

        <Button variant="contained" color="primary" onClick={handleSearch}>
          Search
        </Button>
      </form>
      {data && <DataDisplay data={data} />}
    </Container>
  );
};

export default Home;