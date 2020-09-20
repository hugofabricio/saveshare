import * as Yup from 'yup';

export const validationSchema = Yup.object().shape({
  email: Yup.string().email().required(),
  password: Yup.string().min(4).required(),
});

export const defaultValues = {
  email: '',
  password: '',
};
