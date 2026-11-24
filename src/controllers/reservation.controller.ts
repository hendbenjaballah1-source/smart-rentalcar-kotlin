import {Filter, repository} from '@loopback/repository';
import {del, get, param, post, put, requestBody} from '@loopback/rest';
import {Reservation} from '../models';
import {ReservationRepository} from '../repositories';

export class ReservationController {
  constructor(
    @repository(ReservationRepository)
    public reservationRepository: ReservationRepository,
  ) {}

  @post('/reservations')
  async create(@requestBody() reservation: Reservation): Promise<Reservation> {
    return this.reservationRepository.create(reservation);
  }

  @get('/reservations')
  async find(
    @param.filter(Reservation) filter?: Filter<Reservation>,
  ): Promise<Reservation[]> {
    return this.reservationRepository.find(filter);
  }

  @get('/reservations/{id}')
  async findById(@param.path.number('id') id: number): Promise<Reservation> {
    return this.reservationRepository.findById(id);
  }

  @put('/reservations/{id}')
  async replaceById(
    @param.path.number('id') id: number,
    @requestBody() reservation: Reservation,
  ): Promise<void> {
    await this.reservationRepository.replaceById(id, reservation);
  }

  @del('/reservations/{id}')
  async deleteById(@param.path.number('id') id: number): Promise<void> {
    await this.reservationRepository.deleteById(id);
  }
}
