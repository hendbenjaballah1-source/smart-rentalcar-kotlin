import {inject} from '@loopback/core';
import {DefaultCrudRepository} from '@loopback/repository';
import {VoitureDsDataSource} from '../datasources';
import {Reservation} from '../models';

export class ReservationRepository extends DefaultCrudRepository<
  Reservation,
  typeof Reservation.prototype.id
> {
  constructor(
    @inject('datasources.voiture_ds') dataSource: VoitureDsDataSource,
  ) {
    super(Reservation, dataSource);
  }
}
