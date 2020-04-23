import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Museum from './museum';
import MuseumDetail from './museum-detail';
import MuseumUpdate from './museum-update';
import MuseumDeleteDialog from './museum-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/:id/delete`} component={MuseumDeleteDialog} />
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={MuseumUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={MuseumUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={MuseumDetail} />
      <ErrorBoundaryRoute path={match.url} component={Museum} />
    </Switch>
  </>
);

export default Routes;
