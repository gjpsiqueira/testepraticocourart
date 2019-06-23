import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiService } from '../service/api.service';
import { FormControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Modelo, Veiculo } from '../models/modelo';
import Utils from '../app/utils';


@Component({
  selector: 'app-veiculo',
  templateUrl: './veiculo.component.html',
  styleUrls: ['./veiculo.component.scss']
})
export class VeiculoComponent {

  
  cadastroModeloForm: FormGroup;
  cadastroVeiculoForm: FormGroup;


  modelos = [];
  loading:boolean;
  startDate:string;
  endDate:string;

  placa = new FormControl('');
  ativo = new FormControl('');
  chassi = new FormControl('');
  anoFabricacao = new FormControl('');
  cor = new FormControl('');
  modeloId = new FormControl('');

  consultaVeiculo = new FormControl('');

  showCadastro = false;
  showConsulta = false;
  showRelatorios = false;

  errorConsulta = false;
  errorRelatorio = false;

  fetchVeiculo: Veiculo[];

  showMsgSuccessVeiculo = false;
  showMsgSuccessModelo = false;


  searchMode = '';

  options = {
    fieldSeparator: ',',
    quoteStrings: '"',
    decimalseparator: '.',
    headers: ['Placa ', 'Ano Fabricação ', 'Chassi ', 'Cor ', 'Ativo ', 'Data Cadastro'],
    showTitle: false,
    useBom: true,
    removeNewLines: false,
    keys: ['placa','anoFabricacao','chassi','cor','ativo','dataCadastro']
  };

  constructor(private apiService: ApiService,private formBuilder: FormBuilder) {
    this.fetchVeiculo = [], 
    this.showCadastro = true;
  }



  ngOnInit() {
    this.showMsgSuccessVeiculo = false;
    this.apiService.getModelos().subscribe((res) =>{
      this.modelos = res;
    });

    this.cadastroModeloForm = this.formBuilder.group({
      descricao: ['',Validators.required],
      ano: ['',Validators.required],
      consumoMedioKm: ['',Validators.required],
      qtdPassageiro:['',Validators.required],
    })

    this.cadastroVeiculoForm = this.formBuilder.group({
      placa: ['',Validators.required],
      ativo: ['',Validators.required],
      chassi: ['',Validators.required],
      anoFabricacao: ['',Validators.required],
      cor: ['',Validators.required],
      modeloId: ['',Validators.required]




    })



  }


  closeModal() :void {
    this.ngOnInit();
    this.showMsgSuccessModelo = false;
  }

  switchScreen(screen) :void {
    if(screen == 'cadastro') {
      this.showCadastro = true;
      this.showConsulta = false;
      this.showRelatorios = false;
      this.showMsgSuccessVeiculo = false;
      this.showMsgSuccessModelo = false;
      
    }

    if(screen == 'consultas') {

      this.showConsulta = true;
      this.showCadastro = false;
      this.showRelatorios = false;
      this.showMsgSuccessVeiculo = false;
      this.showMsgSuccessModelo = false;
    }

    if(screen == 'relatorios') {
      this.showRelatorios = true;
      this.showCadastro = false;
      this.showConsulta = false;
      this.showMsgSuccessVeiculo = false;
      this.showMsgSuccessModelo = false;
    }
  }

  /* Cria um veículo */
  onSubmitVeiculo() :void {

    if (this.cadastroVeiculoForm.invalid) { return; }

    this.loading = true;
    var veiculo = new Veiculo();
    veiculo.placa = this.cadastroVeiculoForm.value.placa;
    veiculo.ativo = this.cadastroVeiculoForm.value.ativo;
    veiculo.chassi = this.cadastroVeiculoForm.value.chassi;
    veiculo.cor = this.cadastroVeiculoForm.value.cor;
    veiculo.anoFabricacao = this.cadastroVeiculoForm.value.anoFabricacao;
    veiculo.modelo = new Modelo(this.cadastroVeiculoForm.value.modeloId);

    this.apiService.setVeiculo(veiculo).subscribe((res)=> {
      console.log(res);
      setTimeout(() => {
        this.loading = false;
        this.showMsgSuccessVeiculo = true;
        this.cadastroVeiculoForm.reset();
      },4000)
    })

  }

  /* Cria um modelo */
  onSubmitModelo() :void {

    if (this.cadastroModeloForm.invalid) { return; }

    this.loading = true;
    var modelo = new Modelo(null);
    modelo.ano=this.cadastroModeloForm.value.ano;
    modelo.descricao=this.cadastroModeloForm.value.descricao;
    modelo.consumoMedioKm=this.cadastroModeloForm.value.consumoMedioKm;
    modelo.qtdPassageiro=this.cadastroModeloForm.value.qtdPassageiro;

    this.apiService.setModelos(modelo).subscribe((res) => {
      setTimeout(() => {
        this.loading = false;
        this.showMsgSuccessModelo = true;
      }, 4000);
      this.showMsgSuccessModelo = false;
      this.cadastroModeloForm.reset();
    })

  }


  /* Consulta Veículo */
  onSearchVeiculo() :void {

    if(this.searchMode == 'placa') {
      this.apiService.consultaVeiculoByPlaca(this.consultaVeiculo.value).subscribe((veiculo: Veiculo[]) => {
        this.fetchVeiculo = veiculo;
        this.errorConsulta = false;
      },(error) => {
        this.errorConsulta = true;
      })
    }

    if(this.searchMode == 'modelo') {
      this.apiService.consultaVeiculoByModelo(this.consultaVeiculo.value).subscribe((veiculo: Veiculo[]) => {
        this.fetchVeiculo = veiculo;
        this.errorConsulta = false;
      },(error) => {
        this.errorConsulta = true;
      })
    }

  }

  onRelatorio() :void {

    this.apiService.relatorioByVeiculoAtivo(Utils.convertDate(this.startDate),Utils.convertDate(this.endDate)).subscribe((veiculo:Veiculo[]) => {
      this.fetchVeiculo = veiculo;
      this.errorRelatorio = false;
    },(error) => {
        this.errorRelatorio = true;
    })
      
  }
}
