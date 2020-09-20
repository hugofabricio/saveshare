import React from 'react';

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

const Card = ({title, image, location, price, rate, ...rest}) => (
  <Container activeOpacity={0.6}>
    <Background source={{uri: image}} resizeMode="cover">
      <Caption>
        <Title>{title}</Title>
        <Location>
          <LocationIcon name="map-pin" size={16} color="#1EECBC" />
          <LocationLabel>{location.neighborhood}</LocationLabel>
        </Location>
        <Footing>
          <Amount>
            {price.value}
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

export default Card;
