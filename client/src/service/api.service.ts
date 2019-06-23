import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Modelo,Veiculo,User,Pessoa } from '../models/modelo';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  apiURL: string = 'http://localhost:8080/api/v1/';

  constructor(private httpClient: HttpClient) {}

  /** endpoints veiculos */
  public getModelos(){
    return this.httpClient.get<Modelo[]>(`${this.apiURL}/modelos`);
  }

  public setModelos(modelo:Modelo) {
    return this.httpClient.post(`${this.apiURL}/modelos`,modelo);
  }

  public setVeiculo(veiculo:Veiculo) {
    return this.httpClient.post(`${this.apiURL}/veiculos`,veiculo)
  }

  public consultaVeiculoByPlaca(value:string) {
    return this.httpClient.get<Veiculo[]>(`${this.apiURL}/veiculos/placa/${value}`);
  }

  public consultaVeiculoByModelo(value:string) {
    return this.httpClient.get<Veiculo[]>(`${this.apiURL}/veiculos/modelo/${value}`);
  }

  public relatorioByVeiculoAtivo(start:string,end:string) {
    return this.httpClient.get<Veiculo[]>(`${this.apiURL}/veiculos/dt/${start}/${end}`);
  }


  /* endpoints funcionários */
  public setUser(user:User) {
    return this.httpClient.post(`${this.apiURL}/user`,user)
  }

  public consultaUserByCpf(value:string) {
    return this.httpClient.get<User[]>(`${this.apiURL}/user/cpf/${value}`)
  }

  public consultaUserByNome(value:string) {
    return this.httpClient.get<User[]>(`${this.apiURL}/user/nome/${value}`)
  }

  public relatorioByDtNascimento(start:string,end:string) {
    return this.httpClient.get<Pessoa[]>(`${this.apiURL}/pessoa/dt/${start}/${end}`)
  }

}
