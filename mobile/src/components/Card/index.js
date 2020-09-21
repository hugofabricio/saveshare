import React from 'react';

import currency from 'currency.js';
import {
  Container,
  Background,
  Caption,
  Title,
  Location,
  LocationIcon,
  LocationLabel,
  Footing,
  Amount,
  AmountPeriod,
  Rating,
  RatingIcon,
  RatingLabel,
} from './styled';
import {useNavigation} from '@react-navigation/native';

const Card = ({id, title, image, location, price, rate}) => {
  const navigation = useNavigation();

  const handleOnClick = () => {
    navigation.navigate('Building', {
      id,
      title,
      image,
      location,
      price,
      rate,
    });
  };

  return (
    <Container onPress={handleOnClick} activeOpacity={0.6}>
      <Background source={{uri: image}} resizeMode="cover">
        <Caption>
          <Title>{title}</Title>
          <Location>
            <LocationIcon name="map-pin" size={16} color="#1EECBC" />
            <LocationLabel>{location.neighborhood}</LocationLabel>
          </Location>
          <Footing>
            <Amount>
              {currency(price.value, {
                separator: '.',
                decimal: ',',
                symbol: 'R$ ',
              }).format()}
              <AmountPeriod>/{price.period}</AmountPeriod>
            </Amount>
            <Rating>
              <RatingIcon name="star" size={16} color="#FFE600" />
              <RatingLabel>{rate}</RatingLabel>
            </Rating>
          </Footing>
        </Caption>
      </Background>
    </Container>
  );
};

export default Card;
