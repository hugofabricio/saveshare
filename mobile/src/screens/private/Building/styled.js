import styled from 'styled-components/native';
import FeatherIcon from 'react-native-vector-icons/Feather';
import {getBottomSpace} from 'react-native-iphone-x-helper';

export const SafeView = styled.KeyboardAvoidingView`
  flex: 1;
`;

export const Container = styled.View`
  flex: 1;
  background-color: #f8fafe;
`;

export const Scroller = styled.ScrollView`
  flex: 1;
  margin-bottom: 120px;
`;

export const LoadingIcon = styled.ActivityIndicator`
  flex: 1;
  margin-top: auto;
  margin-bottom: auto;
`;

export const Heading = styled.View``;

export const BackButton = styled.TouchableOpacity`
  position: absolute;
  top: 60px;
  left: 24px;
  background-color: #fff;
  width: 40px;
  height: 40px;
  border-radius: 20px;
  align-items: center;
  justify-content: center;
  box-shadow: 0px 4px 10px rgba(62, 68, 98, 0.2);
`;

export const BackIcon = styled(FeatherIcon)``;

export const Body = styled.View`
  padding: 0 24px;
`;

export const CaptionArea = styled.View`
  background-color: #ffffff;
  border-radius: 8px;
  padding: 24px;
  box-shadow: 0px 4px 10px rgba(62, 68, 98, 0.2);
  transform: translateY(-40px);
  justify-content: center;
  align-items: center;
`;

export const Title = styled.Text`
  color: #5457ff;
  font-size: 18px;
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
  margin-bottom: 12px;
`;

export const Amount = styled.Text`
  font-family: 'Poppins-Bold';
  font-size: 20px;
`;

export const AmountPeriod = styled.Text`
  font-family: 'Poppins-Medium';
`;

export const DetailsArea = styled.View``;

export const DetailsTitle = styled.Text`
  color: #1eecbc;
  font-size: 24px;
  font-family: 'Poppins-Medium';
  margin-bottom: 12px;
`;

export const DetailsText = styled.Text`
  margin-bottom: 12px;
  font-family: 'Poppins-Regular';
  color: #95a5a6;
  font-size: 16px;
`;

export const Footing = styled.View`
  position: absolute;
  left: 0;
  bottom: 0;
  right: 0;
  background-color: #ffffff;
  padding: 24px 24px ${24 + getBottomSpace()}px;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  box-shadow: 0px -4px 10px rgba(62, 68, 98, 0.05);
`;

export const SwiperDot = styled.View`
  width: 8px;
  height: 8px;
  border-radius: 4px;
  margin: 0 3px;
  background-color: ${({color}) => color};
`;

export const SwiperItem = styled.View`
  flex: 1;
`;

export const SwiperImage = styled.Image`
  width: 100%;
  height: 300px;
`;

export const SwiperFake = styled.View`
  width: 100%;
  height: 300px;
  background-color: #5457ff;
`;

export const DetailsList = styled.View``;

export const DetailsItem = styled.View`
  margin-bottom: 8px;
  flex-direction: row;
  align-items: center;
`;

export const DetailsItemIcon = styled(FeatherIcon)`
  margin-right: 8px;
`;

export const DetailsItemText = styled.Text`
  font-family: 'Poppins-Regular';
  color: #95a5a6;
  font-size: 16px;
`;
