import styled from 'styled-components/native';
import FeatherIcon from 'react-native-vector-icons/Feather';

export const Container = styled.TouchableOpacity`
  background-color: #d6e4e2;
  border-radius: 8px;
  margin-bottom: 24px;
  height: 280px;
  box-shadow: 0px 4px 10px rgba(62, 68, 98, 0.2);
`;

export const Background = styled.ImageBackground`
  flex: 1;
  width: 100%;
  height: 100%;
  padding: 20px;
  border-radius: 8px;
  justify-content: flex-end;
  overflow: hidden;
`;

export const Caption = styled.View`
  background-color: #ffffff;
  border-radius: 8px;
  padding: 20px;
`;

export const Title = styled.Text`
  color: #5457ff;
  font-size: 16px;
  font-family: 'Poppins-SemiBold';
  margin-bottom: 8px;
`;

export const Location = styled.View`
  flex-direction: row;
`;

export const LocationIcon = styled(FeatherIcon)`
  margin-right: 6px;
`;

export const LocationLabel = styled.Text`
  font-family: 'Poppins-Medium';
  font-size: 12px;
  color: #95a5a6;
`;

export const Footing = styled.View`
  flex-direction: row;
  justify-content: space-between;
  margin-top: 12px;
`;

export const Amount = styled.Text`
  font-family: 'Poppins-Bold';
`;

export const AmountPeriod = styled.Text`
  font-family: 'Poppins-Medium';
`;

export const Rating = styled.View`
  flex-direction: row;
  align-items: center;
`;

export const RatingIcon = styled(FeatherIcon)`
  margin-right: 4px;
`;

export const RatingLabel = styled.Text``;
