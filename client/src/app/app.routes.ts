// ====== ./app/app.routes.ts ======

// Imports
// Deprecated import
// import { provideRouter, RouterConfig } from '@angular/router';
import { ModuleWithProviders }  from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { VeiculoComponent } from '../veiculos/veiculo.component'
import { FuncionarioComponent } from '../funcionarios/funcionario.component'

// Route Configuration
export const routes: Routes = [
  { path: 'veiculo', component: VeiculoComponent },
  { path: 'funcionario', component:FuncionarioComponent }
];

// Deprecated provide
// export const APP_ROUTER_PROVIDERS = [
//   provideRouter(routes)
// ];

export const routing: ModuleWithProviders = RouterModule.forRoot(routes);