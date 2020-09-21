import styled from 'styled-components/native';
import {RectButton} from 'react-native-gesture-handler';
import FeatherIcon from 'react-native-vector-icons/Feather';

export const Container = styled(RectButton).attrs({
  underlayColor: 'transparent',
  rippleColor: 'transparent',
})`
  align-items: center;
`;

export const IconArea = styled.View`
  width: 100%;
  height: 80px;
  justify-content: center;
  align-items: center;
  border-radius: 8px;
  background-color: #ffffff;
  margin-bottom: 12px;
  box-shadow: 0px 4px 10px rgba(62, 68, 98, 0.1);
`;

export const Icon = styled(FeatherIcon)``;

export const ButtonText = styled.Text`
  font-family: 'Poppins-SemiBold';
  font-size: 12px;
  text-transform: uppercase;
  color: #95a5a6;
`;
