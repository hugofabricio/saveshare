import React from 'react';
import {NavigationContainer} from '@react-navigation/native';
import MainStack from './stacks/MainStack';
import {UserProvider} from './contexts/UserContext';

const App = () => {
  return (
    <UserProvider>
      <NavigationContainer>
        <MainStack />
      </NavigationContainer>
    </UserProvider>
  );
};

export default App;
