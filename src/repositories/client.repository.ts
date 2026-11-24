import {inject} from '@loopback/core';
import {DefaultCrudRepository} from '@loopback/repository';
import {VoitureDsDataSource} from '../datasources';
import {Client} from '../models';

export class ClientRepository extends DefaultCrudRepository<
  Client,
  typeof Client.prototype.id
> {
  constructor(
    @inject('datasources.voiture_ds') dataSource: VoitureDsDataSource,
  ) {
    super(Client, dataSource);
  }
}
