import React from 'react';
import {SafeView, Container} from './styled';
import {Platform} from 'react-native';

const Rents = () => {
  return (
    <SafeView behavior={Platform.OS === 'ios' ? 'padding' : undefined} enabled>
      <Container />
    </SafeView>
  );
};

export default Rents;
