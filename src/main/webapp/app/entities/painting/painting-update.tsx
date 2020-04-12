import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label, UncontrolledTooltip } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './painting.reducer';
import { IPainting } from 'app/shared/model/painting.model';
import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IPaintingUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const PaintingUpdate = (props: IPaintingUpdateProps) => {
  const [isNew, setIsNew] = useState(!props.match.params || !props.match.params.id);

  const { paintingEntity, loading, updating } = props;

  const handleClose = () => {
    props.history.push('/painting' + props.location.search);
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
    values.createDate = convertDateTimeToServer(values.createDate);
    values.updateDate = convertDateTimeToServer(values.updateDate);

    if (errors.length === 0) {
      const entity = {
        ...paintingEntity,
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
          <h2 id="rabackApp.painting.home.createOrEditLabel">
            <Translate contentKey="rabackApp.painting.home.createOrEditLabel">Create or edit a Painting</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <AvForm model={isNew ? {} : paintingEntity} onSubmit={saveEntity}>
              {!isNew ? (
                <AvGroup>
                  <Label for="painting-id">
                    <Translate contentKey="global.field.id">ID</Translate>
                  </Label>
                  <AvInput id="painting-id" type="text" className="form-control" name="id" required readOnly />
                </AvGroup>
              ) : null}
              <AvGroup>
                <Label id="nameLabel" for="painting-name">
                  <Translate contentKey="rabackApp.painting.name">Name</Translate>
                </Label>
                <AvField id="painting-name" type="text" name="name" />
                <UncontrolledTooltip target="nameLabel">
                  <Translate contentKey="rabackApp.painting.help.name" />
                </UncontrolledTooltip>
              </AvGroup>
              <AvGroup>
                <Label id="rsNameLabel" for="painting-rsName">
                  <Translate contentKey="rabackApp.painting.rsName">Rs Name</Translate>
                </Label>
                <AvField id="painting-rsName" type="text" name="rsName" />
                <UncontrolledTooltip target="rsNameLabel">
                  <Translate contentKey="rabackApp.painting.help.rsName" />
                </UncontrolledTooltip>
              </AvGroup>
              <AvGroup>
                <Label id="enNameLabel" for="painting-enName">
                  <Translate contentKey="rabackApp.painting.enName">En Name</Translate>
                </Label>
                <AvField id="painting-enName" type="text" name="enName" />
                <UncontrolledTooltip target="enNameLabel">
                  <Translate contentKey="rabackApp.painting.help.enName" />
                </UncontrolledTooltip>
              </AvGroup>
              <AvGroup>
                <Label id="artistIdLabel" for="painting-artistId">
                  <Translate contentKey="rabackApp.painting.artistId">Artist Id</Translate>
                </Label>
                <AvField id="painting-artistId" type="string" className="form-control" name="artistId" />
                <UncontrolledTooltip target="artistIdLabel">
                  <Translate contentKey="rabackApp.painting.help.artistId" />
                </UncontrolledTooltip>
              </AvGroup>
              <AvGroup>
                <Label id="materialIdLabel" for="painting-materialId">
                  <Translate contentKey="rabackApp.painting.materialId">Material Id</Translate>
                </Label>
                <AvField id="painting-materialId" type="string" className="form-control" name="materialId" />
                <UncontrolledTooltip target="materialIdLabel">
                  <Translate contentKey="rabackApp.painting.help.materialId" />
                </UncontrolledTooltip>
              </AvGroup>
              <AvGroup>
                <Label id="artTypeIdLabel" for="painting-artTypeId">
                  <Translate contentKey="rabackApp.painting.artTypeId">Art Type Id</Translate>
                </Label>
                <AvField id="painting-artTypeId" type="string" className="form-control" name="artTypeId" />
                <UncontrolledTooltip target="artTypeIdLabel">
                  <Translate contentKey="rabackApp.painting.help.artTypeId" />
                </UncontrolledTooltip>
              </AvGroup>
              <AvGroup>
                <Label id="museumIdLabel" for="painting-museumId">
                  <Translate contentKey="rabackApp.painting.museumId">Museum Id</Translate>
                </Label>
                <AvField id="painting-museumId" type="string" className="form-control" name="museumId" />
                <UncontrolledTooltip target="museumIdLabel">
                  <Translate contentKey="rabackApp.painting.help.museumId" />
                </UncontrolledTooltip>
              </AvGroup>
              <AvGroup>
                <Label id="ageLabel" for="painting-age">
                  <Translate contentKey="rabackApp.painting.age">Age</Translate>
                </Label>
                <AvField id="painting-age" type="text" name="age" />
                <UncontrolledTooltip target="ageLabel">
                  <Translate contentKey="rabackApp.painting.help.age" />
                </UncontrolledTooltip>
              </AvGroup>
              <AvGroup>
                <Label id="tagsLabel" for="painting-tags">
                  <Translate contentKey="rabackApp.painting.tags">Tags</Translate>
                </Label>
                <AvField id="painting-tags" type="text" name="tags" />
                <UncontrolledTooltip target="tagsLabel">
                  <Translate contentKey="rabackApp.painting.help.tags" />
                </UncontrolledTooltip>
              </AvGroup>
              <AvGroup>
                <Label id="widthLabel" for="painting-width">
                  <Translate contentKey="rabackApp.painting.width">Width</Translate>
                </Label>
                <AvField id="painting-width" type="string" className="form-control" name="width" />
              </AvGroup>
              <AvGroup>
                <Label id="heightLabel" for="painting-height">
                  <Translate contentKey="rabackApp.painting.height">Height</Translate>
                </Label>
                <AvField id="painting-height" type="string" className="form-control" name="height" />
              </AvGroup>
              <AvGroup>
                <Label id="rawImgLabel" for="painting-rawImg">
                  <Translate contentKey="rabackApp.painting.rawImg">Raw Img</Translate>
                </Label>
                <AvField id="painting-rawImg" type="text" name="rawImg" />
              </AvGroup>
              <AvGroup>
                <Label id="webImgLabel" for="painting-webImg">
                  <Translate contentKey="rabackApp.painting.webImg">Web Img</Translate>
                </Label>
                <AvField id="painting-webImg" type="text" name="webImg" />
              </AvGroup>
              <AvGroup>
                <Label id="thumbnailImgLabel" for="painting-thumbnailImg">
                  <Translate contentKey="rabackApp.painting.thumbnailImg">Thumbnail Img</Translate>
                </Label>
                <AvField id="painting-thumbnailImg" type="text" name="thumbnailImg" />
              </AvGroup>
              <AvGroup>
                <Label id="pinLabel" for="painting-pin">
                  <Translate contentKey="rabackApp.painting.pin">Pin</Translate>
                </Label>
                <AvField id="painting-pin" type="text" name="pin" />
              </AvGroup>
              <AvGroup>
                <Label id="pinImgLabel" for="painting-pinImg">
                  <Translate contentKey="rabackApp.painting.pinImg">Pin Img</Translate>
                </Label>
                <AvField id="painting-pinImg" type="text" name="pinImg" />
              </AvGroup>
              <AvGroup>
                <Label id="referenceLabel" for="painting-reference">
                  <Translate contentKey="rabackApp.painting.reference">Reference</Translate>
                </Label>
                <AvField id="painting-reference" type="text" name="reference" />
              </AvGroup>
              <AvGroup>
                <Label id="categoryStatusIdLabel" for="painting-categoryStatusId">
                  <Translate contentKey="rabackApp.painting.categoryStatusId">Category Status Id</Translate>
                </Label>
                <AvField id="painting-categoryStatusId" type="string" className="form-control" name="categoryStatusId" />
              </AvGroup>
              <AvGroup>
                <Label id="sentenceLabel" for="painting-sentence">
                  <Translate contentKey="rabackApp.painting.sentence">Sentence</Translate>
                </Label>
                <AvField id="painting-sentence" type="text" name="sentence" />
              </AvGroup>
              <AvGroup>
                <Label id="rsSentenceLabel" for="painting-rsSentence">
                  <Translate contentKey="rabackApp.painting.rsSentence">Rs Sentence</Translate>
                </Label>
                <AvField id="painting-rsSentence" type="text" name="rsSentence" />
              </AvGroup>
              <AvGroup>
                <Label id="enSentenceLabel" for="painting-enSentence">
                  <Translate contentKey="rabackApp.painting.enSentence">En Sentence</Translate>
                </Label>
                <AvField id="painting-enSentence" type="text" name="enSentence" />
              </AvGroup>
              <AvGroup>
                <Label id="briefLabel" for="painting-brief">
                  <Translate contentKey="rabackApp.painting.brief">Brief</Translate>
                </Label>
                <AvField id="painting-brief" type="text" name="brief" />
                <UncontrolledTooltip target="briefLabel">
                  <Translate contentKey="rabackApp.painting.help.brief" />
                </UncontrolledTooltip>
              </AvGroup>
              <AvGroup>
                <Label id="rsBriefLabel" for="painting-rsBrief">
                  <Translate contentKey="rabackApp.painting.rsBrief">Rs Brief</Translate>
                </Label>
                <AvField id="painting-rsBrief" type="text" name="rsBrief" />
                <UncontrolledTooltip target="rsBriefLabel">
                  <Translate contentKey="rabackApp.painting.help.rsBrief" />
                </UncontrolledTooltip>
              </AvGroup>
              <AvGroup>
                <Label id="enBriefLabel" for="painting-enBrief">
                  <Translate contentKey="rabackApp.painting.enBrief">En Brief</Translate>
                </Label>
                <AvField id="painting-enBrief" type="text" name="enBrief" />
              </AvGroup>
              <AvGroup>
                <Label id="infoLabel" for="painting-info">
                  <Translate contentKey="rabackApp.painting.info">Info</Translate>
                </Label>
                <AvField id="painting-info" type="text" name="info" />
                <UncontrolledTooltip target="infoLabel">
                  <Translate contentKey="rabackApp.painting.help.info" />
                </UncontrolledTooltip>
              </AvGroup>
              <AvGroup>
                <Label id="rsArtInfoLabel" for="painting-rsArtInfo">
                  <Translate contentKey="rabackApp.painting.rsArtInfo">Rs Art Info</Translate>
                </Label>
                <AvField id="painting-rsArtInfo" type="text" name="rsArtInfo" />
              </AvGroup>
              <AvGroup>
                <Label id="enArtInfoLabel" for="painting-enArtInfo">
                  <Translate contentKey="rabackApp.painting.enArtInfo">En Art Info</Translate>
                </Label>
                <AvField id="painting-enArtInfo" type="text" name="enArtInfo" />
              </AvGroup>
              <AvGroup>
                <Label id="ratingLabel" for="painting-rating">
                  <Translate contentKey="rabackApp.painting.rating">Rating</Translate>
                </Label>
                <AvField id="painting-rating" type="string" className="form-control" name="rating" />
              </AvGroup>
              <AvGroup>
                <Label id="createDateLabel" for="painting-createDate">
                  <Translate contentKey="rabackApp.painting.createDate">Create Date</Translate>
                </Label>
                <AvInput
                  id="painting-createDate"
                  type="datetime-local"
                  className="form-control"
                  name="createDate"
                  placeholder={'YYYY-MM-DD HH:mm'}
                  value={isNew ? displayDefaultDateTime() : convertDateTimeFromServer(props.paintingEntity.createDate)}
                />
              </AvGroup>
              <AvGroup>
                <Label id="updateDateLabel" for="painting-updateDate">
                  <Translate contentKey="rabackApp.painting.updateDate">Update Date</Translate>
                </Label>
                <AvInput
                  id="painting-updateDate"
                  type="datetime-local"
                  className="form-control"
                  name="updateDate"
                  placeholder={'YYYY-MM-DD HH:mm'}
                  value={isNew ? displayDefaultDateTime() : convertDateTimeFromServer(props.paintingEntity.updateDate)}
                />
              </AvGroup>
              <AvGroup check>
                <Label id="useArtistInfoLabel">
                  <AvInput id="painting-useArtistInfo" type="checkbox" className="form-check-input" name="useArtistInfo" />
                  <Translate contentKey="rabackApp.painting.useArtistInfo">Use Artist Info</Translate>
                </Label>
              </AvGroup>
              <Button tag={Link} id="cancel-save" to="/painting" replace color="info">
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
  paintingEntity: storeState.painting.entity,
  loading: storeState.painting.loading,
  updating: storeState.painting.updating,
  updateSuccess: storeState.painting.updateSuccess
});

const mapDispatchToProps = {
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(PaintingUpdate);
