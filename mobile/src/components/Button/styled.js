import styled from 'styled-components/native';
import {RectButton} from 'react-native-gesture-handler';

export const Container = styled(RectButton)`
  width: 100%;
  height: 52px;
  border-radius: 8px;
  justify-content: center;
  align-items: center;
  background-color: ${({bgColor}) => bgColor};
`;

export const ButtonText = styled.Text`
  font-family: 'Poppins-Medium';
  font-size: 18px;
  color: ${({color}) => color};
`;
