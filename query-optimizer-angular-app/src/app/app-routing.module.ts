import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { QueryFormComponent } from './components/query-form/query-form.component';

const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "query", component: QueryFormComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
