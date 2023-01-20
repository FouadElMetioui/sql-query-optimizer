import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-plan-table',
  templateUrl: './plan-table.component.html',
  styleUrls: ['./plan-table.component.css']
})
export class PlanTableComponent {
  @Input() plans: any;
}
