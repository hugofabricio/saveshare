import axios from 'axios';

export default {
  getLocation: async (lat, lng) => {
    try {
      const {data} = await axios.get(
        'https://geocode.search.hereapi.com/v1/revgeocode',
        {
          params: {
            apiKey: 'caOwBQv3-2hnP08Aj-wWUOuN250GKGQKbO9_KXlaq6Y',
            at: `${lat},${lng}`,
            lang: 'pt-BR',
          },
        },
      );

      return data.items[0];
    } catch (error) {
      return [];
    }
  },
  getResults: async (params) => {
    try {
      const {data} = await axios.get(
        'https://run.mocky.io/v3/ae13da01-660f-4b38-88a3-a0d46a02ea75',
        {
          params,
        },
      );

      return data;
    } catch (error) {
      return [];
    }
  },
  getResult: async (id) => {
    try {
      const {data} = await axios.get(
        'https://run.mocky.io/v3/001c82d9-a223-4a7d-b7f0-94a07af83939',
        {
          id,
        },
      );

      return data;
    } catch (error) {
      return [];
    }
  },
};
