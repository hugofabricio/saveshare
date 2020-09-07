import React from 'react';
import {createStackNavigator} from '@react-navigation/stack';

import HomeScreen from '../pages/HomeScreen';

const Public = createStackNavigator();

const PublicRoutes: React.FC = () => (
  <Public.Navigator
    screenOptions={{
      headerShown: false,
      cardStyle: {
        backgroundColor: '#F8FAFE',
      },
    }}>
    <Public.Screen name="Home" component={HomeScreen} />
  </Public.Navigator>
);

export default PublicRoutes;
