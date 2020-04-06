import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './command.reducer';
import { ICommand } from 'app/shared/model/command.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ICommandDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const CommandDetail = (props: ICommandDetailProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const { commandEntity } = props;
  return (
    <Row>
      <Col md="8">
        <h2>
          <Translate contentKey="rabackApp.command.detail.title">Command</Translate> [<b>{commandEntity.id}</b>]
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="reference">
              <Translate contentKey="rabackApp.command.reference">Reference</Translate>
            </span>
          </dt>
          <dd>{commandEntity.reference}</dd>
          <dt>
            <span id="date">
              <Translate contentKey="rabackApp.command.date">Date</Translate>
            </span>
          </dt>
          <dd>
            <TextFormat value={commandEntity.date} type="date" format={APP_DATE_FORMAT} />
          </dd>
          <dt>
            <span id="customerId">
              <Translate contentKey="rabackApp.command.customerId">Customer Id</Translate>
            </span>
          </dt>
          <dd>{commandEntity.customerId}</dd>
          <dt>
            <span id="basket">
              <Translate contentKey="rabackApp.command.basket">Basket</Translate>
            </span>
          </dt>
          <dd>{commandEntity.basket}</dd>
          <dt>
            <span id="totalExTaxes">
              <Translate contentKey="rabackApp.command.totalExTaxes">Total Ex Taxes</Translate>
            </span>
          </dt>
          <dd>{commandEntity.totalExTaxes}</dd>
          <dt>
            <span id="deliveryFees">
              <Translate contentKey="rabackApp.command.deliveryFees">Delivery Fees</Translate>
            </span>
          </dt>
          <dd>{commandEntity.deliveryFees}</dd>
          <dt>
            <span id="taxRate">
              <Translate contentKey="rabackApp.command.taxRate">Tax Rate</Translate>
            </span>
          </dt>
          <dd>{commandEntity.taxRate}</dd>
          <dt>
            <span id="taxes">
              <Translate contentKey="rabackApp.command.taxes">Taxes</Translate>
            </span>
          </dt>
          <dd>{commandEntity.taxes}</dd>
          <dt>
            <span id="total">
              <Translate contentKey="rabackApp.command.total">Total</Translate>
            </span>
          </dt>
          <dd>{commandEntity.total}</dd>
          <dt>
            <span id="status">
              <Translate contentKey="rabackApp.command.status">Status</Translate>
            </span>
          </dt>
          <dd>{commandEntity.status}</dd>
          <dt>
            <span id="returned">
              <Translate contentKey="rabackApp.command.returned">Returned</Translate>
            </span>
          </dt>
          <dd>{commandEntity.returned ? 'true' : 'false'}</dd>
        </dl>
        <Button tag={Link} to="/command" replace color="info">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/command/${commandEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

const mapStateToProps = ({ command }: IRootState) => ({
  commandEntity: command.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(CommandDetail);
