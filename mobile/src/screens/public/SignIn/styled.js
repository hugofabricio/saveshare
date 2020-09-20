import styled from 'styled-components/native';
import {getBottomSpace} from 'react-native-iphone-x-helper';

export const SafeView = styled.KeyboardAvoidingView`
  flex: 1;
`;

export const Container = styled.SafeAreaView`
  background-color: #5457ff;
  flex: 1;
  justify-content: center;
  align-items: center;
`;

export const FormArea = styled.View`
  padding: 40px;
  width: 100%;
`;

export const SignUpButton = styled.TouchableOpacity`
  position: absolute;
  left: 0;
  bottom: 0;
  right: 0;
  border-top-width: 1px;
  border-color: #3d3fdb;
  background-color: #5457ff;
  padding: 24px 0 ${16 + getBottomSpace()}px;
  flex-direction: row;
  justify-content: center;
  align-items: center;
`;

export const SignUpText = styled.Text`
  color: #ffffff;
  font-size: 16px;
`;

export const SignUpAction = styled.Text`
  color: #ffffff;
  font-size: 16px;
  font-weight: bold;
  margin-left: 6px;
`;
