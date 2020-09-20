/* eslint-disable react-native/no-inline-styles */
import React, {useContext, useState, useEffect} from 'react';
import {
  SafeView,
  Container,
  Scroller,
  LocationArea,
  HeaderArea,
  HeaderTitle,
  HeaderSubtitle,
  FilterArea,
  FilterButton,
  ResultsArea,
  LoadingIcon,
} from './styled';
import {Platform, RefreshControl} from 'react-native';
import Input from '../../../components/Input';
import Card from '../../../components/Card';
import {UserContext} from '../../../contexts/UserContext';
import menu from './menu';
import {request, PERMISSIONS} from 'react-native-permissions';
import Geolocation from '@react-native-community/geolocation';
import Api from '../../../services/api';

const Home = () => {
  const {state: user} = useContext(UserContext);
  const [loading, setLoading] = useState(false);
  const [coords, setCoords] = useState({});
  const [location, setLocation] = useState('');
  const [results, setResults] = useState([]);
  const [refreshing, setRefreshing] = useState(false);

  const handleLocation = async () => {
    setCoords({});

    const result = await request(
      Platform.OS === 'ios'
        ? PERMISSIONS.IOS.LOCATION_WHEN_IN_USE
        : PERMISSIONS.ANDROID.ACCESS_FINE_LOCATION,
    );

    if (result === 'granted') {
      setLoading(true);
      setLocation('');
      setResults([]);

      Geolocation.getCurrentPosition((info) => {
        setCoords(info.coords);

        getResults();
      });
    }
  };

  const getResults = async () => {
    setLoading(true);
    setResults([]);

    const {latitude, longitude} = coords;

    const data = await Api.getResults(latitude, longitude, location);

    setResults(data);
    setLoading(false);
  };

  const handleOnRefresh = () => {
    setRefreshing(false);
    getResults();
  };

  const handleLocationSearch = () => {
    setCoords({});
    getResults();
  };

  useEffect(() => {
    getResults();
  }, []);

  return (
    <SafeView behavior={Platform.OS === 'ios' ? 'padding' : undefined} enabled>
      <Container>
        <Scroller
          refreshControl={
            <RefreshControl
              tintColor="#5457FF"
              refreshing={refreshing}
              onRefresh={handleOnRefresh}
            />
          }
          contentContainerStyle={{flex: loading}}
          keyboardShouldPersistTaps="handled">
          <HeaderArea>
            <HeaderTitle numberOfLines={2}>Olá, {user.name}</HeaderTitle>
            <HeaderSubtitle>Encontre espaços para o seu negócio</HeaderSubtitle>
          </HeaderArea>

          <LocationArea>
            <Input
              bgColor="rgba(149, 165, 166, 0.08)"
              icon="map-pin"
              handleIcon={handleLocation}
              placeholder="Onde você está?"
              autoCapitalize="none"
              removeBorder
              value={location}
              onChangeText={(value) => setLocation(value)}
              onSubmitEditing={handleLocationSearch}
            />
          </LocationArea>

          <FilterArea>
            {menu.map((item, i) => (
              <FilterButton key={i} {...item} />
            ))}
          </FilterArea>

          {loading ? (
            <LoadingIcon color="#5457FF" size="large" />
          ) : (
            <ResultsArea>
              {results.map((item, i) => (
                <Card key={i} {...item} />
              ))}
            </ResultsArea>
          )}
        </Scroller>
      </Container>
    </SafeView>
  );
};

export default Home;
