import React, { useState } from 'react';
import { Container, Typography, TextField, Button } from '@mui/material';
import DataDisplay from './DataDisplay';


const Home = () => {
  
  const [shopName, setShopName] = useState('');
  const [area, setArea] = useState('');
  const [category, setCategory] = useState('');
  const [data, setData] = useState(null);
  const [noDataFound, setNoDataFound] = useState(false);
  const [searchType,  setsearchType] = useState(null);

  const handleSearch = async () => {
    try {
      const requestBody = {
        area:area,
        category: category
      };

      const response = await fetch(`http://localhost:9090/restaurant/random`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Accept': 'application/json',
        },
        body: JSON.stringify(requestBody),
      });
      const result = await response.json();
      renderResponse(result,"Random Restaurant ");
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };

  const searchByShop = async () => {
    try {
      console.log(shopName);
      const response = await fetch(`http://localhost:9090/restaurant/${shopName}`, {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
          'Accept': 'application/json',
        }
      });
     const result = await response.json();
     renderResponse(result,"Restaurant Search Result");
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };

  function renderResponse(result,searchType){
    if(result.shopName == null){
      setNoDataFound(true);
     }else{
      setData(result);
      setNoDataFound(false)
      setsearchType(searchType);
     }
  }


  return (
    
    <Container>
      <Typography variant="h4" style={{ marginTop: '20px', marginBottom: '20px' }}>
        Restaurant Finder
      </Typography>
      {noDataFound && (
        <Typography variant="body1" style={{ color: 'red',marginBottom: '20px' }}>
          No data found
        </Typography>
      )}
      <form style={{ marginBottom: '20px' }} >
        <TextField
          label="Shop Name"
          variant="outlined"
          value={shopName}
          onChange={(e) => setShopName(e.target.value)}
          style={{ marginRight: '10px' }}
        />

        <Button variant="contained" color="primary" onClick={searchByShop}>
          Search Restaurant
        </Button>
     
      </form>

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
          Random Choice
        </Button>
      </form>
      {data && <DataDisplay data={data} searchType={searchType} />}
    </Container>
  );
};

export default Home;