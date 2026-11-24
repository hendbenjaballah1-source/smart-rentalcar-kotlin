import {Entity, model, property} from '@loopback/repository';

@model()
export class Client extends Entity {
  @property({type: 'number', id: true, generated: true})
  id?: number;

  @property({type: 'string', required: true})
  email: string;

  @property({type: 'string', required: true})
  motDePasse: string;

  constructor(data?: Partial<Client>) {
    super(data);
  }
}
