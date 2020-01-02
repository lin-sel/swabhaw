import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { NameMatcherPage } from './name-matcher.page';

describe('NameMatcherPage', () => {
  let component: NameMatcherPage;
  let fixture: ComponentFixture<NameMatcherPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NameMatcherPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(NameMatcherPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
