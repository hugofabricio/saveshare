import 'react-native-gesture-handler';
import {NavigationContainer} from '@react-navigation/native';
import React from 'react';
import {StyleSheet, View, StatusBar} from 'react-native';

import Routes from './routes';

const App: React.FC = () => (
  <NavigationContainer>
    <StatusBar barStyle="light-content" backgroundColor="#F8FAFE" />
    <View style={styles.body}>
      <Routes />
    </View>
  </NavigationContainer>
);

const styles = StyleSheet.create({
  body: {
    flex: 1,
    backgroundColor: '#F8FAFE',
  },
});

export default App;
