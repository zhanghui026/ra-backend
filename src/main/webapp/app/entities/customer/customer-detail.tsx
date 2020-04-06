import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './customer.reducer';
import { ICustomer } from 'app/shared/model/customer.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ICustomerDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const CustomerDetail = (props: ICustomerDetailProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const { customerEntity } = props;
  return (
    <Row>
      <Col md="8">
        <h2>
          <Translate contentKey="rabackApp.customer.detail.title">Customer</Translate> [<b>{customerEntity.id}</b>]
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="firstName">
              <Translate contentKey="rabackApp.customer.firstName">First Name</Translate>
            </span>
          </dt>
          <dd>{customerEntity.firstName}</dd>
          <dt>
            <span id="lastName">
              <Translate contentKey="rabackApp.customer.lastName">Last Name</Translate>
            </span>
          </dt>
          <dd>{customerEntity.lastName}</dd>
          <dt>
            <span id="email">
              <Translate contentKey="rabackApp.customer.email">Email</Translate>
            </span>
          </dt>
          <dd>{customerEntity.email}</dd>
          <dt>
            <span id="address">
              <Translate contentKey="rabackApp.customer.address">Address</Translate>
            </span>
          </dt>
          <dd>{customerEntity.address}</dd>
          <dt>
            <span id="zipcode">
              <Translate contentKey="rabackApp.customer.zipcode">Zipcode</Translate>
            </span>
          </dt>
          <dd>{customerEntity.zipcode}</dd>
          <dt>
            <span id="city">
              <Translate contentKey="rabackApp.customer.city">City</Translate>
            </span>
          </dt>
          <dd>{customerEntity.city}</dd>
          <dt>
            <span id="avatar">
              <Translate contentKey="rabackApp.customer.avatar">Avatar</Translate>
            </span>
          </dt>
          <dd>{customerEntity.avatar}</dd>
          <dt>
            <span id="birthday">
              <Translate contentKey="rabackApp.customer.birthday">Birthday</Translate>
            </span>
          </dt>
          <dd>
            <TextFormat value={customerEntity.birthday} type="date" format={APP_DATE_FORMAT} />
          </dd>
          <dt>
            <span id="firstSeen">
              <Translate contentKey="rabackApp.customer.firstSeen">First Seen</Translate>
            </span>
          </dt>
          <dd>
            <TextFormat value={customerEntity.firstSeen} type="date" format={APP_DATE_FORMAT} />
          </dd>
          <dt>
            <span id="lastSeen">
              <Translate contentKey="rabackApp.customer.lastSeen">Last Seen</Translate>
            </span>
          </dt>
          <dd>
            <TextFormat value={customerEntity.lastSeen} type="date" format={APP_DATE_FORMAT} />
          </dd>
          <dt>
            <span id="hasOrdered">
              <Translate contentKey="rabackApp.customer.hasOrdered">Has Ordered</Translate>
            </span>
          </dt>
          <dd>{customerEntity.hasOrdered ? 'true' : 'false'}</dd>
          <dt>
            <span id="latestPurchase">
              <Translate contentKey="rabackApp.customer.latestPurchase">Latest Purchase</Translate>
            </span>
          </dt>
          <dd>
            <TextFormat value={customerEntity.latestPurchase} type="date" format={APP_DATE_FORMAT} />
          </dd>
          <dt>
            <span id="hasNewsletter">
              <Translate contentKey="rabackApp.customer.hasNewsletter">Has Newsletter</Translate>
            </span>
          </dt>
          <dd>{customerEntity.hasNewsletter ? 'true' : 'false'}</dd>
          <dt>
            <span id="groups">
              <Translate contentKey="rabackApp.customer.groups">Groups</Translate>
            </span>
          </dt>
          <dd>{customerEntity.groups}</dd>
          <dt>
            <span id="nbCommands">
              <Translate contentKey="rabackApp.customer.nbCommands">Nb Commands</Translate>
            </span>
          </dt>
          <dd>{customerEntity.nbCommands}</dd>
          <dt>
            <span id="totalSpend">
              <Translate contentKey="rabackApp.customer.totalSpend">Total Spend</Translate>
            </span>
          </dt>
          <dd>{customerEntity.totalSpend}</dd>
        </dl>
        <Button tag={Link} to="/customer" replace color="info">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/customer/${customerEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

const mapStateToProps = ({ customer }: IRootState) => ({
  customerEntity: customer.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(CustomerDetail);
