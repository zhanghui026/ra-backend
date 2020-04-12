import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
import { Translate, ICrudGetAllAction, TextFormat, getSortState, IPaginationBaseState, JhiPagination, JhiItemCount } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './artist.reducer';
import { IArtist } from 'app/shared/model/artist.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { ITEMS_PER_PAGE } from 'app/shared/util/pagination.constants';

export interface IArtistProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export const Artist = (props: IArtistProps) => {
  const [paginationState, setPaginationState] = useState(getSortState(props.location, ITEMS_PER_PAGE));

  const getAllEntities = () => {
    props.getEntities(paginationState.activePage - 1, paginationState.itemsPerPage, `${paginationState.sort},${paginationState.order}`);
  };

  const sortEntities = () => {
    getAllEntities();
    props.history.push(
      `${props.location.pathname}?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`
    );
  };

  useEffect(() => {
    sortEntities();
  }, [paginationState.activePage, paginationState.order, paginationState.sort]);

  const sort = p => () => {
    setPaginationState({
      ...paginationState,
      order: paginationState.order === 'asc' ? 'desc' : 'asc',
      sort: p
    });
  };

  const handlePagination = currentPage =>
    setPaginationState({
      ...paginationState,
      activePage: currentPage
    });

  const { artistList, match, loading, totalItems } = props;
  return (
    <div>
      <h2 id="artist-heading">
        <Translate contentKey="rabackApp.artist.home.title">Artists</Translate>
        <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
          <FontAwesomeIcon icon="plus" />
          &nbsp;
          <Translate contentKey="rabackApp.artist.home.createLabel">Create new Artist</Translate>
        </Link>
      </h2>
      <div className="table-responsive">
        {artistList && artistList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th className="hand" onClick={sort('id')}>
                  <Translate contentKey="global.field.id">ID</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('name')}>
                  <Translate contentKey="rabackApp.artist.name">Name</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('rsName')}>
                  <Translate contentKey="rabackApp.artist.rsName">Rs Name</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('enName')}>
                  <Translate contentKey="rabackApp.artist.enName">En Name</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('avatar')}>
                  <Translate contentKey="rabackApp.artist.avatar">Avatar</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('citizenship')}>
                  <Translate contentKey="rabackApp.artist.citizenship">Citizenship</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('bornAge')}>
                  <Translate contentKey="rabackApp.artist.bornAge">Born Age</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('sentence')}>
                  <Translate contentKey="rabackApp.artist.sentence">Sentence</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('rsSentence')}>
                  <Translate contentKey="rabackApp.artist.rsSentence">Rs Sentence</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('enSentence')}>
                  <Translate contentKey="rabackApp.artist.enSentence">En Sentence</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('brief')}>
                  <Translate contentKey="rabackApp.artist.brief">Brief</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('rsBrief')}>
                  <Translate contentKey="rabackApp.artist.rsBrief">Rs Brief</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('enBrief')}>
                  <Translate contentKey="rabackApp.artist.enBrief">En Brief</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('artInfo')}>
                  <Translate contentKey="rabackApp.artist.artInfo">Art Info</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('rsArtInfo')}>
                  <Translate contentKey="rabackApp.artist.rsArtInfo">Rs Art Info</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('enArtInfo')}>
                  <Translate contentKey="rabackApp.artist.enArtInfo">En Art Info</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('createDate')}>
                  <Translate contentKey="rabackApp.artist.createDate">Create Date</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('updateDate')}>
                  <Translate contentKey="rabackApp.artist.updateDate">Update Date</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {artistList.map((artist, i) => (
                <tr key={`entity-${i}`}>
                  <td>
                    <Button tag={Link} to={`${match.url}/${artist.id}`} color="link" size="sm">
                      {artist.id}
                    </Button>
                  </td>
                  <td>{artist.name}</td>
                  <td>{artist.rsName}</td>
                  <td>{artist.enName}</td>
                  <td>{artist.avatar}</td>
                  <td>{artist.citizenship}</td>
                  <td>{artist.bornAge}</td>
                  <td>{artist.sentence}</td>
                  <td>{artist.rsSentence}</td>
                  <td>{artist.enSentence}</td>
                  <td>{artist.brief}</td>
                  <td>{artist.rsBrief}</td>
                  <td>{artist.enBrief}</td>
                  <td>{artist.artInfo}</td>
                  <td>{artist.rsArtInfo}</td>
                  <td>{artist.enArtInfo}</td>
                  <td>
                    <TextFormat type="date" value={artist.createDate} format={APP_DATE_FORMAT} />
                  </td>
                  <td>
                    <TextFormat type="date" value={artist.updateDate} format={APP_DATE_FORMAT} />
                  </td>
                  <td className="text-right">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`${match.url}/${artist.id}`} color="info" size="sm">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button
                        tag={Link}
                        to={`${match.url}/${artist.id}/edit?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`}
                        color="primary"
                        size="sm"
                      >
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button
                        tag={Link}
                        to={`${match.url}/${artist.id}/delete?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`}
                        color="danger"
                        size="sm"
                      >
                        <FontAwesomeIcon icon="trash" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.delete">Delete</Translate>
                        </span>
                      </Button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        ) : (
          !loading && (
            <div className="alert alert-warning">
              <Translate contentKey="rabackApp.artist.home.notFound">No Artists found</Translate>
            </div>
          )
        )}
      </div>
      <div className={artistList && artistList.length > 0 ? '' : 'd-none'}>
        <Row className="justify-content-center">
          <JhiItemCount page={paginationState.activePage} total={totalItems} itemsPerPage={paginationState.itemsPerPage} i18nEnabled />
        </Row>
        <Row className="justify-content-center">
          <JhiPagination
            activePage={paginationState.activePage}
            onSelect={handlePagination}
            maxButtons={5}
            itemsPerPage={paginationState.itemsPerPage}
            totalItems={props.totalItems}
          />
        </Row>
      </div>
    </div>
  );
};

const mapStateToProps = ({ artist }: IRootState) => ({
  artistList: artist.entities,
  loading: artist.loading,
  totalItems: artist.totalItems
});

const mapDispatchToProps = {
  getEntities
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(Artist);
