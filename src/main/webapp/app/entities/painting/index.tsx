import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Painting from './painting';
import PaintingDetail from './painting-detail';
import PaintingUpdate from './painting-update';
import PaintingDeleteDialog from './painting-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/:id/delete`} component={PaintingDeleteDialog} />
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={PaintingUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={PaintingUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={PaintingDetail} />
      <ErrorBoundaryRoute path={match.url} component={Painting} />
    </Switch>
  </>
);

export default Routes;
