import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MethodCallListComponent } from './method-call-list.component';

describe('MethodCallListComponent', () => {
  let component: MethodCallListComponent;
  let fixture: ComponentFixture<MethodCallListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MethodCallListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MethodCallListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
