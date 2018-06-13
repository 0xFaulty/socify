import {Component, OnInit} from '@angular/core';
import {DataReceiveService} from '../../shared/data-receive.service';

@Component({
  selector: 'app-block-grid',
  templateUrl: './block-grid.component.html',
  styleUrls: ['./block-grid.component.scss']
})
export class BlockGridComponent implements OnInit {
  publications: any[];
  imagesFound = false;
  searching = false;

  handleSuccess(data) {
    this.imagesFound = true;
    this.publications = data;
    console.log(data.hits);
  }

  handleError(error) {
    console.log(error);
  }

  constructor(private dataReceiveService: DataReceiveService) {
  }

  searchImages(query: string) {
    this.searching = true;
    return this.dataReceiveService.getNewsFeed(query).subscribe(
      data => this.handleSuccess(data),
      error => this.handleError(error),
      () => this.searching = false
    );
  }

  ngOnInit() {
    this.dataReceiveService.currentMessage.subscribe(message => this.searchImages(message));
  }

  getPublicationDate(date: string) {
    date = '1526799605';
    return new Date(Number(date)).toDateString();
  }
}
