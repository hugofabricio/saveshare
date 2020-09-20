import React from 'react';
import {Container, IconArea, Icon, ButtonText} from './styled';

const Button = ({icon, label, ...rest}) => (
  <Container {...rest}>
    <IconArea>
      <Icon name={icon} color="#5457ff" size={28} />
    </IconArea>
    <ButtonText numberOfLines={1}>{label}</ButtonText>
  </Container>
);

export default Button;
