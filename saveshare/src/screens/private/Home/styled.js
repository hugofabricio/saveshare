import styled from 'styled-components/native';
import ButtonTag from '../../../components/ButtonTag';

export const SafeView = styled.KeyboardAvoidingView`
  flex: 1;
`;

export const Container = styled.SafeAreaView`
  flex: 1;
  background-color: #f8fafe;
`;

export const Scroller = styled.ScrollView`
  flex: 1;
  padding: 24px;
`;

export const LocationArea = styled.View`
  margin-bottom: 8px;
`;

export const HeaderArea = styled.View`
  margin-bottom: 24px;
`;

export const HeaderTitle = styled.Text`
  font-family: 'Poppins-SemiBold';
  font-size: 24px;
  color: #5457ff;
  margin-bottom: 8px;
`;

export const HeaderSubtitle = styled.Text`
  font-size: 18px;
  font-family: 'Poppins-Regular';
  color: #95a5a6;
`;

export const FilterArea = styled.View`
  flex-direction: row;
  justify-content: space-between;
`;

export const FilterButton = styled(ButtonTag)`
  width: 22%;
`;

export const ResultsArea = styled.View`
  margin-top: 30px;
  margin-bottom: 30px;
`;

export const LoadingIcon = styled.ActivityIndicator`
  flex: 1;
  margin-top: auto;
  margin-bottom: auto;
`;
