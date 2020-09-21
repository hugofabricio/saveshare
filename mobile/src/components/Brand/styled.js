import styled from 'styled-components/native';
import {isString} from '../../util/type-check';

export const BrandArea = styled.View`
  width: 80%;
  height: 40px;

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
