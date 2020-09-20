import React, {useContext} from 'react';

import {UserContext} from '../../contexts/UserContext';
import {TabArea, TabItem, TabItemCenter, Icon, Avatar} from './styled';

const TabBar = ({state, navigation}) => {
  const {state: user} = useContext(UserContext);

  const handleNavigate = (screenName) => navigation.navigate(screenName);

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
      <TabItem onPress={() => handleNavigate('Favorites')}>
        <Icon
          name="star"
          size={24}
          color="#5457ff"
          active={state.index === 3}
        />
      </TabItem>
      <TabItem onPress={() => handleNavigate('Profile')}>
        {user.avatar ? (
          <Avatar source={{uri: user.avatar}} />
        ) : (
          <Icon
            name="user"
            size={24}
            color="#5457ff"
            active={state.index === 4}
          />
        )}
      </TabItem>
    </TabArea>
  );
};

export default TabBar;
