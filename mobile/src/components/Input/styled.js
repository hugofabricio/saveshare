import styled from 'styled-components/native';
import FeatherIcon from 'react-native-vector-icons/Feather';
import {RectButton} from 'react-native-gesture-handler';

export const Group = styled.View`
  width: 100%;
  height: 52px;
  margin-bottom: 24px;
  padding-left: 16px;
  padding-right: 16px;
  border-radius: 8px;
  box-shadow: 0px 0px 40px rgba(0, 0, 0, 0.05);
  flex-direction: row;
  align-items: center;
  background-color: ${({bgColor}) => bgColor};

  ${({removeBorder, bgColor}) =>
    !removeBorder &&
    `
    border: 2px solid ${bgColor};
  `}

  ${({error}) =>
    error &&
    `
    border-color: #F44336;
  `}
`;

export const Field = styled.TextInput`
  flex: 1;
  font-size: 14px;
  font-family: 'Poppins-Medium';
  color: ${({textColor}) => textColor};
  background-color: rgba(0, 0, 0, 0);
  border: 0;
`;

export const IconButton = styled(RectButton).attrs({
  underlayColor: false,
})``;

export const Icon = styled(FeatherIcon)`
  margin-right: 12px;
`;
