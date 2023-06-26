import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainComponent } from './components/main/main.component';
import { CharactersComponent } from './components/characters/characters.component';
import { EventsComponent } from './components/events/events.component';

const routes: Routes = [
  { path: '', component: MainComponent, children: [
    { path: '', pathMatch: 'full', redirectTo: 'characters'},
    { path: 'characters', component: CharactersComponent },
    { path: 'events', component: EventsComponent }
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PagesRoutingModule { }
