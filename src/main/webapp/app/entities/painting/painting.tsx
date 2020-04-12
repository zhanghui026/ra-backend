import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
import { Translate, ICrudGetAllAction, TextFormat, getSortState, IPaginationBaseState, JhiPagination, JhiItemCount } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './painting.reducer';
import { IPainting } from 'app/shared/model/painting.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { ITEMS_PER_PAGE } from 'app/shared/util/pagination.constants';

export interface IPaintingProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export const Painting = (props: IPaintingProps) => {
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

  const { paintingList, match, loading, totalItems } = props;
  return (
    <div>
      <h2 id="painting-heading">
        <Translate contentKey="rabackApp.painting.home.title">Paintings</Translate>
        <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
          <FontAwesomeIcon icon="plus" />
          &nbsp;
          <Translate contentKey="rabackApp.painting.home.createLabel">Create new Painting</Translate>
        </Link>
      </h2>
      <div className="table-responsive">
        {paintingList && paintingList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th className="hand" onClick={sort('id')}>
                  <Translate contentKey="global.field.id">ID</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('name')}>
                  <Translate contentKey="rabackApp.painting.name">Name</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('rsName')}>
                  <Translate contentKey="rabackApp.painting.rsName">Rs Name</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('enName')}>
                  <Translate contentKey="rabackApp.painting.enName">En Name</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('artistId')}>
                  <Translate contentKey="rabackApp.painting.artistId">Artist Id</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('materialId')}>
                  <Translate contentKey="rabackApp.painting.materialId">Material Id</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('artTypeId')}>
                  <Translate contentKey="rabackApp.painting.artTypeId">Art Type Id</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('museumId')}>
                  <Translate contentKey="rabackApp.painting.museumId">Museum Id</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('age')}>
                  <Translate contentKey="rabackApp.painting.age">Age</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('tags')}>
                  <Translate contentKey="rabackApp.painting.tags">Tags</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('width')}>
                  <Translate contentKey="rabackApp.painting.width">Width</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('height')}>
                  <Translate contentKey="rabackApp.painting.height">Height</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('rawImg')}>
                  <Translate contentKey="rabackApp.painting.rawImg">Raw Img</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('webImg')}>
                  <Translate contentKey="rabackApp.painting.webImg">Web Img</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('thumbnailImg')}>
                  <Translate contentKey="rabackApp.painting.thumbnailImg">Thumbnail Img</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('pin')}>
                  <Translate contentKey="rabackApp.painting.pin">Pin</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('pinImg')}>
                  <Translate contentKey="rabackApp.painting.pinImg">Pin Img</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('reference')}>
                  <Translate contentKey="rabackApp.painting.reference">Reference</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('categoryStatusId')}>
                  <Translate contentKey="rabackApp.painting.categoryStatusId">Category Status Id</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('sentence')}>
                  <Translate contentKey="rabackApp.painting.sentence">Sentence</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('rsSentence')}>
                  <Translate contentKey="rabackApp.painting.rsSentence">Rs Sentence</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('enSentence')}>
                  <Translate contentKey="rabackApp.painting.enSentence">En Sentence</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('brief')}>
                  <Translate contentKey="rabackApp.painting.brief">Brief</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('rsBrief')}>
                  <Translate contentKey="rabackApp.painting.rsBrief">Rs Brief</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('enBrief')}>
                  <Translate contentKey="rabackApp.painting.enBrief">En Brief</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('info')}>
                  <Translate contentKey="rabackApp.painting.info">Info</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('rsArtInfo')}>
                  <Translate contentKey="rabackApp.painting.rsArtInfo">Rs Art Info</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('enArtInfo')}>
                  <Translate contentKey="rabackApp.painting.enArtInfo">En Art Info</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('rating')}>
                  <Translate contentKey="rabackApp.painting.rating">Rating</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('createDate')}>
                  <Translate contentKey="rabackApp.painting.createDate">Create Date</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('updateDate')}>
                  <Translate contentKey="rabackApp.painting.updateDate">Update Date</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('useArtistInfo')}>
                  <Translate contentKey="rabackApp.painting.useArtistInfo">Use Artist Info</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {paintingList.map((painting, i) => (
                <tr key={`entity-${i}`}>
                  <td>
                    <Button tag={Link} to={`${match.url}/${painting.id}`} color="link" size="sm">
                      {painting.id}
                    </Button>
                  </td>
                  <td>{painting.name}</td>
                  <td>{painting.rsName}</td>
                  <td>{painting.enName}</td>
                  <td>{painting.artistId}</td>
                  <td>{painting.materialId}</td>
                  <td>{painting.artTypeId}</td>
                  <td>{painting.museumId}</td>
                  <td>{painting.age}</td>
                  <td>{painting.tags}</td>
                  <td>{painting.width}</td>
                  <td>{painting.height}</td>
                  <td>{painting.rawImg}</td>
                  <td>{painting.webImg}</td>
                  <td>{painting.thumbnailImg}</td>
                  <td>{painting.pin}</td>
                  <td>{painting.pinImg}</td>
                  <td>{painting.reference}</td>
                  <td>{painting.categoryStatusId}</td>
                  <td>{painting.sentence}</td>
                  <td>{painting.rsSentence}</td>
                  <td>{painting.enSentence}</td>
                  <td>{painting.brief}</td>
                  <td>{painting.rsBrief}</td>
                  <td>{painting.enBrief}</td>
                  <td>{painting.info}</td>
                  <td>{painting.rsArtInfo}</td>
                  <td>{painting.enArtInfo}</td>
                  <td>{painting.rating}</td>
                  <td>
                    <TextFormat type="date" value={painting.createDate} format={APP_DATE_FORMAT} />
                  </td>
                  <td>
                    <TextFormat type="date" value={painting.updateDate} format={APP_DATE_FORMAT} />
                  </td>
                  <td>{painting.useArtistInfo ? 'true' : 'false'}</td>
                  <td className="text-right">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`${match.url}/${painting.id}`} color="info" size="sm">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button
                        tag={Link}
                        to={`${match.url}/${painting.id}/edit?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`}
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
                        to={`${match.url}/${painting.id}/delete?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`}
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
              <Translate contentKey="rabackApp.painting.home.notFound">No Paintings found</Translate>
            </div>
          )
        )}
      </div>
      <div className={paintingList && paintingList.length > 0 ? '' : 'd-none'}>
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

const mapStateToProps = ({ painting }: IRootState) => ({
  paintingList: painting.entities,
  loading: painting.loading,
  totalItems: painting.totalItems
});

const mapDispatchToProps = {
  getEntities
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(Painting);
