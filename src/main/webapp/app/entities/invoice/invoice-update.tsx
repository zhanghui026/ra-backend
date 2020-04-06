import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './invoice.reducer';
import { IInvoice } from 'app/shared/model/invoice.model';
import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IInvoiceUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const InvoiceUpdate = (props: IInvoiceUpdateProps) => {
  const [isNew, setIsNew] = useState(!props.match.params || !props.match.params.id);

  const { invoiceEntity, loading, updating } = props;

  const handleClose = () => {
    props.history.push('/invoice' + props.location.search);
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
        ...invoiceEntity,
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
          <h2 id="rabackApp.invoice.home.createOrEditLabel">
            <Translate contentKey="rabackApp.invoice.home.createOrEditLabel">Create or edit a Invoice</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <AvForm model={isNew ? {} : invoiceEntity} onSubmit={saveEntity}>
              {!isNew ? (
                <AvGroup>
                  <Label for="invoice-id">
                    <Translate contentKey="global.field.id">ID</Translate>
                  </Label>
                  <AvInput id="invoice-id" type="text" className="form-control" name="id" required readOnly />
                </AvGroup>
              ) : null}
              <AvGroup>
                <Label id="dateLabel" for="invoice-date">
                  <Translate contentKey="rabackApp.invoice.date">Date</Translate>
                </Label>
                <AvInput
                  id="invoice-date"
                  type="datetime-local"
                  className="form-control"
                  name="date"
                  placeholder={'YYYY-MM-DD HH:mm'}
                  value={isNew ? displayDefaultDateTime() : convertDateTimeFromServer(props.invoiceEntity.date)}
                />
              </AvGroup>
              <AvGroup>
                <Label id="customerIdLabel" for="invoice-customerId">
                  <Translate contentKey="rabackApp.invoice.customerId">Customer Id</Translate>
                </Label>
                <AvField id="invoice-customerId" type="string" className="form-control" name="customerId" />
              </AvGroup>
              <AvGroup>
                <Label id="commandIdLabel" for="invoice-commandId">
                  <Translate contentKey="rabackApp.invoice.commandId">Command Id</Translate>
                </Label>
                <AvField id="invoice-commandId" type="string" className="form-control" name="commandId" />
              </AvGroup>
              <AvGroup>
                <Label id="totalExTaxesLabel" for="invoice-totalExTaxes">
                  <Translate contentKey="rabackApp.invoice.totalExTaxes">Total Ex Taxes</Translate>
                </Label>
                <AvField id="invoice-totalExTaxes" type="string" className="form-control" name="totalExTaxes" />
              </AvGroup>
              <AvGroup>
                <Label id="deliveryFeesLabel" for="invoice-deliveryFees">
                  <Translate contentKey="rabackApp.invoice.deliveryFees">Delivery Fees</Translate>
                </Label>
                <AvField id="invoice-deliveryFees" type="string" className="form-control" name="deliveryFees" />
              </AvGroup>
              <AvGroup>
                <Label id="taxRateLabel" for="invoice-taxRate">
                  <Translate contentKey="rabackApp.invoice.taxRate">Tax Rate</Translate>
                </Label>
                <AvField id="invoice-taxRate" type="string" className="form-control" name="taxRate" />
              </AvGroup>
              <AvGroup>
                <Label id="taxesLabel" for="invoice-taxes">
                  <Translate contentKey="rabackApp.invoice.taxes">Taxes</Translate>
                </Label>
                <AvField id="invoice-taxes" type="string" className="form-control" name="taxes" />
              </AvGroup>
              <AvGroup>
                <Label id="totalLabel" for="invoice-total">
                  <Translate contentKey="rabackApp.invoice.total">Total</Translate>
                </Label>
                <AvField id="invoice-total" type="string" className="form-control" name="total" />
              </AvGroup>
              <Button tag={Link} id="cancel-save" to="/invoice" replace color="info">
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
  invoiceEntity: storeState.invoice.entity,
  loading: storeState.invoice.loading,
  updating: storeState.invoice.updating,
  updateSuccess: storeState.invoice.updateSuccess
});

const mapDispatchToProps = {
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(InvoiceUpdate);
