import { Component, OnInit } from '@angular/core';
import {ImageService} from '../../shared/image.service';
import {FormControl, Validators} from '@angular/forms';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  message: string = "girl";

  constructor(private _imageService: ImageService) { }

  ngOnInit() {
    this._imageService.currentMessage.subscribe(message => this.message = message)
  }

  searchImages(message: string){
    this._imageService.changeMessage(message);
  }

  hasError(message: string){
    return this.message === "";
  }

}
