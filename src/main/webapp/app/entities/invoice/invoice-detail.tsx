import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './invoice.reducer';
import { IInvoice } from 'app/shared/model/invoice.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IInvoiceDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const InvoiceDetail = (props: IInvoiceDetailProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const { invoiceEntity } = props;
  return (
    <Row>
      <Col md="8">
        <h2>
          <Translate contentKey="rabackApp.invoice.detail.title">Invoice</Translate> [<b>{invoiceEntity.id}</b>]
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="date">
              <Translate contentKey="rabackApp.invoice.date">Date</Translate>
            </span>
          </dt>
          <dd>
            <TextFormat value={invoiceEntity.date} type="date" format={APP_DATE_FORMAT} />
          </dd>
          <dt>
            <span id="customerId">
              <Translate contentKey="rabackApp.invoice.customerId">Customer Id</Translate>
            </span>
          </dt>
          <dd>{invoiceEntity.customerId}</dd>
          <dt>
            <span id="commandId">
              <Translate contentKey="rabackApp.invoice.commandId">Command Id</Translate>
            </span>
          </dt>
          <dd>{invoiceEntity.commandId}</dd>
          <dt>
            <span id="totalExTaxes">
              <Translate contentKey="rabackApp.invoice.totalExTaxes">Total Ex Taxes</Translate>
            </span>
          </dt>
          <dd>{invoiceEntity.totalExTaxes}</dd>
          <dt>
            <span id="deliveryFees">
              <Translate contentKey="rabackApp.invoice.deliveryFees">Delivery Fees</Translate>
            </span>
          </dt>
          <dd>{invoiceEntity.deliveryFees}</dd>
          <dt>
            <span id="taxRate">
              <Translate contentKey="rabackApp.invoice.taxRate">Tax Rate</Translate>
            </span>
          </dt>
          <dd>{invoiceEntity.taxRate}</dd>
          <dt>
            <span id="taxes">
              <Translate contentKey="rabackApp.invoice.taxes">Taxes</Translate>
            </span>
          </dt>
          <dd>{invoiceEntity.taxes}</dd>
          <dt>
            <span id="total">
              <Translate contentKey="rabackApp.invoice.total">Total</Translate>
            </span>
          </dt>
          <dd>{invoiceEntity.total}</dd>
        </dl>
        <Button tag={Link} to="/invoice" replace color="info">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/invoice/${invoiceEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

const mapStateToProps = ({ invoice }: IRootState) => ({
  invoiceEntity: invoice.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(InvoiceDetail);
