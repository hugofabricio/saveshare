/* eslint-disable react-hooks/exhaustive-deps */
import React, {useEffect, useContext} from 'react';
import {Container, LoadingIcon, Background} from './styled';
import auth from '@react-native-firebase/auth';
import {useNavigation} from '@react-navigation/native';
import {AuthContext} from '../../../contexts/AuthProvider';
import Brand from '../../../components/Brand';

const Preload = () => {
  const {setUser} = useContext(AuthContext);

  const navigation = useNavigation();

  const onAuthStateChanged = (result) => {
    setTimeout(() => {
      if (!result) {
        return navigation.navigate('SignIn');
      }

      setUser(result);

      return navigation.navigate('MainTab');
    }, 1000);
  };

  useEffect(() => {
    return auth().onAuthStateChanged(onAuthStateChanged);
  }, []);

  return (
    <Background resizeMode="cover">
      <Container>
        <Brand marginTop="auto" />
        <LoadingIcon color="#ffffff" size="large" />
      </Container>
    </Background>
  );
};

export default Preload;
