import React, {useEffect, useContext} from 'react';
import {Container, LoadingIcon, Background} from './styled';
import BgSplash from '../../../assets/images/bg-splash.png';
import AsyncStorage from '@react-native-community/async-storage';
import {useNavigation} from '@react-navigation/native';
import Api from '../../../services/api';
import {UserContext} from '../../../contexts/UserContext';
import Brand from '../../../components/Brand';

const Preload = () => {
  const {dispatch: userDispatch} = useContext(UserContext);
  const navigation = useNavigation();

  useEffect(() => {
    const checkToken = async () => {
      const token = await AsyncStorage.getItem('token');

      if (token) {
        const response = await Api.checkToken(token);

        await AsyncStorage.setItem('token', response.token);

        userDispatch({
          type: 'setAvatar',
          payload: {
            avatar: response.data.avatar,
          },
        });

        navigation.reset({
          routes: [{name: 'MainTab'}],
        });
      } else {
        return navigation.navigate('SignIn');
      }
    };

    checkToken();
  }, [navigation, userDispatch]);

  return (
    <Background source={BgSplash} resizeMode="cover">
      <Container>
        <Brand marginTop="auto" />
        <LoadingIcon color="#ffffff" size="large" />
      </Container>
    </Background>
  );
};

export default Preload;
