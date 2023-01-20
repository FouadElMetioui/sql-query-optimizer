import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QueryOptimizationReportComponent } from './query-optimization-report.component';

describe('QueryOptimizationReportComponent', () => {
  let component: QueryOptimizationReportComponent;
  let fixture: ComponentFixture<QueryOptimizationReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QueryOptimizationReportComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(QueryOptimizationReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
