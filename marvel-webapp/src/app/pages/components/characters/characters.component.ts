import { Component, OnInit } from '@angular/core';
import { MarvelService } from '../../services/marvel.service';

@Component({
  selector: 'app-characters',
  templateUrl: './characters.component.html',
  styleUrls: ['./characters.component.scss']
})
export class CharactersComponent implements OnInit {
  listData = [] as any[];
  selected: any;
  visible = false as boolean;

  constructor(private readonly marvelService: MarvelService) { }

  ngOnInit() {
    this.marvelService.getAll().subscribe((_response: any) => {
      this.listData = _response['results']
    }, error => {
      console.log(error);
    });
  }

  onRowSelect(event: any) {
    this.marvelService.getAllById(event.data['id']).subscribe((_response: any) => {
      this.visible = true;
    }, error => {
      console.log(error);
    });
  }
}
