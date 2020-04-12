import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label, UncontrolledTooltip } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './artist.reducer';
import { IArtist } from 'app/shared/model/artist.model';
import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IArtistUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const ArtistUpdate = (props: IArtistUpdateProps) => {
  const [isNew, setIsNew] = useState(!props.match.params || !props.match.params.id);

  const { artistEntity, loading, updating } = props;

  const handleClose = () => {
    props.history.push('/artist' + props.location.search);
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
        ...artistEntity,
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
          <h2 id="rabackApp.artist.home.createOrEditLabel">
            <Translate contentKey="rabackApp.artist.home.createOrEditLabel">Create or edit a Artist</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <AvForm model={isNew ? {} : artistEntity} onSubmit={saveEntity}>
              {!isNew ? (
                <AvGroup>
                  <Label for="artist-id">
                    <Translate contentKey="global.field.id">ID</Translate>
                  </Label>
                  <AvInput id="artist-id" type="text" className="form-control" name="id" required readOnly />
                </AvGroup>
              ) : null}
              <AvGroup>
                <Label id="nameLabel" for="artist-name">
                  <Translate contentKey="rabackApp.artist.name">Name</Translate>
                </Label>
                <AvField id="artist-name" type="text" name="name" />
                <UncontrolledTooltip target="nameLabel">
                  <Translate contentKey="rabackApp.artist.help.name" />
                </UncontrolledTooltip>
              </AvGroup>
              <AvGroup>
                <Label id="rsNameLabel" for="artist-rsName">
                  <Translate contentKey="rabackApp.artist.rsName">Rs Name</Translate>
                </Label>
                <AvField id="artist-rsName" type="text" name="rsName" />
                <UncontrolledTooltip target="rsNameLabel">
                  <Translate contentKey="rabackApp.artist.help.rsName" />
                </UncontrolledTooltip>
              </AvGroup>
              <AvGroup>
                <Label id="enNameLabel" for="artist-enName">
                  <Translate contentKey="rabackApp.artist.enName">En Name</Translate>
                </Label>
                <AvField id="artist-enName" type="text" name="enName" />
                <UncontrolledTooltip target="enNameLabel">
                  <Translate contentKey="rabackApp.artist.help.enName" />
                </UncontrolledTooltip>
              </AvGroup>
              <AvGroup>
                <Label id="avatarLabel" for="artist-avatar">
                  <Translate contentKey="rabackApp.artist.avatar">Avatar</Translate>
                </Label>
                <AvField id="artist-avatar" type="text" name="avatar" />
                <UncontrolledTooltip target="avatarLabel">
                  <Translate contentKey="rabackApp.artist.help.avatar" />
                </UncontrolledTooltip>
              </AvGroup>
              <AvGroup>
                <Label id="citizenshipLabel" for="artist-citizenship">
                  <Translate contentKey="rabackApp.artist.citizenship">Citizenship</Translate>
                </Label>
                <AvField id="artist-citizenship" type="text" name="citizenship" />
                <UncontrolledTooltip target="citizenshipLabel">
                  <Translate contentKey="rabackApp.artist.help.citizenship" />
                </UncontrolledTooltip>
              </AvGroup>
              <AvGroup>
                <Label id="bornAgeLabel" for="artist-bornAge">
                  <Translate contentKey="rabackApp.artist.bornAge">Born Age</Translate>
                </Label>
                <AvField id="artist-bornAge" type="text" name="bornAge" />
                <UncontrolledTooltip target="bornAgeLabel">
                  <Translate contentKey="rabackApp.artist.help.bornAge" />
                </UncontrolledTooltip>
              </AvGroup>
              <AvGroup>
                <Label id="sentenceLabel" for="artist-sentence">
                  <Translate contentKey="rabackApp.artist.sentence">Sentence</Translate>
                </Label>
                <AvField id="artist-sentence" type="text" name="sentence" />
              </AvGroup>
              <AvGroup>
                <Label id="rsSentenceLabel" for="artist-rsSentence">
                  <Translate contentKey="rabackApp.artist.rsSentence">Rs Sentence</Translate>
                </Label>
                <AvField id="artist-rsSentence" type="text" name="rsSentence" />
              </AvGroup>
              <AvGroup>
                <Label id="enSentenceLabel" for="artist-enSentence">
                  <Translate contentKey="rabackApp.artist.enSentence">En Sentence</Translate>
                </Label>
                <AvField id="artist-enSentence" type="text" name="enSentence" />
              </AvGroup>
              <AvGroup>
                <Label id="briefLabel" for="artist-brief">
                  <Translate contentKey="rabackApp.artist.brief">Brief</Translate>
                </Label>
                <AvField id="artist-brief" type="text" name="brief" />
                <UncontrolledTooltip target="briefLabel">
                  <Translate contentKey="rabackApp.artist.help.brief" />
                </UncontrolledTooltip>
              </AvGroup>
              <AvGroup>
                <Label id="rsBriefLabel" for="artist-rsBrief">
                  <Translate contentKey="rabackApp.artist.rsBrief">Rs Brief</Translate>
                </Label>
                <AvField id="artist-rsBrief" type="text" name="rsBrief" />
                <UncontrolledTooltip target="rsBriefLabel">
                  <Translate contentKey="rabackApp.artist.help.rsBrief" />
                </UncontrolledTooltip>
              </AvGroup>
              <AvGroup>
                <Label id="enBriefLabel" for="artist-enBrief">
                  <Translate contentKey="rabackApp.artist.enBrief">En Brief</Translate>
                </Label>
                <AvField id="artist-enBrief" type="text" name="enBrief" />
              </AvGroup>
              <AvGroup>
                <Label id="artInfoLabel" for="artist-artInfo">
                  <Translate contentKey="rabackApp.artist.artInfo">Art Info</Translate>
                </Label>
                <AvField id="artist-artInfo" type="text" name="artInfo" />
                <UncontrolledTooltip target="artInfoLabel">
                  <Translate contentKey="rabackApp.artist.help.artInfo" />
                </UncontrolledTooltip>
              </AvGroup>
              <AvGroup>
                <Label id="rsArtInfoLabel" for="artist-rsArtInfo">
                  <Translate contentKey="rabackApp.artist.rsArtInfo">Rs Art Info</Translate>
                </Label>
                <AvField id="artist-rsArtInfo" type="text" name="rsArtInfo" />
              </AvGroup>
              <AvGroup>
                <Label id="enArtInfoLabel" for="artist-enArtInfo">
                  <Translate contentKey="rabackApp.artist.enArtInfo">En Art Info</Translate>
                </Label>
                <AvField id="artist-enArtInfo" type="text" name="enArtInfo" />
              </AvGroup>
              <AvGroup>
                <Label id="createDateLabel" for="artist-createDate">
                  <Translate contentKey="rabackApp.artist.createDate">Create Date</Translate>
                </Label>
                <AvInput
                  id="artist-createDate"
                  type="datetime-local"
                  className="form-control"
                  name="createDate"
                  placeholder={'YYYY-MM-DD HH:mm'}
                  value={isNew ? displayDefaultDateTime() : convertDateTimeFromServer(props.artistEntity.createDate)}
                />
                <UncontrolledTooltip target="createDateLabel">
                  <Translate contentKey="rabackApp.artist.help.createDate" />
                </UncontrolledTooltip>
              </AvGroup>
              <AvGroup>
                <Label id="updateDateLabel" for="artist-updateDate">
                  <Translate contentKey="rabackApp.artist.updateDate">Update Date</Translate>
                </Label>
                <AvInput
                  id="artist-updateDate"
                  type="datetime-local"
                  className="form-control"
                  name="updateDate"
                  placeholder={'YYYY-MM-DD HH:mm'}
                  value={isNew ? displayDefaultDateTime() : convertDateTimeFromServer(props.artistEntity.updateDate)}
                />
                <UncontrolledTooltip target="updateDateLabel">
                  <Translate contentKey="rabackApp.artist.help.updateDate" />
                </UncontrolledTooltip>
              </AvGroup>
              <Button tag={Link} id="cancel-save" to="/artist" replace color="info">
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
  artistEntity: storeState.artist.entity,
  loading: storeState.artist.loading,
  updating: storeState.artist.updating,
  updateSuccess: storeState.artist.updateSuccess
});

const mapDispatchToProps = {
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(ArtistUpdate);
