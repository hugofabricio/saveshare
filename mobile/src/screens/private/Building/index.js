/* eslint-disable react-native/no-inline-styles */
/* eslint-disable react-hooks/exhaustive-deps */
import React, {useState, useEffect} from 'react';
import {
  LoadingIcon,
  SafeView,
  Container,
  Scroller,
  SwiperFake,
  Heading,
  BackButton,
  BackIcon,
  Body,
  CaptionArea,
  Title,
  Location,
  LocationIcon,
  LocationLabel,
  Amount,
  AmountPeriod,
  DetailsArea,
  DetailsTitle,
  DetailsText,
  Footing,
  SwiperDot,
  SwiperItem,
  SwiperImage,
  DetailsList,
  DetailsItem,
  DetailsItemIcon,
  DetailsItemText,
} from './styled';
import {Platform} from 'react-native';
import {useNavigation, useRoute} from '@react-navigation/native';
import Api from '../../../services/api';
import Swiper from 'react-native-swiper';
import Button from '../../../components/Button';
import currency from 'currency.js';

const Building = () => {
  const navigate = useNavigation();
  const route = useRoute();

  const [result, setResult] = useState({
    ...route.params,
  });

  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const getResult = async () => {
      setLoading(true);

      const data = await Api.getResult(result.id);

      setResult(data);
      setLoading(false);
    };

    getResult();
  }, []);

  const handleBack = () => {
    navigate.goBack();
  };

  return (
    <SafeView behavior={Platform.OS === 'ios' ? 'padding' : undefined} enabled>
      <Container>
        <Scroller>
          <Heading>
            {result.gallery && result.gallery.length > 0 ? (
              <Swiper
                style={{height: 300, overflow: 'hidden'}}
                dot={<SwiperDot color="#ffffff" />}
                activeDot={<SwiperDot color="#5457ff" />}
                paginationStyle={{
                  bottom: 60,
                }}
                autoplay={true}>
                {result.gallery.map((item, i) => (
                  <SwiperItem key={i}>
                    <SwiperImage source={{uri: item}} resizeMode="cover" />
                  </SwiperItem>
                ))}
              </Swiper>
            ) : (
              <SwiperFake />
            )}

            <BackButton onPress={handleBack}>
              <BackIcon name="arrow-left" size={24} color="#5457FF" />
            </BackButton>
          </Heading>

          <Body>
            <CaptionArea>
              <Title>{result.title}</Title>
              <Location>
                <LocationIcon name="map-pin" size={16} color="#1EECBC" />
                {result.location && (
                  <LocationLabel>{result.location.neighborhood}</LocationLabel>
                )}
              </Location>
              {result.price && (
                <Amount>
                  {currency(result.price.value, {
                    separator: '.',
                    decimal: ',',
                    symbol: 'R$ ',
                  }).format()}
                  <AmountPeriod>/{result.price.period}</AmountPeriod>
                </Amount>
              )}
            </CaptionArea>

            {loading ? (
              <LoadingIcon color="#5457FF" size="large" />
            ) : (
              <>
                <DetailsArea>
                  <DetailsTitle>Sobre o espaço</DetailsTitle>
                  <DetailsText>{result.body}</DetailsText>
                  <DetailsTitle>Características</DetailsTitle>
                  {result.features && result.features.length > 0 && (
                    <DetailsList>
                      {result.features.map((item, i) => (
                        <DetailsItem key={i}>
                          <DetailsItemIcon
                            name={item.icon}
                            size={16}
                            color="#5457FF"
                          />
                          <DetailsItemText>{item.label}</DetailsItemText>
                        </DetailsItem>
                      ))}
                    </DetailsList>
                  )}
                </DetailsArea>
              </>
            )}
          </Body>
        </Scroller>
        <Footing>
          <Button>Reservar espaço</Button>
        </Footing>
      </Container>
    </SafeView>
  );
};

export default Building;
