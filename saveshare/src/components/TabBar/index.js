import React, {useContext} from 'react';

import {AuthContext} from '../../contexts/AuthProvider';
import {TabArea, TabItem, TabItemCenter, Icon, Avatar} from './styled';

const TabBar = ({state, navigation}) => {
  const {user, logout: UserLogout} = useContext(AuthContext);

  const handleNavigate = (screenName) => navigation.navigate(screenName);

  const handleSignOut = () => {
    UserLogout();

    navigation.reset({routes: [{name: 'SignIn'}]});
  };

  return (
    <TabArea>
      <TabItem onPress={() => handleNavigate('Home')}>
        <Icon
          name="home"
          size={24}
          color="#5457ff"
          active={state.index === 0}
        />
      </TabItem>
      <TabItem onPress={() => handleNavigate('Search')}>
        <Icon
          name="search"
          size={24}
          color="#5457ff"
          active={state.index === 1}
        />
      </TabItem>
      <TabItemCenter onPress={() => handleNavigate('Rents')}>
        <Icon name="calendar" size={28} color="#fff" />
      </TabItemCenter>
      <TabItem onPress={() => handleNavigate('Profile')}>
        {user?.photoURL ? (
          <Avatar source={{uri: user.photoURL}} />
        ) : (
          <Icon
            name="user"
            size={24}
            color="#5457ff"
            active={state.index === 3}
          />
        )}
      </TabItem>
      <TabItem onPress={handleSignOut}>
        <Icon name="log-out" size={24} color="#5457ff" />
      </TabItem>
    </TabArea>
  );
};

export default TabBar;
