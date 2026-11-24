import {Filter, repository} from '@loopback/repository';
import {del, get, param, post, put, requestBody} from '@loopback/rest';
import {Client} from '../models';
import {ClientRepository} from '../repositories';

export class ClientController {
  constructor(
    @repository(ClientRepository)
    public clientRepository: ClientRepository,
  ) {}

  @post('/clients')
  async create(@requestBody() client: Client): Promise<Client> {
    return this.clientRepository.create(client);
  }

  @get('/clients')
  async find(@param.filter(Client) filter?: Filter<Client>): Promise<Client[]> {
    return this.clientRepository.find(filter);
  }

  @get('/clients/{id}')
  async findById(@param.path.number('id') id: number): Promise<Client> {
    return this.clientRepository.findById(id);
  }

  @put('/clients/{id}')
  async replaceById(
    @param.path.number('id') id: number,
    @requestBody() client: Client,
  ): Promise<void> {
    await this.clientRepository.replaceById(id, client);
  }

  @del('/clients/{id}')
  async deleteById(@param.path.number('id') id: number): Promise<void> {
    await this.clientRepository.deleteById(id);
  }
}
