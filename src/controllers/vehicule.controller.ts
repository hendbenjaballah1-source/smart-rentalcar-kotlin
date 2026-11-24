import {Filter, repository} from '@loopback/repository';
import {del, get, param, post, put, requestBody} from '@loopback/rest';
import {Vehicule} from '../models';
import {VehiculeRepository} from '../repositories';

export class VehiculeController {
  constructor(
    @repository(VehiculeRepository)
    public vehiculeRepository: VehiculeRepository,
  ) {}

  @post('/vehicules')
  async create(@requestBody() vehicule: Vehicule): Promise<Vehicule> {
    return this.vehiculeRepository.create(vehicule);
  }

  @get('/vehicules')
  async find(
    @param.filter(Vehicule) filter?: Filter<Vehicule>,
  ): Promise<Vehicule[]> {
    return this.vehiculeRepository.find(filter);
  }

  @get('/vehicules/{id}')
  async findById(@param.path.number('id') id: number): Promise<Vehicule> {
    return this.vehiculeRepository.findById(id);
  }

  @put('/vehicules/{id}')
  async replaceById(
    @param.path.number('id') id: number,
    @requestBody() vehicule: Vehicule,
  ): Promise<void> {
    await this.vehiculeRepository.replaceById(id, vehicule);
  }

  @del('/vehicules/{id}')
  async deleteById(@param.path.number('id') id: number): Promise<void> {
    await this.vehiculeRepository.deleteById(id);
  }
}
