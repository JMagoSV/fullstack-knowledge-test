import { AfterViewInit, ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterLinkActive, Routes } from '@angular/router';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {
  items: MenuItem[] | undefined;
  activeItem: MenuItem | undefined;

  constructor() {}

  ngOnInit() {
    this.items = [
      { label: 'Characters', icon: 'pi pi-fw pi-home', routerLink: ['/pages/characters']},
      { label: 'Eventos', icon: 'pi pi-fw pi-calendar', routerLink: ['/pages/events'] }
    ];
    this.activeItem = this.items[0];
  }

}
