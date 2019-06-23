import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiService } from '../service/api.service';
import { User,Pessoa } from '../models/modelo'
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import * as moment from 'moment'
import { DatePipe } from '@angular/common';
import Utils from '../app/utils'


@Component({
    selector: 'app-funcionario',
    templateUrl: './funcionario.component.html',
    styleUrls: ['./funcionario.component.scss']
})

export class FuncionarioComponent {


    cadastroForm: FormGroup;
    consultaForm: FormGroup;
    startDate:string;
    endDate:string;




    showCadastro = true;
    showConsulta = false;
    showRelatorio = false;
    showMsgSuccess = false;
    errorConsulta = false;
    errorRelatorio = false;

    fetchUser: User[];
    fetchUsers: User[];
    fetchPessoa: Pessoa[];

    today;
    options = {
        fieldSeparator: ',',
        quoteStrings: '"',
        decimalseparator: '.',
        headers: ['Nome', 'Data de Nascimento', 'CPF', 'Data do Cadastro'],
        showTitle: false,
        useBom: true,
        removeNewLines: false,
        keys: ['nome','dtNascimento','cpf','createdAt']
      };
    constructor(private apiService: ApiService,private formBuilder: FormBuilder) { this.today = new Date().toISOString().split('T')[0];}
    
    // controller
    parseDateStart(dateString: string): string {
        this.startDate = dateString;
        return dateString;

    }
    parseDateEnd(dateString: string): string {
        this.endDate = dateString;
        return dateString;

    }

    switchScreen(screen) :void {
        if(screen == 'cadastro') {
          this.showCadastro = true;
          this.showConsulta = false;
          this.showRelatorio = false;
          
        }
    
        if(screen == 'consultas') {
    
          this.showConsulta = true;
          this.showCadastro = false;
          this.showRelatorio = false;
        }
    
        if(screen == 'relatorios') {
          this.showRelatorio = true;
          this.showCadastro = false;
          this.showConsulta = false;
        }
      }
      
    ngOnInit() {
  

        this.cadastroForm = this.formBuilder.group({
            nome: ['',Validators.required],
            cpf: ['',Validators.required],
            dtNascimento: ['',Validators.required],
            login:['',Validators.required],
            senha:['',Validators.required]
        })

        this.consultaForm = this.formBuilder.group({
            descricao:['',Validators.required],
            searchMode:['',Validators.required]
        })

    }

   

    onSubmit() :void {

        if (this.cadastroForm.invalid) { return; }

        var u = new User();
        u.usuario = this.cadastroForm.value.login;
        u.senha = this.cadastroForm.value.senha;
        u.pessoa = new Pessoa(this.cadastroForm.value.nome,
                this.cadastroForm.value.cpf,
                Utils.convertDate(this.cadastroForm.value.dtNascimento));

        

        this.apiService.setUser(u).subscribe((res) => {
            console.log(res);
            this.showMsgSuccess = true;
            this.cadastroForm.reset();
        })


    }


    onSearch() :void {

        if(this.consultaForm.invalid) { return; }

        if(this.consultaForm.value.searchMode === 'cpf') {

            this.apiService.consultaUserByCpf(this.consultaForm.value.descricao).subscribe((user: User[]) => {
                this.fetchUser = user;
                console.log(this.fetchUser)
                this.errorConsulta = false;
            },(error) => {
                this.errorConsulta = true;
            })
        }

        if(this.consultaForm.value.searchMode === 'nome') {

            this.apiService.consultaUserByNome(this.consultaForm.value.descricao).subscribe((user: User[]) => {
                this.fetchUsers = user;
                console.log(this.fetchUsers);
                this.errorConsulta = false;
            },(error) => {
                this.errorConsulta = true;
            })
        }
    }


    onRelatorio() :void {

        this.apiService.relatorioByDtNascimento(Utils.convertDate(this.startDate),Utils.convertDate(this.endDate)).subscribe((pessoa:Pessoa[]) => {
            this.fetchPessoa = pessoa;
        },(error) => {
            this.errorRelatorio = true;
        })

    }


}