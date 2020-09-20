import React from 'react';
import {Container, ButtonText} from './styled';

const Button = ({children, color, bgColor, ...rest}) => (
  <Container bgColor={bgColor} {...rest}>
    <ButtonText color={color}>{children}</ButtonText>
  </Container>
);

Button.defaultProps = {
  color: '#ffffff',
  bgColor: '#3D3FDB',
};

export default Button;
