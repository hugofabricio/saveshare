import React from 'react';
import {createBottomTabNavigator} from '@react-navigation/bottom-tabs';

import TabBar from '../components/TabBar';

import Home from '../screens/private/Home';
import Search from '../screens/private/Search';
import Rents from '../screens/private/Rents';
import Favorites from '../screens/private/Favorites';
import Profile from '../screens/private/Profile';

const Tab = createBottomTabNavigator();

const Navigator = () => (
  <Tab.Navigator
    initialRouteName="Home"
    tabBar={(props) => <TabBar {...props} />}>
    <Tab.Screen name="Home" component={Home} />
    <Tab.Screen name="Search" component={Search} />
    <Tab.Screen name="Rents" component={Rents} />
    <Tab.Screen name="Favorites" component={Favorites} />
    <Tab.Screen name="Profile" component={Profile} />
  </Tab.Navigator>
);

export default Navigator;
