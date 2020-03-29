import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './client.reducer';
import { IClient } from 'app/shared/model/client.model';
import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IClientUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const ClientUpdate = (props: IClientUpdateProps) => {
  const [isNew, setIsNew] = useState(!props.match.params || !props.match.params.id);

  const { clientEntity, loading, updating } = props;

  const handleClose = () => {
    props.history.push('/client' + props.location.search);
  };

  useEffect(() => {
    if (isNew) {
      props.reset();
    } else {
      props.getEntity(props.match.params.id);
    }
  }, []);

  useEffect(() => {
    if (props.updateSuccess) {
      handleClose();
    }
  }, [props.updateSuccess]);

  const saveEntity = (event, errors, values) => {
    if (errors.length === 0) {
      const entity = {
        ...clientEntity,
        ...values
      };

      if (isNew) {
        props.createEntity(entity);
      } else {
        props.updateEntity(entity);
      }
    }
  };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="rabackApp.client.home.createOrEditLabel">
            <Translate contentKey="rabackApp.client.home.createOrEditLabel">Create or edit a Client</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <AvForm model={isNew ? {} : clientEntity} onSubmit={saveEntity}>
              {!isNew ? (
                <AvGroup>
                  <Label for="client-id">
                    <Translate contentKey="global.field.id">ID</Translate>
                  </Label>
                  <AvInput id="client-id" type="text" className="form-control" name="id" required readOnly />
                </AvGroup>
              ) : null}
              <AvGroup>
                <Label id="nameLabel" for="client-name">
                  <Translate contentKey="rabackApp.client.name">Name</Translate>
                </Label>
                <AvField id="client-name" type="text" name="name" />
              </AvGroup>
              <AvGroup>
                <Label id="usernameLabel" for="client-username">
                  <Translate contentKey="rabackApp.client.username">Username</Translate>
                </Label>
                <AvField id="client-username" type="text" name="username" />
              </AvGroup>
              <AvGroup>
                <Label id="emailLabel" for="client-email">
                  <Translate contentKey="rabackApp.client.email">Email</Translate>
                </Label>
                <AvField id="client-email" type="text" name="email" />
              </AvGroup>
              <AvGroup>
                <Label id="addressLabel" for="client-address">
                  <Translate contentKey="rabackApp.client.address">Address</Translate>
                </Label>
                <AvField id="client-address" type="text" name="address" />
              </AvGroup>
              <AvGroup>
                <Label id="phoneLabel" for="client-phone">
                  <Translate contentKey="rabackApp.client.phone">Phone</Translate>
                </Label>
                <AvField id="client-phone" type="text" name="phone" />
              </AvGroup>
              <AvGroup>
                <Label id="websiteLabel" for="client-website">
                  <Translate contentKey="rabackApp.client.website">Website</Translate>
                </Label>
                <AvField id="client-website" type="text" name="website" />
              </AvGroup>
              <AvGroup>
                <Label id="companyLabel" for="client-company">
                  <Translate contentKey="rabackApp.client.company">Company</Translate>
                </Label>
                <AvField id="client-company" type="text" name="company" />
              </AvGroup>
              <Button tag={Link} id="cancel-save" to="/client" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">
                  <Translate contentKey="entity.action.back">Back</Translate>
                </span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp;
                <Translate contentKey="entity.action.save">Save</Translate>
              </Button>
            </AvForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

const mapStateToProps = (storeState: IRootState) => ({
  clientEntity: storeState.client.entity,
  loading: storeState.client.loading,
  updating: storeState.client.updating,
  updateSuccess: storeState.client.updateSuccess
});

const mapDispatchToProps = {
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(ClientUpdate);
