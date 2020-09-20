import styled from 'styled-components/native';
import BgSplash from '../../../assets/images/bg-splash.png';

export const Container = styled.SafeAreaView`
  flex: 1;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`;

export const LoadingIcon = styled.ActivityIndicator`
  margin-top: auto;
  margin-bottom: 48px;
  flex: 0;
`;

export const Background = styled.ImageBackground.attrs({
  source: BgSplash,
})`
  flex: 1;
  width: 100%;
  height: 100%;
  background-color: #5457ff;
`;
