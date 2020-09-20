import React from 'react';
import {Group, Field, IconButton, Icon} from './styled';

const Input = ({
  icon,
  iconColor,
  handleIcon,
  placeholder,
  textColor,
  bgColor,
  placeholderColor,
  removeBorder,
  error,
  ...rest
}) => {
  return (
    <Group bgColor={bgColor} error={error} removeBorder={removeBorder}>
      {icon && handleIcon ? (
        <IconButton onPress={handleIcon}>
          <Icon name={icon} size={20} color={iconColor} />
        </IconButton>
      ) : (
        <Icon name={icon} size={20} color={iconColor} />
      )}
      <Field
        textColor={textColor}
        placeholder={placeholder}
        placeholderTextColor={placeholderColor}
        {...rest}
      />
    </Group>
  );
};

Input.defaultProps = {
  iconColor: '#5457FF',
  textColor: '#6C898E',
  bgColor: '#ffffff',
  placeholderColor: '#6C898E',
  removeBorder: false,
};

export default Input;
