import { Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';

export const routes: Routes = [
    { path: 'dashboard', component: DashboardComponent }, // define a rota para o dashboard
    { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
];
