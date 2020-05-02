import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, UncontrolledTooltip, Row, Col } from 'reactstrap';
import { Translate, ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './painting.reducer';
import { IPainting } from 'app/shared/model/painting.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IPaintingDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const PaintingDetail = (props: IPaintingDetailProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const { paintingEntity } = props;
  return (
    <Row>
      <Col md="8">
        <h2>
          <Translate contentKey="rabackApp.painting.detail.title">Painting</Translate> [<b>{paintingEntity.id}</b>]
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="name">
              <Translate contentKey="rabackApp.painting.name">Name</Translate>
            </span>
            <UncontrolledTooltip target="name">
              <Translate contentKey="rabackApp.painting.help.name" />
            </UncontrolledTooltip>
          </dt>
          <dd>{paintingEntity.name}</dd>
          <dt>
            <span id="rsName">
              <Translate contentKey="rabackApp.painting.rsName">Rs Name</Translate>
            </span>
            <UncontrolledTooltip target="rsName">
              <Translate contentKey="rabackApp.painting.help.rsName" />
            </UncontrolledTooltip>
          </dt>
          <dd>{paintingEntity.rsName}</dd>
          <dt>
            <span id="enName">
              <Translate contentKey="rabackApp.painting.enName">En Name</Translate>
            </span>
            <UncontrolledTooltip target="enName">
              <Translate contentKey="rabackApp.painting.help.enName" />
            </UncontrolledTooltip>
          </dt>
          <dd>{paintingEntity.enName}</dd>
          <dt>
            <span id="artistId">
              <Translate contentKey="rabackApp.painting.artistId">Artist Id</Translate>
            </span>
            <UncontrolledTooltip target="artistId">
              <Translate contentKey="rabackApp.painting.help.artistId" />
            </UncontrolledTooltip>
          </dt>
          <dd>{paintingEntity.artistId}</dd>
          <dt>
            <span id="museumId">
              <Translate contentKey="rabackApp.painting.museumId">Museum Id</Translate>
            </span>
            <UncontrolledTooltip target="museumId">
              <Translate contentKey="rabackApp.painting.help.museumId" />
            </UncontrolledTooltip>
          </dt>
          <dd>{paintingEntity.museumId}</dd>
          <dt>
            <span id="age">
              <Translate contentKey="rabackApp.painting.age">Age</Translate>
            </span>
            <UncontrolledTooltip target="age">
              <Translate contentKey="rabackApp.painting.help.age" />
            </UncontrolledTooltip>
          </dt>
          <dd>{paintingEntity.age}</dd>
          <dt>
            <span id="tags">
              <Translate contentKey="rabackApp.painting.tags">Tags</Translate>
            </span>
            <UncontrolledTooltip target="tags">
              <Translate contentKey="rabackApp.painting.help.tags" />
            </UncontrolledTooltip>
          </dt>
          <dd>{paintingEntity.tags}</dd>
          <dt>
            <span id="width">
              <Translate contentKey="rabackApp.painting.width">Width</Translate>
            </span>
          </dt>
          <dd>{paintingEntity.width}</dd>
          <dt>
            <span id="height">
              <Translate contentKey="rabackApp.painting.height">Height</Translate>
            </span>
          </dt>
          <dd>{paintingEntity.height}</dd>
          <dt>
            <span id="rawImg">
              <Translate contentKey="rabackApp.painting.rawImg">Raw Img</Translate>
            </span>
          </dt>
          <dd>{paintingEntity.rawImg}</dd>
          <dt>
            <span id="webImg">
              <Translate contentKey="rabackApp.painting.webImg">Web Img</Translate>
            </span>
          </dt>
          <dd>{paintingEntity.webImg}</dd>
          <dt>
            <span id="thumbnailImg">
              <Translate contentKey="rabackApp.painting.thumbnailImg">Thumbnail Img</Translate>
            </span>
          </dt>
          <dd>{paintingEntity.thumbnailImg}</dd>
          <dt>
            <span id="pin">
              <Translate contentKey="rabackApp.painting.pin">Pin</Translate>
            </span>
          </dt>
          <dd>{paintingEntity.pin}</dd>
          <dt>
            <span id="pinImg">
              <Translate contentKey="rabackApp.painting.pinImg">Pin Img</Translate>
            </span>
          </dt>
          <dd>{paintingEntity.pinImg}</dd>
          <dt>
            <span id="reference">
              <Translate contentKey="rabackApp.painting.reference">Reference</Translate>
            </span>
          </dt>
          <dd>{paintingEntity.reference}</dd>
          <dt>
            <span id="sentence">
              <Translate contentKey="rabackApp.painting.sentence">Sentence</Translate>
            </span>
          </dt>
          <dd>{paintingEntity.sentence}</dd>
          <dt>
            <span id="rsSentence">
              <Translate contentKey="rabackApp.painting.rsSentence">Rs Sentence</Translate>
            </span>
          </dt>
          <dd>{paintingEntity.rsSentence}</dd>
          <dt>
            <span id="enSentence">
              <Translate contentKey="rabackApp.painting.enSentence">En Sentence</Translate>
            </span>
          </dt>
          <dd>{paintingEntity.enSentence}</dd>
          <dt>
            <span id="brief">
              <Translate contentKey="rabackApp.painting.brief">Brief</Translate>
            </span>
            <UncontrolledTooltip target="brief">
              <Translate contentKey="rabackApp.painting.help.brief" />
            </UncontrolledTooltip>
          </dt>
          <dd>{paintingEntity.brief}</dd>
          <dt>
            <span id="rsBrief">
              <Translate contentKey="rabackApp.painting.rsBrief">Rs Brief</Translate>
            </span>
            <UncontrolledTooltip target="rsBrief">
              <Translate contentKey="rabackApp.painting.help.rsBrief" />
            </UncontrolledTooltip>
          </dt>
          <dd>{paintingEntity.rsBrief}</dd>
          <dt>
            <span id="enBrief">
              <Translate contentKey="rabackApp.painting.enBrief">En Brief</Translate>
            </span>
          </dt>
          <dd>{paintingEntity.enBrief}</dd>
          <dt>
            <span id="info">
              <Translate contentKey="rabackApp.painting.info">Info</Translate>
            </span>
            <UncontrolledTooltip target="info">
              <Translate contentKey="rabackApp.painting.help.info" />
            </UncontrolledTooltip>
          </dt>
          <dd>{paintingEntity.info}</dd>
          <dt>
            <span id="rsArtInfo">
              <Translate contentKey="rabackApp.painting.rsArtInfo">Rs Art Info</Translate>
            </span>
          </dt>
          <dd>{paintingEntity.rsArtInfo}</dd>
          <dt>
            <span id="enArtInfo">
              <Translate contentKey="rabackApp.painting.enArtInfo">En Art Info</Translate>
            </span>
          </dt>
          <dd>{paintingEntity.enArtInfo}</dd>
          <dt>
            <span id="rating">
              <Translate contentKey="rabackApp.painting.rating">Rating</Translate>
            </span>
          </dt>
          <dd>{paintingEntity.rating}</dd>
          <dt>
            <span id="createDate">
              <Translate contentKey="rabackApp.painting.createDate">Create Date</Translate>
            </span>
          </dt>
          <dd>
            <TextFormat value={paintingEntity.createDate} type="date" format={APP_DATE_FORMAT} />
          </dd>
          <dt>
            <span id="updateDate">
              <Translate contentKey="rabackApp.painting.updateDate">Update Date</Translate>
            </span>
          </dt>
          <dd>
            <TextFormat value={paintingEntity.updateDate} type="date" format={APP_DATE_FORMAT} />
          </dd>
          <dt>
            <span id="useArtistInfo">
              <Translate contentKey="rabackApp.painting.useArtistInfo">Use Artist Info</Translate>
            </span>
          </dt>
          <dd>{paintingEntity.useArtistInfo ? 'true' : 'false'}</dd>
          <dt>
            <span id="category">
              <Translate contentKey="rabackApp.painting.category">Category</Translate>
            </span>
          </dt>
          <dd>{paintingEntity.category}</dd>
          <dt>
            <span id="material">
              <Translate contentKey="rabackApp.painting.material">Material</Translate>
            </span>
          </dt>
          <dd>{paintingEntity.material}</dd>
        </dl>
        <Button tag={Link} to="/painting" replace color="info">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/painting/${paintingEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

const mapStateToProps = ({ painting }: IRootState) => ({
  paintingEntity: painting.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(PaintingDetail);
