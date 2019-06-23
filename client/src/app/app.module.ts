import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { VeiculoComponent } from '../veiculos/veiculo.component'
import { FuncionarioComponent } from '../funcionarios/funcionario.component'
import { TopBarComponent } from '../layout/topbar.component'
import { CustomAngular2csvComponent } from '../angularcsv/angularcsv'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { Routes, RouterModule } from '@angular/router';
import { routing } from './app.routes';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgxMaskModule } from 'ngx-mask';
import { Angular2CsvModule } from 'angular2-csv';

@NgModule({
  declarations: [
    AppComponent,
    CustomAngular2csvComponent,
    VeiculoComponent,
    FuncionarioComponent,
    TopBarComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    routing,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    Angular2CsvModule,
    NgxMaskModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
