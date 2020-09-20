import React from 'react';
import {SafeView, Container} from './styled';
import {Platform} from 'react-native';

const Search = () => {
  return (
    <SafeView behavior={Platform.OS === 'ios' ? 'padding' : undefined} enabled>
      <Container />
    </SafeView>
  );
};

export default Search;
