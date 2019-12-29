import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StarFontComponent } from './star-font.component';

describe('StarFontComponent', () => {
  let component: StarFontComponent;
  let fixture: ComponentFixture<StarFontComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StarFontComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StarFontComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
