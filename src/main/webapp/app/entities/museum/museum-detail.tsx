import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, UncontrolledTooltip, Row, Col } from 'reactstrap';
import { Translate, ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './museum.reducer';
import { IMuseum } from 'app/shared/model/museum.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IMuseumDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const MuseumDetail = (props: IMuseumDetailProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const { museumEntity } = props;
  return (
    <Row>
      <Col md="8">
        <h2>
          <Translate contentKey="rabackApp.museum.detail.title">Museum</Translate> [<b>{museumEntity.id}</b>]
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="name">
              <Translate contentKey="rabackApp.museum.name">Name</Translate>
            </span>
            <UncontrolledTooltip target="name">
              <Translate contentKey="rabackApp.museum.help.name" />
            </UncontrolledTooltip>
          </dt>
          <dd>{museumEntity.name}</dd>
          <dt>
            <span id="rsName">
              <Translate contentKey="rabackApp.museum.rsName">Rs Name</Translate>
            </span>
          </dt>
          <dd>{museumEntity.rsName}</dd>
          <dt>
            <span id="enName">
              <Translate contentKey="rabackApp.museum.enName">En Name</Translate>
            </span>
          </dt>
          <dd>{museumEntity.enName}</dd>
          <dt>
            <span id="fullName">
              <Translate contentKey="rabackApp.museum.fullName">Full Name</Translate>
            </span>
          </dt>
          <dd>{museumEntity.fullName}</dd>
          <dt>
            <span id="rsFullName">
              <Translate contentKey="rabackApp.museum.rsFullName">Rs Full Name</Translate>
            </span>
          </dt>
          <dd>{museumEntity.rsFullName}</dd>
          <dt>
            <span id="enFullName">
              <Translate contentKey="rabackApp.museum.enFullName">En Full Name</Translate>
            </span>
          </dt>
          <dd>{museumEntity.enFullName}</dd>
          <dt>
            <span id="address">
              <Translate contentKey="rabackApp.museum.address">Address</Translate>
            </span>
          </dt>
          <dd>{museumEntity.address}</dd>
          <dt>
            <span id="rsAddress">
              <Translate contentKey="rabackApp.museum.rsAddress">Rs Address</Translate>
            </span>
          </dt>
          <dd>{museumEntity.rsAddress}</dd>
          <dt>
            <span id="enAddress">
              <Translate contentKey="rabackApp.museum.enAddress">En Address</Translate>
            </span>
          </dt>
          <dd>{museumEntity.enAddress}</dd>
          <dt>
            <span id="brief">
              <Translate contentKey="rabackApp.museum.brief">Brief</Translate>
            </span>
          </dt>
          <dd>{museumEntity.brief}</dd>
          <dt>
            <span id="enBrief">
              <Translate contentKey="rabackApp.museum.enBrief">En Brief</Translate>
            </span>
          </dt>
          <dd>{museumEntity.enBrief}</dd>
          <dt>
            <span id="rsBrief">
              <Translate contentKey="rabackApp.museum.rsBrief">Rs Brief</Translate>
            </span>
          </dt>
          <dd>{museumEntity.rsBrief}</dd>
          <dt>
            <span id="phoneNum">
              <Translate contentKey="rabackApp.museum.phoneNum">Phone Num</Translate>
            </span>
          </dt>
          <dd>{museumEntity.phoneNum}</dd>
          <dt>
            <span id="contactPerson">
              <Translate contentKey="rabackApp.museum.contactPerson">Contact Person</Translate>
            </span>
          </dt>
          <dd>{museumEntity.contactPerson}</dd>
          <dt>
            <span id="createDate">
              <Translate contentKey="rabackApp.museum.createDate">Create Date</Translate>
            </span>
          </dt>
          <dd>
            <TextFormat value={museumEntity.createDate} type="date" format={APP_LOCAL_DATE_FORMAT} />
          </dd>
          <dt>
            <span id="updateDate">
              <Translate contentKey="rabackApp.museum.updateDate">Update Date</Translate>
            </span>
          </dt>
          <dd>
            <TextFormat value={museumEntity.updateDate} type="date" format={APP_LOCAL_DATE_FORMAT} />
          </dd>
          <dt>
            <span id="mainImg">
              <Translate contentKey="rabackApp.museum.mainImg">Main Img</Translate>
            </span>
          </dt>
          <dd>{museumEntity.mainImg}</dd>
        </dl>
        <Button tag={Link} to="/museum" replace color="info">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/museum/${museumEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

const mapStateToProps = ({ museum }: IRootState) => ({
  museumEntity: museum.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(MuseumDetail);
