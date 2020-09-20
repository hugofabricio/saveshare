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
import Input from '../../../components/Input';
import Button from '../../../components/Button';
import {yupResolver} from '@hookform/resolvers';
import {AuthContext} from '../../../contexts/AuthProvider';
import Brand from '../../../components/Brand';
import auth from '@react-native-firebase/auth';

const SignUp = () => {
  const {register: AuthRegister, setUser} = useContext(AuthContext);

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
    const response = await AuthRegister(name, email, password);

    if (response?.code === 'auth/email-already-in-use') {
      return Alert.alert('Ops', 'Este e-mail já está em uso.');
    }

    if (response?.code === 'auth/invalid-email') {
      return Alert.alert('Ops', 'E-mail inválido.');
    }

    if (response?.code === 'auth/weak-password') {
      return Alert.alert(
        'Ops',
        'A senha que você está utilizando não é segura.',
      );
    }

    auth().onAuthStateChanged((user) => {
      if (user) {
        setUser(user);
      }
    });

    return navigation.reset({
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
