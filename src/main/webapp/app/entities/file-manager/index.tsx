import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import FileManager from './file-manager';
import FileManagerDetail from './file-manager-detail';
import FileManagerUpdate from './file-manager-update';
import FileManagerDeleteDialog from './file-manager-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/:id/delete`} component={FileManagerDeleteDialog} />
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={FileManagerUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={FileManagerUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={FileManagerDetail} />
      <ErrorBoundaryRoute path={match.url} component={FileManager} />
    </Switch>
  </>
);

export default Routes;
