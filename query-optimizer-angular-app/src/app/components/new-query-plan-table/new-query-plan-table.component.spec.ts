import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewQueryPlanTableComponent } from './new-query-plan-table.component';

describe('NewQueryPlanTableComponent', () => {
  let component: NewQueryPlanTableComponent;
  let fixture: ComponentFixture<NewQueryPlanTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewQueryPlanTableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewQueryPlanTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
