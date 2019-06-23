export class Modelo {
    constructor(id: number){this.id = id;};
    
    id:number;
    descricao:string;
    ano:string;
    consumoMedioKm:string;
    qtdPassageiro:number;

}


export class Veiculo {
    
    placa:string;
    ativo:boolean;
    chassi:string;
    cor:string;
    anoFabricacao:number;
    modelo:Modelo
}

export class Pessoa {
    nome:string;
    cpf:string;
    dtNascimento:string;

    constructor()
    constructor(nome:string,cpf:string,dtNascimento:string) 
    constructor(nome?:string,cpf?:string,dtNascimento?:string){
        this.nome = nome;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
    } 

}

export class User {
    usuario:string;
    senha:string;
    pessoa:Pessoa

}
