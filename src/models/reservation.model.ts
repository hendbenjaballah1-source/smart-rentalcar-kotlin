import {Entity, model, property} from '@loopback/repository';

@model()
export class Reservation extends Entity {
  @property({type: 'number', id: true, generated: true})
  id?: number;

  @property({type: 'string', required: true})
  dateDebut: string;

  @property({type: 'string', required: true})
  dateFin: string;

  @property({
    type: 'string',
    default: 'EN_ATTENTE',
    jsonSchema: {enum: ['EN_ATTENTE', 'ACCEPTEE', 'REFUSEE']},
  })
  EtatRes: string;

  @property({type: 'number', required: true})
  clientId: number;

  @property({type: 'number', required: true})
  vehiculeId: number;

  constructor(data?: Partial<Reservation>) {
    super(data);
  }
}
