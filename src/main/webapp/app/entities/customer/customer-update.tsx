import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './customer.reducer';
import { ICustomer } from 'app/shared/model/customer.model';
import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface ICustomerUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const CustomerUpdate = (props: ICustomerUpdateProps) => {
  const [isNew, setIsNew] = useState(!props.match.params || !props.match.params.id);

  const { customerEntity, loading, updating } = props;

  const handleClose = () => {
    props.history.push('/customer' + props.location.search);
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
    values.birthday = convertDateTimeToServer(values.birthday);
    values.firstSeen = convertDateTimeToServer(values.firstSeen);
    values.lastSeen = convertDateTimeToServer(values.lastSeen);
    values.latestPurchase = convertDateTimeToServer(values.latestPurchase);

    if (errors.length === 0) {
      const entity = {
        ...customerEntity,
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
          <h2 id="rabackApp.customer.home.createOrEditLabel">
            <Translate contentKey="rabackApp.customer.home.createOrEditLabel">Create or edit a Customer</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <AvForm model={isNew ? {} : customerEntity} onSubmit={saveEntity}>
              {!isNew ? (
                <AvGroup>
                  <Label for="customer-id">
                    <Translate contentKey="global.field.id">ID</Translate>
                  </Label>
                  <AvInput id="customer-id" type="text" className="form-control" name="id" required readOnly />
                </AvGroup>
              ) : null}
              <AvGroup>
                <Label id="firstNameLabel" for="customer-firstName">
                  <Translate contentKey="rabackApp.customer.firstName">First Name</Translate>
                </Label>
                <AvField id="customer-firstName" type="text" name="firstName" />
              </AvGroup>
              <AvGroup>
                <Label id="lastNameLabel" for="customer-lastName">
                  <Translate contentKey="rabackApp.customer.lastName">Last Name</Translate>
                </Label>
                <AvField id="customer-lastName" type="text" name="lastName" />
              </AvGroup>
              <AvGroup>
                <Label id="emailLabel" for="customer-email">
                  <Translate contentKey="rabackApp.customer.email">Email</Translate>
                </Label>
                <AvField id="customer-email" type="text" name="email" />
              </AvGroup>
              <AvGroup>
                <Label id="addressLabel" for="customer-address">
                  <Translate contentKey="rabackApp.customer.address">Address</Translate>
                </Label>
                <AvField id="customer-address" type="text" name="address" />
              </AvGroup>
              <AvGroup>
                <Label id="zipcodeLabel" for="customer-zipcode">
                  <Translate contentKey="rabackApp.customer.zipcode">Zipcode</Translate>
                </Label>
                <AvField id="customer-zipcode" type="text" name="zipcode" />
              </AvGroup>
              <AvGroup>
                <Label id="cityLabel" for="customer-city">
                  <Translate contentKey="rabackApp.customer.city">City</Translate>
                </Label>
                <AvField id="customer-city" type="text" name="city" />
              </AvGroup>
              <AvGroup>
                <Label id="avatarLabel" for="customer-avatar">
                  <Translate contentKey="rabackApp.customer.avatar">Avatar</Translate>
                </Label>
                <AvField id="customer-avatar" type="text" name="avatar" />
              </AvGroup>
              <AvGroup>
                <Label id="birthdayLabel" for="customer-birthday">
                  <Translate contentKey="rabackApp.customer.birthday">Birthday</Translate>
                </Label>
                <AvInput
                  id="customer-birthday"
                  type="datetime-local"
                  className="form-control"
                  name="birthday"
                  placeholder={'YYYY-MM-DD HH:mm'}
                  value={isNew ? displayDefaultDateTime() : convertDateTimeFromServer(props.customerEntity.birthday)}
                />
              </AvGroup>
              <AvGroup>
                <Label id="firstSeenLabel" for="customer-firstSeen">
                  <Translate contentKey="rabackApp.customer.firstSeen">First Seen</Translate>
                </Label>
                <AvInput
                  id="customer-firstSeen"
                  type="datetime-local"
                  className="form-control"
                  name="firstSeen"
                  placeholder={'YYYY-MM-DD HH:mm'}
                  value={isNew ? displayDefaultDateTime() : convertDateTimeFromServer(props.customerEntity.firstSeen)}
                />
              </AvGroup>
              <AvGroup>
                <Label id="lastSeenLabel" for="customer-lastSeen">
                  <Translate contentKey="rabackApp.customer.lastSeen">Last Seen</Translate>
                </Label>
                <AvInput
                  id="customer-lastSeen"
                  type="datetime-local"
                  className="form-control"
                  name="lastSeen"
                  placeholder={'YYYY-MM-DD HH:mm'}
                  value={isNew ? displayDefaultDateTime() : convertDateTimeFromServer(props.customerEntity.lastSeen)}
                />
              </AvGroup>
              <AvGroup check>
                <Label id="hasOrderedLabel">
                  <AvInput id="customer-hasOrdered" type="checkbox" className="form-check-input" name="hasOrdered" />
                  <Translate contentKey="rabackApp.customer.hasOrdered">Has Ordered</Translate>
                </Label>
              </AvGroup>
              <AvGroup>
                <Label id="latestPurchaseLabel" for="customer-latestPurchase">
                  <Translate contentKey="rabackApp.customer.latestPurchase">Latest Purchase</Translate>
                </Label>
                <AvInput
                  id="customer-latestPurchase"
                  type="datetime-local"
                  className="form-control"
                  name="latestPurchase"
                  placeholder={'YYYY-MM-DD HH:mm'}
                  value={isNew ? displayDefaultDateTime() : convertDateTimeFromServer(props.customerEntity.latestPurchase)}
                />
              </AvGroup>
              <AvGroup check>
                <Label id="hasNewsletterLabel">
                  <AvInput id="customer-hasNewsletter" type="checkbox" className="form-check-input" name="hasNewsletter" />
                  <Translate contentKey="rabackApp.customer.hasNewsletter">Has Newsletter</Translate>
                </Label>
              </AvGroup>
              <AvGroup>
                <Label id="groupsLabel" for="customer-groups">
                  <Translate contentKey="rabackApp.customer.groups">Groups</Translate>
                </Label>
                <AvField id="customer-groups" type="text" name="groups" />
              </AvGroup>
              <AvGroup>
                <Label id="nbCommandsLabel" for="customer-nbCommands">
                  <Translate contentKey="rabackApp.customer.nbCommands">Nb Commands</Translate>
                </Label>
                <AvField id="customer-nbCommands" type="string" className="form-control" name="nbCommands" />
              </AvGroup>
              <AvGroup>
                <Label id="totalSpendLabel" for="customer-totalSpend">
                  <Translate contentKey="rabackApp.customer.totalSpend">Total Spend</Translate>
                </Label>
                <AvField id="customer-totalSpend" type="string" className="form-control" name="totalSpend" />
              </AvGroup>
              <Button tag={Link} id="cancel-save" to="/customer" replace color="info">
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
  customerEntity: storeState.customer.entity,
  loading: storeState.customer.loading,
  updating: storeState.customer.updating,
  updateSuccess: storeState.customer.updateSuccess
});

const mapDispatchToProps = {
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(CustomerUpdate);
