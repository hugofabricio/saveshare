import styled from 'styled-components/native';
import {RectButton} from 'react-native-gesture-handler';

export const Container = styled(RectButton)`
  width: 100%;
  height: 52px;
  border-radius: 4;
  justify-content: center;
  align-items: center;
  background-color: #5457ff;
`;

export const ButtonText = styled.Text`
  font-family: 'Poppins-Medium';
  font-size: 18px;
  color: #ffffff;
`;
