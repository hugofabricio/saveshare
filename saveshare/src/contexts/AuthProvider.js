import React, {createContext, useState} from 'react';
import auth from '@react-native-firebase/auth';

export const AuthContext = createContext({});

export const AuthProvider = ({children}) => {
  const [user, setUser] = useState(null);
  return (
    <AuthContext.Provider
      value={{
        user,
        setUser,
        login: async (email, password) => {
          try {
            const response = await auth().signInWithEmailAndPassword(
              email.trim(),
              password,
            );

            return response;
          } catch (error) {
            return error;
          }
        },
        register: async (name, email, password) => {
          try {
            await auth().createUserWithEmailAndPassword(email, password);

            const registeredUser = auth().currentUser;

            await registeredUser.updateProfile({
              displayName: name,
            });

            return registeredUser;
          } catch (error) {
            return error;
          }
        },
        logout: async () => {
          try {
            await auth().signOut();
          } catch (error) {
            return error;
          }
        },
      }}>
      {children}
    </AuthContext.Provider>
  );
};
