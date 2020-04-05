import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './file-manager.reducer';
import { IFileManager } from 'app/shared/model/file-manager.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IFileManagerDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const FileManagerDetail = (props: IFileManagerDetailProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const { fileManagerEntity } = props;
  return (
    <Row>
      <Col md="8">
        <h2>
          <Translate contentKey="rabackApp.fileManager.detail.title">FileManager</Translate> [<b>{fileManagerEntity.id}</b>]
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="fileNo">
              <Translate contentKey="rabackApp.fileManager.fileNo">File No</Translate>
            </span>
          </dt>
          <dd>{fileManagerEntity.fileNo}</dd>
          <dt>
            <span id="bizCode">
              <Translate contentKey="rabackApp.fileManager.bizCode">Biz Code</Translate>
            </span>
          </dt>
          <dd>{fileManagerEntity.bizCode}</dd>
          <dt>
            <span id="defaultUrl">
              <Translate contentKey="rabackApp.fileManager.defaultUrl">Default Url</Translate>
            </span>
          </dt>
          <dd>{fileManagerEntity.defaultUrl}</dd>
          <dt>
            <span id="defaultPath">
              <Translate contentKey="rabackApp.fileManager.defaultPath">Default Path</Translate>
            </span>
          </dt>
          <dd>{fileManagerEntity.defaultPath}</dd>
          <dt>
            <span id="defaultFileName">
              <Translate contentKey="rabackApp.fileManager.defaultFileName">Default File Name</Translate>
            </span>
          </dt>
          <dd>{fileManagerEntity.defaultFileName}</dd>
          <dt>
            <span id="isImg">
              <Translate contentKey="rabackApp.fileManager.isImg">Is Img</Translate>
            </span>
          </dt>
          <dd>{fileManagerEntity.isImg ? 'true' : 'false'}</dd>
          <dt>
            <span id="size">
              <Translate contentKey="rabackApp.fileManager.size">Size</Translate>
            </span>
          </dt>
          <dd>{fileManagerEntity.size}</dd>
          <dt>
            <span id="isThumbnail">
              <Translate contentKey="rabackApp.fileManager.isThumbnail">Is Thumbnail</Translate>
            </span>
          </dt>
          <dd>{fileManagerEntity.isThumbnail ? 'true' : 'false'}</dd>
          <dt>
            <span id="isCommit">
              <Translate contentKey="rabackApp.fileManager.isCommit">Is Commit</Translate>
            </span>
          </dt>
          <dd>{fileManagerEntity.isCommit ? 'true' : 'false'}</dd>
          <dt>
            <span id="createTime">
              <Translate contentKey="rabackApp.fileManager.createTime">Create Time</Translate>
            </span>
          </dt>
          <dd>
            <TextFormat value={fileManagerEntity.createTime} type="date" format={APP_DATE_FORMAT} />
          </dd>
          <dt>
            <span id="updateTime">
              <Translate contentKey="rabackApp.fileManager.updateTime">Update Time</Translate>
            </span>
          </dt>
          <dd>
            <TextFormat value={fileManagerEntity.updateTime} type="date" format={APP_DATE_FORMAT} />
          </dd>
        </dl>
        <Button tag={Link} to="/file-manager" replace color="info">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/file-manager/${fileManagerEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

const mapStateToProps = ({ fileManager }: IRootState) => ({
  fileManagerEntity: fileManager.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(FileManagerDetail);
