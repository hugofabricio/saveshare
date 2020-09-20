import React from 'react';
import {createStackNavigator} from '@react-navigation/stack';

import Preload from '../screens/public/Preload';
import SignIn from '../screens/public/SignIn';
import SignUp from '../screens/public/SignUp';
import MainTab from './MainTab';
import Building from '../screens/private/Building';

const Stack = createStackNavigator();

const Navigator = () => (
  <Stack.Navigator
    initialRouteName="Preload"
    screenOptions={{
      headerShown: false,
    }}>
    <Stack.Screen name="Preload" component={Preload} />
    <Stack.Screen name="SignIn" component={SignIn} />
    <Stack.Screen name="SignUp" component={SignUp} />
    <Stack.Screen name="MainTab" component={MainTab} />
    <Stack.Screen name="Building" component={Building} />
  </Stack.Navigator>
);

export default Navigator;
