import { Component, Input } from '@angular/core';
import { faXmark } from '@fortawesome/free-solid-svg-icons';
import { QueryService } from 'src/app/services/query.service';

@Component({
  selector: 'app-query-form',
  templateUrl: './query-form.component.html',
  styleUrls: ['./query-form.component.css']
})
export class QueryFormComponent {
  query = "";
  highlightedQuery = '';
  highlightedIndex: any;
  index: any;
  valider: boolean = true;
  includeWhere: boolean = false;
  open: boolean = false;

  // Icons
  faXmark = faXmark;

  results: any;
  plans: any;
  newPlans: any;

  constructor(private queryService: QueryService) { }

  verifierRequete() {
    this.queryService.verifierRequete(this.query).subscribe(responce => {
      this.valider = responce == 1 ? true : false;
      if (this.valider) {
        this.getPlans();
      } else {
        this.openAlert(true);
      }
    })
  }

  getPlans() {
    this.openModal();
    this.queryService.getPlan(this.query).subscribe(responce => {
      this.plans = responce;
      this.includeWhere = this.query.toLowerCase().includes("where".toLowerCase());
      if (this.includeWhere) {
        this.getIndexes();
      }
      this.getResults();
    })
  }

  getResults() {
    this.openModal();
    this.queryService.getResult(this.query).subscribe(responce => {
      console.log(responce);
      this.results = responce;
      this.getPlanExeOptimise();
    })
  }

  getIndexes() {
    this.queryService.getIndexes(this.query).subscribe(responce => {
      console.log(responce);
      this.index = responce;
      this.highlightIndex(this.index);
    })
  }

  getPlanExeOptimise() {
    this.queryService.getPlanOptimise(this.query).subscribe(responce => {
      console.log(responce)
      this.newPlans = responce;
    })
  }

  highlightQuery() {
    const sqlKeywords = ['SELECT', 'FROM', 'WHERE', 'AND', 'OR', 'INNER JOIN', 'LEFT JOIN', 'RIGHT JOIN', 'ON', 'ORDER BY', 'GROUP BY', 'HAVING', 'LIMIT', 'OFFSET'];
    let highlightedText = this.query;
    sqlKeywords.forEach(keyword => {
      const regex = new RegExp(`\\b${keyword}\\b`, 'gi');
      highlightedText = highlightedText.replace(regex, `<span class="text-indigo-500">${keyword}</span>`);
    });
    this.highlightedQuery = highlightedText;
  }

  highlightIndex(text: any) {
    const sqlKeywords = ['ALTER TABLE', 'ADD INDEX'];
    let highlightedText = text;
    sqlKeywords.forEach(keyword => {
      const regex = new RegExp(`\\b${keyword}\\b`, 'gi');
      highlightedText = highlightedText.replace(regex, `<span class="text-sky-700">${keyword}</span>`);
    });
    this.highlightedIndex = highlightedText;
  }

  openModal() {
    const modal = document.getElementById('modal');
    if (modal != null) {
      modal.classList.remove('hidden');
      modal.classList.add('flex');
    }
  }

  openAlert(isOpen: any) {
    this.open = isOpen;
  }
}
