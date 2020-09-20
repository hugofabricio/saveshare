import Logo from '../../assets/vectors/brand.svg';
import styled from 'styled-components/native';
import {isString} from '../../util/type-check';

export const BrandLogo = styled(Logo)`
  color: ${({color}) => color};

  ${({width}) =>
    width &&
    `
    width: ${isString(width) ? width : `${width}px`};
  `}

  ${({height}) =>
    height &&
    `
    height: ${isString(height) ? height : `${height}px`};
  `}

  ${({marginTop}) =>
    marginTop &&
    `
    margin-top: ${isString(marginTop) ? marginTop : `${marginTop}px`};
  `}

  ${({marginBottom}) =>
    marginBottom &&
    `
    margin-bottom: ${
      isString(marginBottom) ? marginBottom : `${marginBottom}px`
    };
  `}

  ${({marginLeft}) =>
    marginLeft &&
    `
    margin-left: ${isString(marginLeft) ? marginLeft : `${marginLeft}px`};
  `}

  ${({marginRight}) =>
    marginRight &&
    `
    margin-right: ${isString(marginRight) ? marginRight : `${marginRight}px`};
  `}
`;
