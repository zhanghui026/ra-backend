import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './command.reducer';
import { ICommand } from 'app/shared/model/command.model';
import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface ICommandUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const CommandUpdate = (props: ICommandUpdateProps) => {
  const [isNew, setIsNew] = useState(!props.match.params || !props.match.params.id);

  const { commandEntity, loading, updating } = props;

  const handleClose = () => {
    props.history.push('/command' + props.location.search);
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
    values.date = convertDateTimeToServer(values.date);

    if (errors.length === 0) {
      const entity = {
        ...commandEntity,
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
          <h2 id="rabackApp.command.home.createOrEditLabel">
            <Translate contentKey="rabackApp.command.home.createOrEditLabel">Create or edit a Command</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <AvForm model={isNew ? {} : commandEntity} onSubmit={saveEntity}>
              {!isNew ? (
                <AvGroup>
                  <Label for="command-id">
                    <Translate contentKey="global.field.id">ID</Translate>
                  </Label>
                  <AvInput id="command-id" type="text" className="form-control" name="id" required readOnly />
                </AvGroup>
              ) : null}
              <AvGroup>
                <Label id="referenceLabel" for="command-reference">
                  <Translate contentKey="rabackApp.command.reference">Reference</Translate>
                </Label>
                <AvField id="command-reference" type="text" name="reference" />
              </AvGroup>
              <AvGroup>
                <Label id="dateLabel" for="command-date">
                  <Translate contentKey="rabackApp.command.date">Date</Translate>
                </Label>
                <AvInput
                  id="command-date"
                  type="datetime-local"
                  className="form-control"
                  name="date"
                  placeholder={'YYYY-MM-DD HH:mm'}
                  value={isNew ? displayDefaultDateTime() : convertDateTimeFromServer(props.commandEntity.date)}
                />
              </AvGroup>
              <AvGroup>
                <Label id="customerIdLabel" for="command-customerId">
                  <Translate contentKey="rabackApp.command.customerId">Customer Id</Translate>
                </Label>
                <AvField id="command-customerId" type="string" className="form-control" name="customerId" />
              </AvGroup>
              <AvGroup>
                <Label id="basketLabel" for="command-basket">
                  <Translate contentKey="rabackApp.command.basket">Basket</Translate>
                </Label>
                <AvField id="command-basket" type="text" name="basket" />
              </AvGroup>
              <AvGroup>
                <Label id="totalExTaxesLabel" for="command-totalExTaxes">
                  <Translate contentKey="rabackApp.command.totalExTaxes">Total Ex Taxes</Translate>
                </Label>
                <AvField id="command-totalExTaxes" type="string" className="form-control" name="totalExTaxes" />
              </AvGroup>
              <AvGroup>
                <Label id="deliveryFeesLabel" for="command-deliveryFees">
                  <Translate contentKey="rabackApp.command.deliveryFees">Delivery Fees</Translate>
                </Label>
                <AvField id="command-deliveryFees" type="string" className="form-control" name="deliveryFees" />
              </AvGroup>
              <AvGroup>
                <Label id="taxRateLabel" for="command-taxRate">
                  <Translate contentKey="rabackApp.command.taxRate">Tax Rate</Translate>
                </Label>
                <AvField id="command-taxRate" type="string" className="form-control" name="taxRate" />
              </AvGroup>
              <AvGroup>
                <Label id="taxesLabel" for="command-taxes">
                  <Translate contentKey="rabackApp.command.taxes">Taxes</Translate>
                </Label>
                <AvField id="command-taxes" type="string" className="form-control" name="taxes" />
              </AvGroup>
              <AvGroup>
                <Label id="totalLabel" for="command-total">
                  <Translate contentKey="rabackApp.command.total">Total</Translate>
                </Label>
                <AvField id="command-total" type="string" className="form-control" name="total" />
              </AvGroup>
              <AvGroup>
                <Label id="statusLabel" for="command-status">
                  <Translate contentKey="rabackApp.command.status">Status</Translate>
                </Label>
                <AvField id="command-status" type="text" name="status" />
              </AvGroup>
              <AvGroup check>
                <Label id="returnedLabel">
                  <AvInput id="command-returned" type="checkbox" className="form-check-input" name="returned" />
                  <Translate contentKey="rabackApp.command.returned">Returned</Translate>
                </Label>
              </AvGroup>
              <Button tag={Link} id="cancel-save" to="/command" replace color="info">
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
  commandEntity: storeState.command.entity,
  loading: storeState.command.loading,
  updating: storeState.command.updating,
  updateSuccess: storeState.command.updateSuccess
});

const mapDispatchToProps = {
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(CommandUpdate);
