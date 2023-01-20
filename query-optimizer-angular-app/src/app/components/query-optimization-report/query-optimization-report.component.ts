import { Component, Input } from '@angular/core';
import { faXmark } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-query-optimization-report',
  templateUrl: './query-optimization-report.component.html',
  styleUrls: ['./query-optimization-report.component.css']
})
export class QueryOptimizationReportComponent {
  @Input() plans: any;
  @Input() newPlans: any;
  @Input() results: any;
  @Input() highlightedQuery: any;
  @Input() highlightedIndex: any;
  @Input() includeWhere: any;

  open: boolean = true;

  // Icons
  faXmark = faXmark;

  closeModal() {
    const modal = document.getElementById('modal');
    if (modal != null) {
      modal.classList.remove('flex');
      modal.classList.add('hidden');
    }
  }

  openAlert(isOpen: any) {
    this.open = isOpen;
  }
}
