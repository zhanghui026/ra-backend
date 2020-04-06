import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './review.reducer';
import { IReview } from 'app/shared/model/review.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IReviewDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const ReviewDetail = (props: IReviewDetailProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const { reviewEntity } = props;
  return (
    <Row>
      <Col md="8">
        <h2>
          <Translate contentKey="rabackApp.review.detail.title">Review</Translate> [<b>{reviewEntity.id}</b>]
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="date">
              <Translate contentKey="rabackApp.review.date">Date</Translate>
            </span>
          </dt>
          <dd>
            <TextFormat value={reviewEntity.date} type="date" format={APP_DATE_FORMAT} />
          </dd>
          <dt>
            <span id="status">
              <Translate contentKey="rabackApp.review.status">Status</Translate>
            </span>
          </dt>
          <dd>{reviewEntity.status}</dd>
          <dt>
            <span id="customerId">
              <Translate contentKey="rabackApp.review.customerId">Customer Id</Translate>
            </span>
          </dt>
          <dd>{reviewEntity.customerId}</dd>
          <dt>
            <span id="commandId">
              <Translate contentKey="rabackApp.review.commandId">Command Id</Translate>
            </span>
          </dt>
          <dd>{reviewEntity.commandId}</dd>
          <dt>
            <span id="productId">
              <Translate contentKey="rabackApp.review.productId">Product Id</Translate>
            </span>
          </dt>
          <dd>{reviewEntity.productId}</dd>
          <dt>
            <span id="rating">
              <Translate contentKey="rabackApp.review.rating">Rating</Translate>
            </span>
          </dt>
          <dd>{reviewEntity.rating}</dd>
          <dt>
            <span id="comment">
              <Translate contentKey="rabackApp.review.comment">Comment</Translate>
            </span>
          </dt>
          <dd>{reviewEntity.comment}</dd>
        </dl>
        <Button tag={Link} to="/review" replace color="info">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/review/${reviewEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

const mapStateToProps = ({ review }: IRootState) => ({
  reviewEntity: review.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(ReviewDetail);
