import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, ICrudGetAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './product.reducer';
import { IProduct } from 'app/shared/model/product.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IProductDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const ProductDetail = (props: IProductDetailProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const { productEntity } = props;
  return (
    <Row>
      <Col md="8">
        <h2>
          <Translate contentKey="rabackApp.product.detail.title">Product</Translate> [<b>{productEntity.id}</b>]
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="categoryId">
              <Translate contentKey="rabackApp.product.categoryId">Category Id</Translate>
            </span>
          </dt>
          <dd>{productEntity.categoryId}</dd>
          <dt>
            <span id="description">
              <Translate contentKey="rabackApp.product.description">Description</Translate>
            </span>
          </dt>
          <dd>{productEntity.description}</dd>
          <dt>
            <span id="height">
              <Translate contentKey="rabackApp.product.height">Height</Translate>
            </span>
          </dt>
          <dd>{productEntity.height}</dd>
          <dt>
            <span id="image">
              <Translate contentKey="rabackApp.product.image">Image</Translate>
            </span>
          </dt>
          <dd>{productEntity.image}</dd>
          <dt>
            <span id="price">
              <Translate contentKey="rabackApp.product.price">Price</Translate>
            </span>
          </dt>
          <dd>{productEntity.price}</dd>
          <dt>
            <span id="reference">
              <Translate contentKey="rabackApp.product.reference">Reference</Translate>
            </span>
          </dt>
          <dd>{productEntity.reference}</dd>
          <dt>
            <span id="stock">
              <Translate contentKey="rabackApp.product.stock">Stock</Translate>
            </span>
          </dt>
          <dd>{productEntity.stock}</dd>
          <dt>
            <span id="thumbnail">
              <Translate contentKey="rabackApp.product.thumbnail">Thumbnail</Translate>
            </span>
          </dt>
          <dd>{productEntity.thumbnail}</dd>
          <dt>
            <span id="width">
              <Translate contentKey="rabackApp.product.width">Width</Translate>
            </span>
          </dt>
          <dd>{productEntity.width}</dd>
        </dl>
        <Button tag={Link} to="/product" replace color="info">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/product/${productEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

const mapStateToProps = ({ product }: IRootState) => ({
  productEntity: product.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(ProductDetail);
