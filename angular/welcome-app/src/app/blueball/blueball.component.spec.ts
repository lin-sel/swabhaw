import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BlueballComponent } from './blueball.component';

describe('BlueballComponent', () => {
  let component: BlueballComponent;
  let fixture: ComponentFixture<BlueballComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BlueballComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BlueballComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
