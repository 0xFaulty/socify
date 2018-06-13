import {Component, OnInit} from '@angular/core';
import {DataReceiveService} from '../../shared/data-receive.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  message = 'girl';
  searchQuery = '';

  constructor(private _imageService: DataReceiveService) {
  }

  ngOnInit() {
    this._imageService.currentMessage.subscribe(message => this.message = message);
  }

  searchPublications(message: string) {
    this._imageService.changeMessage(message);
  }

}
