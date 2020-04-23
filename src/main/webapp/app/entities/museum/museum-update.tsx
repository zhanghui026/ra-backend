import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label, UncontrolledTooltip } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './museum.reducer';
import { IMuseum } from 'app/shared/model/museum.model';
import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IMuseumUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const MuseumUpdate = (props: IMuseumUpdateProps) => {
  const [isNew, setIsNew] = useState(!props.match.params || !props.match.params.id);

  const { museumEntity, loading, updating } = props;

  const handleClose = () => {
    props.history.push('/museum');
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
        ...museumEntity,
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
          <h2 id="rabackApp.museum.home.createOrEditLabel">
            <Translate contentKey="rabackApp.museum.home.createOrEditLabel">Create or edit a Museum</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <AvForm model={isNew ? {} : museumEntity} onSubmit={saveEntity}>
              {!isNew ? (
                <AvGroup>
                  <Label for="museum-id">
                    <Translate contentKey="global.field.id">ID</Translate>
                  </Label>
                  <AvInput id="museum-id" type="text" className="form-control" name="id" required readOnly />
                </AvGroup>
              ) : null}
              <AvGroup>
                <Label id="nameLabel" for="museum-name">
                  <Translate contentKey="rabackApp.museum.name">Name</Translate>
                </Label>
                <AvField
                  id="museum-name"
                  type="text"
                  name="name"
                  validate={{
                    required: { value: true, errorMessage: translate('entity.validation.required') }
                  }}
                />
                <UncontrolledTooltip target="nameLabel">
                  <Translate contentKey="rabackApp.museum.help.name" />
                </UncontrolledTooltip>
              </AvGroup>
              <AvGroup>
                <Label id="rsNameLabel" for="museum-rsName">
                  <Translate contentKey="rabackApp.museum.rsName">Rs Name</Translate>
                </Label>
                <AvField id="museum-rsName" type="text" name="rsName" />
              </AvGroup>
              <AvGroup>
                <Label id="enNameLabel" for="museum-enName">
                  <Translate contentKey="rabackApp.museum.enName">En Name</Translate>
                </Label>
                <AvField id="museum-enName" type="text" name="enName" />
              </AvGroup>
              <AvGroup>
                <Label id="fullNameLabel" for="museum-fullName">
                  <Translate contentKey="rabackApp.museum.fullName">Full Name</Translate>
                </Label>
                <AvField id="museum-fullName" type="text" name="fullName" />
              </AvGroup>
              <AvGroup>
                <Label id="rsFullNameLabel" for="museum-rsFullName">
                  <Translate contentKey="rabackApp.museum.rsFullName">Rs Full Name</Translate>
                </Label>
                <AvField id="museum-rsFullName" type="text" name="rsFullName" />
              </AvGroup>
              <AvGroup>
                <Label id="enFullNameLabel" for="museum-enFullName">
                  <Translate contentKey="rabackApp.museum.enFullName">En Full Name</Translate>
                </Label>
                <AvField id="museum-enFullName" type="text" name="enFullName" />
              </AvGroup>
              <AvGroup>
                <Label id="addressLabel" for="museum-address">
                  <Translate contentKey="rabackApp.museum.address">Address</Translate>
                </Label>
                <AvField id="museum-address" type="text" name="address" />
              </AvGroup>
              <AvGroup>
                <Label id="rsAddressLabel" for="museum-rsAddress">
                  <Translate contentKey="rabackApp.museum.rsAddress">Rs Address</Translate>
                </Label>
                <AvField id="museum-rsAddress" type="text" name="rsAddress" />
              </AvGroup>
              <AvGroup>
                <Label id="enAddressLabel" for="museum-enAddress">
                  <Translate contentKey="rabackApp.museum.enAddress">En Address</Translate>
                </Label>
                <AvField id="museum-enAddress" type="text" name="enAddress" />
              </AvGroup>
              <AvGroup>
                <Label id="briefLabel" for="museum-brief">
                  <Translate contentKey="rabackApp.museum.brief">Brief</Translate>
                </Label>
                <AvField id="museum-brief" type="text" name="brief" />
              </AvGroup>
              <AvGroup>
                <Label id="enBriefLabel" for="museum-enBrief">
                  <Translate contentKey="rabackApp.museum.enBrief">En Brief</Translate>
                </Label>
                <AvField id="museum-enBrief" type="text" name="enBrief" />
              </AvGroup>
              <AvGroup>
                <Label id="rsBriefLabel" for="museum-rsBrief">
                  <Translate contentKey="rabackApp.museum.rsBrief">Rs Brief</Translate>
                </Label>
                <AvField id="museum-rsBrief" type="text" name="rsBrief" />
              </AvGroup>
              <AvGroup>
                <Label id="phoneNumLabel" for="museum-phoneNum">
                  <Translate contentKey="rabackApp.museum.phoneNum">Phone Num</Translate>
                </Label>
                <AvField id="museum-phoneNum" type="text" name="phoneNum" />
              </AvGroup>
              <AvGroup>
                <Label id="contactPersonLabel" for="museum-contactPerson">
                  <Translate contentKey="rabackApp.museum.contactPerson">Contact Person</Translate>
                </Label>
                <AvField id="museum-contactPerson" type="text" name="contactPerson" />
              </AvGroup>
              <AvGroup>
                <Label id="createDateLabel" for="museum-createDate">
                  <Translate contentKey="rabackApp.museum.createDate">Create Date</Translate>
                </Label>
                <AvField id="museum-createDate" type="date" className="form-control" name="createDate" />
              </AvGroup>
              <AvGroup>
                <Label id="updateDateLabel" for="museum-updateDate">
                  <Translate contentKey="rabackApp.museum.updateDate">Update Date</Translate>
                </Label>
                <AvField id="museum-updateDate" type="date" className="form-control" name="updateDate" />
              </AvGroup>
              <AvGroup>
                <Label id="mainImgLabel" for="museum-mainImg">
                  <Translate contentKey="rabackApp.museum.mainImg">Main Img</Translate>
                </Label>
                <AvField id="museum-mainImg" type="text" name="mainImg" />
              </AvGroup>
              <Button tag={Link} id="cancel-save" to="/museum" replace color="info">
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
  museumEntity: storeState.museum.entity,
  loading: storeState.museum.loading,
  updating: storeState.museum.updating,
  updateSuccess: storeState.museum.updateSuccess
});

const mapDispatchToProps = {
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(MuseumUpdate);
