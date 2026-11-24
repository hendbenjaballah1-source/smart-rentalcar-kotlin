import {Filter, repository} from '@loopback/repository';
import {del, get, param, post, put, requestBody} from '@loopback/rest';
import {Agence} from '../models';
import {AgenceRepository} from '../repositories';

export class AgenceController {
  constructor(
    @repository(AgenceRepository)
    public agenceRepository: AgenceRepository,
  ) {}

  @post('/agences')
  async create(@requestBody() agence: Agence): Promise<Agence> {
    return this.agenceRepository.create(agence);
  }

  @get('/agences')
  async find(@param.filter(Agence) filter?: Filter<Agence>): Promise<Agence[]> {
    return this.agenceRepository.find(filter);
  }

  @get('/agences/{id}')
  async findById(@param.path.number('id') id: number): Promise<Agence> {
    return this.agenceRepository.findById(id);
  }

  @put('/agences/{id}')
  async replaceById(
    @param.path.number('id') id: number,
    @requestBody() agence: Agence,
  ): Promise<void> {
    await this.agenceRepository.replaceById(id, agence);
  }

  @del('/agences/{id}')
  async deleteById(@param.path.number('id') id: number): Promise<void> {
    await this.agenceRepository.deleteById(id);
  }
}
