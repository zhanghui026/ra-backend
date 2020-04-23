import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
import { Translate, ICrudGetAllAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './museum.reducer';
import { IMuseum } from 'app/shared/model/museum.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IMuseumProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export const Museum = (props: IMuseumProps) => {
  useEffect(() => {
    props.getEntities();
  }, []);

  const { museumList, match, loading } = props;
  return (
    <div>
      <h2 id="museum-heading">
        <Translate contentKey="rabackApp.museum.home.title">Museums</Translate>
        <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
          <FontAwesomeIcon icon="plus" />
          &nbsp;
          <Translate contentKey="rabackApp.museum.home.createLabel">Create new Museum</Translate>
        </Link>
      </h2>
      <div className="table-responsive">
        {museumList && museumList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th>
                  <Translate contentKey="global.field.id">ID</Translate>
                </th>
                <th>
                  <Translate contentKey="rabackApp.museum.name">Name</Translate>
                </th>
                <th>
                  <Translate contentKey="rabackApp.museum.rsName">Rs Name</Translate>
                </th>
                <th>
                  <Translate contentKey="rabackApp.museum.enName">En Name</Translate>
                </th>
                <th>
                  <Translate contentKey="rabackApp.museum.fullName">Full Name</Translate>
                </th>
                <th>
                  <Translate contentKey="rabackApp.museum.rsFullName">Rs Full Name</Translate>
                </th>
                <th>
                  <Translate contentKey="rabackApp.museum.enFullName">En Full Name</Translate>
                </th>
                <th>
                  <Translate contentKey="rabackApp.museum.address">Address</Translate>
                </th>
                <th>
                  <Translate contentKey="rabackApp.museum.rsAddress">Rs Address</Translate>
                </th>
                <th>
                  <Translate contentKey="rabackApp.museum.enAddress">En Address</Translate>
                </th>
                <th>
                  <Translate contentKey="rabackApp.museum.brief">Brief</Translate>
                </th>
                <th>
                  <Translate contentKey="rabackApp.museum.enBrief">En Brief</Translate>
                </th>
                <th>
                  <Translate contentKey="rabackApp.museum.rsBrief">Rs Brief</Translate>
                </th>
                <th>
                  <Translate contentKey="rabackApp.museum.phoneNum">Phone Num</Translate>
                </th>
                <th>
                  <Translate contentKey="rabackApp.museum.contactPerson">Contact Person</Translate>
                </th>
                <th>
                  <Translate contentKey="rabackApp.museum.createDate">Create Date</Translate>
                </th>
                <th>
                  <Translate contentKey="rabackApp.museum.updateDate">Update Date</Translate>
                </th>
                <th>
                  <Translate contentKey="rabackApp.museum.mainImg">Main Img</Translate>
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {museumList.map((museum, i) => (
                <tr key={`entity-${i}`}>
                  <td>
                    <Button tag={Link} to={`${match.url}/${museum.id}`} color="link" size="sm">
                      {museum.id}
                    </Button>
                  </td>
                  <td>{museum.name}</td>
                  <td>{museum.rsName}</td>
                  <td>{museum.enName}</td>
                  <td>{museum.fullName}</td>
                  <td>{museum.rsFullName}</td>
                  <td>{museum.enFullName}</td>
                  <td>{museum.address}</td>
                  <td>{museum.rsAddress}</td>
                  <td>{museum.enAddress}</td>
                  <td>{museum.brief}</td>
                  <td>{museum.enBrief}</td>
                  <td>{museum.rsBrief}</td>
                  <td>{museum.phoneNum}</td>
                  <td>{museum.contactPerson}</td>
                  <td>
                    <TextFormat type="date" value={museum.createDate} format={APP_LOCAL_DATE_FORMAT} />
                  </td>
                  <td>
                    <TextFormat type="date" value={museum.updateDate} format={APP_LOCAL_DATE_FORMAT} />
                  </td>
                  <td>{museum.mainImg}</td>
                  <td className="text-right">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`${match.url}/${museum.id}`} color="info" size="sm">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${museum.id}/edit`} color="primary" size="sm">
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${museum.id}/delete`} color="danger" size="sm">
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
              <Translate contentKey="rabackApp.museum.home.notFound">No Museums found</Translate>
            </div>
          )
        )}
      </div>
    </div>
  );
};

const mapStateToProps = ({ museum }: IRootState) => ({
  museumList: museum.entities,
  loading: museum.loading
});

const mapDispatchToProps = {
  getEntities
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(Museum);
