import React from 'react';
import {Text} from 'react-native';
import {Container, Title} from './styled';

import Button from '../../components/shared/Button';

const HomeScreen: React.FC = () => {
  return (
    <Container>
      <Title>Olá, Hugo</Title>
      <Text>Home</Text>
      <Button onPress={() => {}}>Reservar espaço</Button>
    </Container>
  );
};

export default HomeScreen;
