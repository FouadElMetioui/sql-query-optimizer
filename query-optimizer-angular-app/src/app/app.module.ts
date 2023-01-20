import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { QueryFormComponent } from './components/query-form/query-form.component';
import { QueryOptimizationReportComponent } from './components/query-optimization-report/query-optimization-report.component';
import { FormsModule } from '@angular/forms';
import { PlanTableComponent } from './components/plan-table/plan-table.component';
import { ResultTableComponent } from './components/result-table/result-table.component';
import { NewQueryPlanTableComponent } from './components/new-query-plan-table/new-query-plan-table.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    QueryFormComponent,
    QueryOptimizationReportComponent,
    PlanTableComponent,
    ResultTableComponent,
    NewQueryPlanTableComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FontAwesomeModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
