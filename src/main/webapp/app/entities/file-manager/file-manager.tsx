import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
import { Translate, ICrudGetAllAction, TextFormat, getSortState, IPaginationBaseState, JhiPagination, JhiItemCount } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './file-manager.reducer';
import { IFileManager } from 'app/shared/model/file-manager.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { ITEMS_PER_PAGE } from 'app/shared/util/pagination.constants';

export interface IFileManagerProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export const FileManager = (props: IFileManagerProps) => {
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

  const { fileManagerList, match, loading, totalItems } = props;
  return (
    <div>
      <h2 id="file-manager-heading">
        <Translate contentKey="rabackApp.fileManager.home.title">File Managers</Translate>
        <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
          <FontAwesomeIcon icon="plus" />
          &nbsp;
          <Translate contentKey="rabackApp.fileManager.home.createLabel">Create new File Manager</Translate>
        </Link>
      </h2>
      <div className="table-responsive">
        {fileManagerList && fileManagerList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th className="hand" onClick={sort('id')}>
                  <Translate contentKey="global.field.id">ID</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('fileNo')}>
                  <Translate contentKey="rabackApp.fileManager.fileNo">File No</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('bizCode')}>
                  <Translate contentKey="rabackApp.fileManager.bizCode">Biz Code</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('defaultUrl')}>
                  <Translate contentKey="rabackApp.fileManager.defaultUrl">Default Url</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('defaultPath')}>
                  <Translate contentKey="rabackApp.fileManager.defaultPath">Default Path</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('defaultFileName')}>
                  <Translate contentKey="rabackApp.fileManager.defaultFileName">Default File Name</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('isImg')}>
                  <Translate contentKey="rabackApp.fileManager.isImg">Is Img</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('size')}>
                  <Translate contentKey="rabackApp.fileManager.size">Size</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('isThumbnail')}>
                  <Translate contentKey="rabackApp.fileManager.isThumbnail">Is Thumbnail</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('isCommit')}>
                  <Translate contentKey="rabackApp.fileManager.isCommit">Is Commit</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('createTime')}>
                  <Translate contentKey="rabackApp.fileManager.createTime">Create Time</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('updateTime')}>
                  <Translate contentKey="rabackApp.fileManager.updateTime">Update Time</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {fileManagerList.map((fileManager, i) => (
                <tr key={`entity-${i}`}>
                  <td>
                    <Button tag={Link} to={`${match.url}/${fileManager.id}`} color="link" size="sm">
                      {fileManager.id}
                    </Button>
                  </td>
                  <td>{fileManager.fileNo}</td>
                  <td>{fileManager.bizCode}</td>
                  <td>{fileManager.defaultUrl}</td>
                  <td>{fileManager.defaultPath}</td>
                  <td>{fileManager.defaultFileName}</td>
                  <td>{fileManager.isImg ? 'true' : 'false'}</td>
                  <td>{fileManager.size}</td>
                  <td>{fileManager.isThumbnail ? 'true' : 'false'}</td>
                  <td>{fileManager.isCommit ? 'true' : 'false'}</td>
                  <td>
                    <TextFormat type="date" value={fileManager.createTime} format={APP_DATE_FORMAT} />
                  </td>
                  <td>
                    <TextFormat type="date" value={fileManager.updateTime} format={APP_DATE_FORMAT} />
                  </td>
                  <td className="text-right">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`${match.url}/${fileManager.id}`} color="info" size="sm">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button
                        tag={Link}
                        to={`${match.url}/${fileManager.id}/edit?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`}
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
                        to={`${match.url}/${fileManager.id}/delete?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`}
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
              <Translate contentKey="rabackApp.fileManager.home.notFound">No File Managers found</Translate>
            </div>
          )
        )}
      </div>
      <div className={fileManagerList && fileManagerList.length > 0 ? '' : 'd-none'}>
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

const mapStateToProps = ({ fileManager }: IRootState) => ({
  fileManagerList: fileManager.entities,
  loading: fileManager.loading,
  totalItems: fileManager.totalItems
});

const mapDispatchToProps = {
  getEntities
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(FileManager);
