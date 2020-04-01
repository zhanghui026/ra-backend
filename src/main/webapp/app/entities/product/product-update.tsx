import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './product.reducer';
import { IProduct } from 'app/shared/model/product.model';
import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IProductUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const ProductUpdate = (props: IProductUpdateProps) => {
  const [isNew, setIsNew] = useState(!props.match.params || !props.match.params.id);

  const { productEntity, loading, updating } = props;

  const handleClose = () => {
    props.history.push('/product' + props.location.search);
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
        ...productEntity,
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
          <h2 id="rabackApp.product.home.createOrEditLabel">
            <Translate contentKey="rabackApp.product.home.createOrEditLabel">Create or edit a Product</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <AvForm model={isNew ? {} : productEntity} onSubmit={saveEntity}>
              {!isNew ? (
                <AvGroup>
                  <Label for="product-id">
                    <Translate contentKey="global.field.id">ID</Translate>
                  </Label>
                  <AvInput id="product-id" type="text" className="form-control" name="id" required readOnly />
                </AvGroup>
              ) : null}
              <AvGroup>
                <Label id="categoryIdLabel" for="product-categoryId">
                  <Translate contentKey="rabackApp.product.categoryId">Category Id</Translate>
                </Label>
                <AvField id="product-categoryId" type="string" className="form-control" name="categoryId" />
              </AvGroup>
              <AvGroup>
                <Label id="descriptionLabel" for="product-description">
                  <Translate contentKey="rabackApp.product.description">Description</Translate>
                </Label>
                <AvField id="product-description" type="text" name="description" />
              </AvGroup>
              <AvGroup>
                <Label id="heightLabel" for="product-height">
                  <Translate contentKey="rabackApp.product.height">Height</Translate>
                </Label>
                <AvField id="product-height" type="string" className="form-control" name="height" />
              </AvGroup>
              <AvGroup>
                <Label id="imageLabel" for="product-image">
                  <Translate contentKey="rabackApp.product.image">Image</Translate>
                </Label>
                <AvField id="product-image" type="text" name="image" />
              </AvGroup>
              <AvGroup>
                <Label id="priceLabel" for="product-price">
                  <Translate contentKey="rabackApp.product.price">Price</Translate>
                </Label>
                <AvField id="product-price" type="string" className="form-control" name="price" />
              </AvGroup>
              <AvGroup>
                <Label id="referenceLabel" for="product-reference">
                  <Translate contentKey="rabackApp.product.reference">Reference</Translate>
                </Label>
                <AvField id="product-reference" type="text" name="reference" />
              </AvGroup>
              <AvGroup>
                <Label id="stockLabel" for="product-stock">
                  <Translate contentKey="rabackApp.product.stock">Stock</Translate>
                </Label>
                <AvField id="product-stock" type="string" className="form-control" name="stock" />
              </AvGroup>
              <AvGroup>
                <Label id="thumbnailLabel" for="product-thumbnail">
                  <Translate contentKey="rabackApp.product.thumbnail">Thumbnail</Translate>
                </Label>
                <AvField id="product-thumbnail" type="text" name="thumbnail" />
              </AvGroup>
              <AvGroup>
                <Label id="widthLabel" for="product-width">
                  <Translate contentKey="rabackApp.product.width">Width</Translate>
                </Label>
                <AvField id="product-width" type="string" className="form-control" name="width" />
              </AvGroup>
              <Button tag={Link} id="cancel-save" to="/product" replace color="info">
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
  productEntity: storeState.product.entity,
  loading: storeState.product.loading,
  updating: storeState.product.updating,
  updateSuccess: storeState.product.updateSuccess
});

const mapDispatchToProps = {
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(ProductUpdate);
