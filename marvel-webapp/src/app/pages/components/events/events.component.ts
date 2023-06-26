import { Component, OnInit } from '@angular/core';
import { EventsService } from '../../services/events.service';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.scss']
})
export class EventsComponent implements OnInit {
  listData = [] as any[];

  constructor(private readonly eventService: EventsService) { }

  ngOnInit() {
    this.eventService.getAll().subscribe((_response: any) => {
      this.listData = _response['results'];
    }, error => {
      console.log(error);
    });
  }

}
