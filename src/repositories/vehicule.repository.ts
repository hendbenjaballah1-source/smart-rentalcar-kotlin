import {inject} from '@loopback/core';
import {DefaultCrudRepository} from '@loopback/repository';
import {VoitureDsDataSource} from '../datasources';
import {Vehicule} from '../models';

export class VehiculeRepository extends DefaultCrudRepository<
  Vehicule,
  typeof Vehicule.prototype.id
> {
  constructor(
    @inject('datasources.voiture_ds') dataSource: VoitureDsDataSource,
  ) {
    super(Vehicule, dataSource);
  }
}
