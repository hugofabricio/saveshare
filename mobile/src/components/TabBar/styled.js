import styled from 'styled-components/native';
import FeatherIcon from 'react-native-vector-icons/Feather';
import {RectButton} from 'react-native-gesture-handler';

export const TabArea = styled.View`
  padding-left: 12px;
  padding-right: 12px;
  height: 75px;
  background-color: #ffffff;
  flex-direction: row;
  box-shadow: 0px -4px 10px rgba(62, 68, 98, 0.05);
`;

export const TabItem = styled(RectButton).attrs({
  underlayColor: '#fff',
  rippleColor: '#fff',
})`
  flex: 1;
  justify-content: center;
  align-items: center;
`;

export const TabItemCenter = styled(RectButton)`
  width: 60px;
  height: 60px;
  justify-content: center;
  align-items: center;
  border-radius: 30px;
  background-color: #5457ff;
  margin-top: -24px;
  margin-left: 12px;
  margin-right: 12px;
`;

export const Icon = styled(FeatherIcon)`
  ${({active}) =>
    active &&
    `
    color: #1EECBC;
  `}
`;

export const Avatar = styled.Image`
  width: 28px;
  height: 28px;
  border-radius: 14px;
`;
