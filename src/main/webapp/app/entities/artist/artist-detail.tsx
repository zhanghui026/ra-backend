import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, UncontrolledTooltip, Row, Col } from 'reactstrap';
import { Translate, ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './artist.reducer';
import { IArtist } from 'app/shared/model/artist.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IArtistDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const ArtistDetail = (props: IArtistDetailProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const { artistEntity } = props;
  return (
    <Row>
      <Col md="8">
        <h2>
          <Translate contentKey="rabackApp.artist.detail.title">Artist</Translate> [<b>{artistEntity.id}</b>]
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="name">
              <Translate contentKey="rabackApp.artist.name">Name</Translate>
            </span>
            <UncontrolledTooltip target="name">
              <Translate contentKey="rabackApp.artist.help.name" />
            </UncontrolledTooltip>
          </dt>
          <dd>{artistEntity.name}</dd>
          <dt>
            <span id="rsName">
              <Translate contentKey="rabackApp.artist.rsName">Rs Name</Translate>
            </span>
            <UncontrolledTooltip target="rsName">
              <Translate contentKey="rabackApp.artist.help.rsName" />
            </UncontrolledTooltip>
          </dt>
          <dd>{artistEntity.rsName}</dd>
          <dt>
            <span id="enName">
              <Translate contentKey="rabackApp.artist.enName">En Name</Translate>
            </span>
            <UncontrolledTooltip target="enName">
              <Translate contentKey="rabackApp.artist.help.enName" />
            </UncontrolledTooltip>
          </dt>
          <dd>{artistEntity.enName}</dd>
          <dt>
            <span id="avatar">
              <Translate contentKey="rabackApp.artist.avatar">Avatar</Translate>
            </span>
            <UncontrolledTooltip target="avatar">
              <Translate contentKey="rabackApp.artist.help.avatar" />
            </UncontrolledTooltip>
          </dt>
          <dd>{artistEntity.avatar}</dd>
          <dt>
            <span id="citizenship">
              <Translate contentKey="rabackApp.artist.citizenship">Citizenship</Translate>
            </span>
            <UncontrolledTooltip target="citizenship">
              <Translate contentKey="rabackApp.artist.help.citizenship" />
            </UncontrolledTooltip>
          </dt>
          <dd>{artistEntity.citizenship}</dd>
          <dt>
            <span id="bornAge">
              <Translate contentKey="rabackApp.artist.bornAge">Born Age</Translate>
            </span>
            <UncontrolledTooltip target="bornAge">
              <Translate contentKey="rabackApp.artist.help.bornAge" />
            </UncontrolledTooltip>
          </dt>
          <dd>{artistEntity.bornAge}</dd>
          <dt>
            <span id="sentence">
              <Translate contentKey="rabackApp.artist.sentence">Sentence</Translate>
            </span>
          </dt>
          <dd>{artistEntity.sentence}</dd>
          <dt>
            <span id="rsSentence">
              <Translate contentKey="rabackApp.artist.rsSentence">Rs Sentence</Translate>
            </span>
          </dt>
          <dd>{artistEntity.rsSentence}</dd>
          <dt>
            <span id="enSentence">
              <Translate contentKey="rabackApp.artist.enSentence">En Sentence</Translate>
            </span>
          </dt>
          <dd>{artistEntity.enSentence}</dd>
          <dt>
            <span id="brief">
              <Translate contentKey="rabackApp.artist.brief">Brief</Translate>
            </span>
            <UncontrolledTooltip target="brief">
              <Translate contentKey="rabackApp.artist.help.brief" />
            </UncontrolledTooltip>
          </dt>
          <dd>{artistEntity.brief}</dd>
          <dt>
            <span id="rsBrief">
              <Translate contentKey="rabackApp.artist.rsBrief">Rs Brief</Translate>
            </span>
            <UncontrolledTooltip target="rsBrief">
              <Translate contentKey="rabackApp.artist.help.rsBrief" />
            </UncontrolledTooltip>
          </dt>
          <dd>{artistEntity.rsBrief}</dd>
          <dt>
            <span id="enBrief">
              <Translate contentKey="rabackApp.artist.enBrief">En Brief</Translate>
            </span>
          </dt>
          <dd>{artistEntity.enBrief}</dd>
          <dt>
            <span id="artInfo">
              <Translate contentKey="rabackApp.artist.artInfo">Art Info</Translate>
            </span>
            <UncontrolledTooltip target="artInfo">
              <Translate contentKey="rabackApp.artist.help.artInfo" />
            </UncontrolledTooltip>
          </dt>
          <dd>{artistEntity.artInfo}</dd>
          <dt>
            <span id="rsArtInfo">
              <Translate contentKey="rabackApp.artist.rsArtInfo">Rs Art Info</Translate>
            </span>
          </dt>
          <dd>{artistEntity.rsArtInfo}</dd>
          <dt>
            <span id="enArtInfo">
              <Translate contentKey="rabackApp.artist.enArtInfo">En Art Info</Translate>
            </span>
          </dt>
          <dd>{artistEntity.enArtInfo}</dd>
          <dt>
            <span id="createDate">
              <Translate contentKey="rabackApp.artist.createDate">Create Date</Translate>
            </span>
            <UncontrolledTooltip target="createDate">
              <Translate contentKey="rabackApp.artist.help.createDate" />
            </UncontrolledTooltip>
          </dt>
          <dd>
            <TextFormat value={artistEntity.createDate} type="date" format={APP_DATE_FORMAT} />
          </dd>
          <dt>
            <span id="updateDate">
              <Translate contentKey="rabackApp.artist.updateDate">Update Date</Translate>
            </span>
            <UncontrolledTooltip target="updateDate">
              <Translate contentKey="rabackApp.artist.help.updateDate" />
            </UncontrolledTooltip>
          </dt>
          <dd>
            <TextFormat value={artistEntity.updateDate} type="date" format={APP_DATE_FORMAT} />
          </dd>
        </dl>
        <Button tag={Link} to="/artist" replace color="info">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/artist/${artistEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

const mapStateToProps = ({ artist }: IRootState) => ({
  artistEntity: artist.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(ArtistDetail);
