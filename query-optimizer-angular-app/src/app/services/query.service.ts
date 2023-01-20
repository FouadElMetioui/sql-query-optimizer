import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class QueryService {
  apiUrl = "http://localhost:8023/api/requete";

  constructor(private httpClient: HttpClient) { }

  verifierRequete(request: any) {
    return this.httpClient.post(`${this.apiUrl}/valider`, request);
  }

  getIndexes(request: any) {
    return this.httpClient.post(`${this.apiUrl}/indexes`, request, { responseType: 'text' });
  }

  persistRequete(request: any) {
    return this.httpClient.post(`${this.apiUrl}`, request);
  }

  getResult(request: any) {
    return this.httpClient.get(`${this.apiUrl}/${request}`);
  }

  getPlan(request: any) {
    return this.httpClient.get(`${this.apiUrl}/plan/${request}`);
  }

  getAllRequetes() {
    return this.httpClient.get(`${this.apiUrl}`);
  }

  getPlanOptimise(request: any) {
    return this.httpClient.post(`${this.apiUrl}/planoptimise`, request);
  }

}
