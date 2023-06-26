import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainComponent } from './components/main/main.component';
import { CharactersComponent } from './components/characters/characters.component';
import { EventsComponent } from './components/events/events.component';
import { PagesRoutingModule } from './pages-routing.module';
import { TabMenuModule } from 'primeng/tabmenu';
import { TableModule } from 'primeng/table';
import { ImageModule } from 'primeng/image';
import { DialogModule } from 'primeng/dialog';
import { ChipModule } from 'primeng/chip';
import { FieldsetModule } from 'primeng/fieldset';
import { TabViewModule } from 'primeng/tabview';
import { HttpClientModule } from '@angular/common/http';
import { MarvelService } from './services/marvel.service';
import { EventsService } from './services/events.service';

@NgModule({
  declarations: [
    MainComponent,
    CharactersComponent,
    EventsComponent
  ],
  imports: [
    CommonModule,
    PagesRoutingModule,
    TabMenuModule,
    TableModule,
    ImageModule,
    DialogModule,
    ChipModule,
    FieldsetModule,
    TabViewModule,
    HttpClientModule
  ], 
  providers: [
    MarvelService,
    EventsService
  ]
})
export class PagesModule { }
