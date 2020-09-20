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
import {yupResolver} from '@hookform/resolvers';
import Input from '../../../components/Input';
import Button from '../../../components/Button';
import {validationSchema, defaultValues} from './schema';
import {AuthContext} from '../../../contexts/AuthProvider';
import Brand from '../../../components/Brand';

const SignIn = () => {
  const {login: AuthLogin} = useContext(AuthContext);

  const navigation = useNavigation();

  const {register, handleSubmit, setValue, errors} = useForm({
    defaultValues,
    resolver: yupResolver(validationSchema),
  });

  useEffect(() => {
    register('email');
    register('password');
  }, [register]);

  const onSubmit = async ({email, password}) => {
    const response = await AuthLogin(email, password);

    if (response?.code) {
      return Alert.alert('Ops', 'E-mail ou senha inválidos.');
    }

    return navigation.reset({
      routes: [{name: 'MainTab'}],
    });
  };

  const handleSignClick = () => {
    navigation.reset({
      routes: [{name: 'SignUp'}],
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
            <Button onPress={handleSubmit(onSubmit)}>Acessar</Button>
          </FormArea>

          <SignUpButton onPress={handleSignClick}>
            <SignUpText>Ainda não possui uma conta?</SignUpText>
            <SignUpAction>Cadastre-se</SignUpAction>
          </SignUpButton>
        </Container>
      </ScrollView>
    </SafeView>
  );
};

export default SignIn;
