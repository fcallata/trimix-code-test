import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent} from './pages/home/home.component';
import { PersonaComponent} from './pages/persona/persona.component';


const appRoutes:Routes = [
	{ path:'', component: HomeComponent },
	{ path:'home', component: HomeComponent },
	{ path:'persona', component: PersonaComponent },
	{ path:'persona/:id', component: PersonaComponent },
	{ path: '**', component: HomeComponent }
];

export const appRoutingProviders: any [] = [];
export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);