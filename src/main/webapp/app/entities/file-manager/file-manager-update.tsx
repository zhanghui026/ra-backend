import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './file-manager.reducer';
import { IFileManager } from 'app/shared/model/file-manager.model';
import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IFileManagerUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const FileManagerUpdate = (props: IFileManagerUpdateProps) => {
  const [isNew, setIsNew] = useState(!props.match.params || !props.match.params.id);

  const { fileManagerEntity, loading, updating } = props;

  const handleClose = () => {
    props.history.push('/file-manager' + props.location.search);
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
    values.createTime = convertDateTimeToServer(values.createTime);
    values.updateTime = convertDateTimeToServer(values.updateTime);

    if (errors.length === 0) {
      const entity = {
        ...fileManagerEntity,
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
          <h2 id="rabackApp.fileManager.home.createOrEditLabel">
            <Translate contentKey="rabackApp.fileManager.home.createOrEditLabel">Create or edit a FileManager</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <AvForm model={isNew ? {} : fileManagerEntity} onSubmit={saveEntity}>
              {!isNew ? (
                <AvGroup>
                  <Label for="file-manager-id">
                    <Translate contentKey="global.field.id">ID</Translate>
                  </Label>
                  <AvInput id="file-manager-id" type="text" className="form-control" name="id" required readOnly />
                </AvGroup>
              ) : null}
              <AvGroup>
                <Label id="fileNoLabel" for="file-manager-fileNo">
                  <Translate contentKey="rabackApp.fileManager.fileNo">File No</Translate>
                </Label>
                <AvField
                  id="file-manager-fileNo"
                  type="text"
                  name="fileNo"
                  validate={{
                    required: { value: true, errorMessage: translate('entity.validation.required') }
                  }}
                />
              </AvGroup>
              <AvGroup>
                <Label id="bizCodeLabel" for="file-manager-bizCode">
                  <Translate contentKey="rabackApp.fileManager.bizCode">Biz Code</Translate>
                </Label>
                <AvField id="file-manager-bizCode" type="text" name="bizCode" />
              </AvGroup>
              <AvGroup>
                <Label id="defaultUrlLabel" for="file-manager-defaultUrl">
                  <Translate contentKey="rabackApp.fileManager.defaultUrl">Default Url</Translate>
                </Label>
                <AvField id="file-manager-defaultUrl" type="text" name="defaultUrl" />
              </AvGroup>
              <AvGroup>
                <Label id="defaultPathLabel" for="file-manager-defaultPath">
                  <Translate contentKey="rabackApp.fileManager.defaultPath">Default Path</Translate>
                </Label>
                <AvField id="file-manager-defaultPath" type="text" name="defaultPath" />
              </AvGroup>
              <AvGroup>
                <Label id="defaultFileNameLabel" for="file-manager-defaultFileName">
                  <Translate contentKey="rabackApp.fileManager.defaultFileName">Default File Name</Translate>
                </Label>
                <AvField id="file-manager-defaultFileName" type="text" name="defaultFileName" />
              </AvGroup>
              <AvGroup check>
                <Label id="isImgLabel">
                  <AvInput id="file-manager-isImg" type="checkbox" className="form-check-input" name="isImg" />
                  <Translate contentKey="rabackApp.fileManager.isImg">Is Img</Translate>
                </Label>
              </AvGroup>
              <AvGroup>
                <Label id="sizeLabel" for="file-manager-size">
                  <Translate contentKey="rabackApp.fileManager.size">Size</Translate>
                </Label>
                <AvField id="file-manager-size" type="string" className="form-control" name="size" />
              </AvGroup>
              <AvGroup check>
                <Label id="isThumbnailLabel">
                  <AvInput id="file-manager-isThumbnail" type="checkbox" className="form-check-input" name="isThumbnail" />
                  <Translate contentKey="rabackApp.fileManager.isThumbnail">Is Thumbnail</Translate>
                </Label>
              </AvGroup>
              <AvGroup check>
                <Label id="isCommitLabel">
                  <AvInput id="file-manager-isCommit" type="checkbox" className="form-check-input" name="isCommit" />
                  <Translate contentKey="rabackApp.fileManager.isCommit">Is Commit</Translate>
                </Label>
              </AvGroup>
              <AvGroup>
                <Label id="createTimeLabel" for="file-manager-createTime">
                  <Translate contentKey="rabackApp.fileManager.createTime">Create Time</Translate>
                </Label>
                <AvInput
                  id="file-manager-createTime"
                  type="datetime-local"
                  className="form-control"
                  name="createTime"
                  placeholder={'YYYY-MM-DD HH:mm'}
                  value={isNew ? displayDefaultDateTime() : convertDateTimeFromServer(props.fileManagerEntity.createTime)}
                />
              </AvGroup>
              <AvGroup>
                <Label id="updateTimeLabel" for="file-manager-updateTime">
                  <Translate contentKey="rabackApp.fileManager.updateTime">Update Time</Translate>
                </Label>
                <AvInput
                  id="file-manager-updateTime"
                  type="datetime-local"
                  className="form-control"
                  name="updateTime"
                  placeholder={'YYYY-MM-DD HH:mm'}
                  value={isNew ? displayDefaultDateTime() : convertDateTimeFromServer(props.fileManagerEntity.updateTime)}
                />
              </AvGroup>
              <Button tag={Link} id="cancel-save" to="/file-manager" replace color="info">
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
  fileManagerEntity: storeState.fileManager.entity,
  loading: storeState.fileManager.loading,
  updating: storeState.fileManager.updating,
  updateSuccess: storeState.fileManager.updateSuccess
});

const mapDispatchToProps = {
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(FileManagerUpdate);
