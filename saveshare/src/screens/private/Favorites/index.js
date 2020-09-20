import React from 'react';
import {SafeView, Container} from './styled';
import {Platform} from 'react-native';

const Favorites = () => {
  return (
    <SafeView behavior={Platform.OS === 'ios' ? 'padding' : undefined} enabled>
      <Container />
    </SafeView>
  );
};

export default Favorites;
