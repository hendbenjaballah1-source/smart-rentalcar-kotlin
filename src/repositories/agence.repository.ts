import {inject} from '@loopback/core';
import {DefaultCrudRepository} from '@loopback/repository';
import {VoitureDsDataSource} from '../datasources';
import {Agence} from '../models';

export class AgenceRepository extends DefaultCrudRepository<
  Agence,
  typeof Agence.prototype.id
> {
  constructor(
    @inject('datasources.voiture_ds') dataSource: VoitureDsDataSource,
  ) {
    super(Agence, dataSource);
  }
}
