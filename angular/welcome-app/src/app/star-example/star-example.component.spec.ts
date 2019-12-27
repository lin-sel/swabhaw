import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StarExampleComponent } from './star-example.component';

describe('StarExampleComponent', () => {
  let component: StarExampleComponent;
  let fixture: ComponentFixture<StarExampleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StarExampleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StarExampleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
