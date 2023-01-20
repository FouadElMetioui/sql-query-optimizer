import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-new-query-plan-table',
  templateUrl: './new-query-plan-table.component.html',
  styleUrls: ['./new-query-plan-table.component.css']
})
export class NewQueryPlanTableComponent {
  @Input() newPlans: any;
}
