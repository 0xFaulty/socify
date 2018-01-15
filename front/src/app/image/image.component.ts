import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-image',
  templateUrl: './image.component.html',
  styleUrls: ['./image.component.scss']
})
export class ImageComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
  }

  GetImages(imageService) {
    imageService.loadImages().then(function (data) {
      data.data.items.forEach(function (obj) {
        let desc = obj.description;
        obj.actualHeight = desc.match(/height="(.*?)"/)[1];
        obj.actualWidth = desc.match(/width="(.*?)"/)[1];
      });
      this.pics = data.data.items;
    });

  }

}
