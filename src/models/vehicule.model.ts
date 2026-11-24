import {Entity, model, property} from '@loopback/repository';

@model()
export class Vehicule extends Entity {
  @property({type: 'number', id: true, generated: true})
  id?: number;

  @property({type: 'boolean', default: true})
  disponible: boolean;

  @property({type: 'number', required: true})
  agenceId: number;

  constructor(data?: Partial<Vehicule>) {
    super(data);
  }
}
