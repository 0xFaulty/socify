import {Component, OnInit} from '@angular/core';
import {ImageService} from '../../shared/image.service';

@Component({
  selector: 'app-block-grid',
  templateUrl: './block-grid.component.html',
  styleUrls: ['./block-grid.component.scss']
})
export class BlockGridComponent implements OnInit {
  images: any[];
  imagesFound: boolean = false;
  searching: boolean = false;

  handleSuccess(data) {
    this.imagesFound = true;
    this.images = data.hits;
    console.log(data.hits);
  }

  handleError(error) {
    console.log(error);
  }

  constructor(private _imageService: ImageService) {
  }

  searchImages(query: string) {
    this.searching = true;
    return this._imageService.getImage(query).subscribe(
      data => this.handleSuccess(data),
      error => this.handleError(error),
      () => this.searching = false
    );
  }

  ngOnInit() {
    this._imageService.currentMessage.subscribe(message => this.searchImages(message));
  }

}
