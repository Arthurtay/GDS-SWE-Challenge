import React from 'react';
import { Card, CardContent, Divider, Typography } from '@mui/material';


const DataDisplay = ({ data,searchType}) => {

  return (
    <Card style={{ marginTop: '20px' }}>
      
      <CardContent>
        <Typography variant="h4" gutterBottom>
          {searchType}
        </Typography>
        <Divider  style={{ marginBottom: '10px' }} />
        <Typography variant="h5" gutterBottom>
            Shop Name: {data.shopName}
        </Typography>
        <Typography variant="body1" gutterBottom>
            Address: {data.address}
        </Typography>
        <Typography variant="body1" gutterBottom>
            Postal Code: {data.postalCode}
        </Typography>
        <Typography variant="body1" gutterBottom>
          Category: {data.category}
        </Typography>
        <Typography variant="body1" gutterBottom>
          Area: {data.area}
        </Typography>
        <Typography variant="body1" gutterBottom>
          Latitude: {data.lat}
        </Typography>
        <Typography variant="body1" gutterBottom>
          Longitude: {data.lng}
        </Typography>
      </CardContent>
    </Card>
    
  );
};

export default DataDisplay;