import React, {useEffect, useContext} from 'react';
import {useNavigation} from '@react-navigation/native';
import {
  SafeView,
  Container,
  FormArea,
  SignUpButton,
  SignUpText,
  SignUpAction,
} from './styled';
import {useForm} from 'react-hook-form';
import {Alert, ScrollView, Platform} from 'react-native';
import {validationSchema, defaultValues} from './schema';
import Api from '../../../services/api';
import Input from '../../../components/Input';
import Button from '../../../components/Button';
import {yupResolver} from '@hookform/resolvers';
import AsyncStorage from '@react-native-community/async-storage';
import {UserContext} from '../../../contexts/UserContext';
import Brand from '../../../components/Brand';

const SignUp = () => {
  const {dispatch: userDispatch} = useContext(UserContext);
  const navigation = useNavigation();

  const {register, handleSubmit, setValue, errors} = useForm({
    defaultValues,
    resolver: yupResolver(validationSchema),
  });

  useEffect(() => {
    register('name');
    register('email');
    register('password');
  }, [register]);

  const onSubmit = async ({name, email, password}) => {
    const response = await Api.signUp(name, email, password);

    if (!response.token) {
      return Alert.alert('Ops', 'E-mail ou senha inválidos.');
    }

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
  };

  const handleSignClick = () => {
    navigation.reset({
      routes: [
        {
          name: 'SignIn',
        },
      ],
    });
  };

  return (
    <SafeView behavior={Platform.OS === 'ios' ? 'padding' : undefined} enabled>
      <ScrollView
        contentContainerStyle={{flex: 1}}
        keyboardShouldPersistTaps="handled">
        <Container>
          <Brand marginBottom={32} />
          <FormArea>
            <Input
              icon="user"
              placeholder="Nome"
              onChangeText={(value) => setValue('name', value, true)}
              error={errors.name}
            />
            <Input
              icon="mail"
              placeholder="E-mail"
              onChangeText={(value) => setValue('email', value, true)}
              autoCompleteType="email"
              autoCapitalize="none"
              keyboardType="email-address"
              textContentType="emailAddress"
              error={errors.email}
            />
            <Input
              icon="lock"
              placeholder="Senha"
              onChangeText={(value) => setValue('password', value, true)}
              autoCompleteType="password"
              secureTextEntry={true}
              autoCapitalize="none"
              textContentType="password"
              blurOnSubmit={false}
              error={errors.password}
            />
            <Button onPress={handleSubmit(onSubmit)}>Cadastrar</Button>
          </FormArea>

          <SignUpButton onPress={handleSignClick}>
            <SignUpText>Já possui uma conta?</SignUpText>
            <SignUpAction>Acessar</SignUpAction>
          </SignUpButton>
        </Container>
      </ScrollView>
    </SafeView>
  );
};

export default SignUp;
