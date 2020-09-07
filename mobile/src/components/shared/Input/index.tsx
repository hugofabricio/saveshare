import React from 'react';
import {Container, TextInput} from './styled';

import {TextInputProps} from 'react-native';

interface InputProps extends TextInputProps {
  name: string;
  icon: string;
}

const Input: React.FC<InputProps> = ({name, icon, ...rest}) => (
  <Container>
    <TextInput placeholderTextColor="#95A5A6" {...rest} />
  </Container>
);

export default Input;
