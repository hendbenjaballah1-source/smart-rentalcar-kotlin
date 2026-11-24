import {Entity, model, property} from '@loopback/repository';

@model()
export class Agence extends Entity {
  @property({type: 'number', id: true, generated: true})
  id?: number;

  @property({type: 'string', required: true})
  email: string;

  @property({type: 'string', required: true})
  motDePasse: string;

  constructor(data?: Partial<Agence>) {
    super(data);
  }
}
