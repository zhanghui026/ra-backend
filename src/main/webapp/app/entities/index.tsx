import React from 'react';
import { Switch } from 'react-router-dom';

// eslint-disable-next-line @typescript-eslint/no-unused-vars
import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Post from './post';
import Client from './client';
import Category from './category';
import Product from './product';
import FileManager from './file-manager';
import Customer from './customer';
import Command from './command';
import Invoice from './invoice';
import Review from './review';
import Artist from './artist';
import Painting from './painting';
import Museum from './museum';
import Tag from './tag';
/* jhipster-needle-add-route-import - JHipster will add routes here */

const Routes = ({ match }) => (
  <div>
    <Switch>
      {/* prettier-ignore */}
      <ErrorBoundaryRoute path={`${match.url}post`} component={Post} />
      <ErrorBoundaryRoute path={`${match.url}client`} component={Client} />
      <ErrorBoundaryRoute path={`${match.url}category`} component={Category} />
      <ErrorBoundaryRoute path={`${match.url}product`} component={Product} />
      <ErrorBoundaryRoute path={`${match.url}file-manager`} component={FileManager} />
      <ErrorBoundaryRoute path={`${match.url}customer`} component={Customer} />
      <ErrorBoundaryRoute path={`${match.url}command`} component={Command} />
      <ErrorBoundaryRoute path={`${match.url}invoice`} component={Invoice} />
      <ErrorBoundaryRoute path={`${match.url}review`} component={Review} />
      <ErrorBoundaryRoute path={`${match.url}artist`} component={Artist} />
      <ErrorBoundaryRoute path={`${match.url}painting`} component={Painting} />
      <ErrorBoundaryRoute path={`${match.url}museum`} component={Museum} />
      <ErrorBoundaryRoute path={`${match.url}tag`} component={Tag} />
      {/* jhipster-needle-add-route-path - JHipster will add routes here */}
    </Switch>
  </div>
);

export default Routes;
