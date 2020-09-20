import React from 'react';
import {BrandLogo} from './styled';

const Brand = ({color, width, height, ...rest}) => (
  <BrandLogo color={color} width={width} height={height} {...rest} />
);

Brand.defaultProps = {
  color: '#ffffff',
  width: '100%',
  height: 40,
};

export default Brand;
