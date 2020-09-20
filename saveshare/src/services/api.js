import AsyncStorage from '@react-native-community/async-storage';
import axios from 'axios';

const BASE_API = 'https://api.b7web.com.br/devbarber/api';

const instance = axios.create({
  baseURL: BASE_API,
});

export default {
  checkToken: async (token) => {
    try {
      const {data} = await instance.post('/auth/refresh', {
        token,
      });

      return data;
    } catch (error) {
      return false;
    }
  },
  signIn: async (email, password) => {
    try {
      const {data} = await instance.post('/auth/login', {
        email,
        password,
      });

      return data;
    } catch (error) {
      return false;
    }
  },
  signUp: async (name, email, password) => {
    try {
      const {data} = await instance.post('/user', {
        name,
        email,
        password,
      });

      return data;
    } catch (error) {
      return false;
    }
  },
  getResults: async (params) => {
    try {
      const token = AsyncStorage.getItem('token');

      const {data} = await axios.get(
        'https://saveshare.netlify.app/api/list.json',
        {
          params: {token, ...params},
        },
      );

      return data;
    } catch (error) {
      return [];
    }
  },
};
