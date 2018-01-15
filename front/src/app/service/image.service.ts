import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class ImageService {

  constructor(private http: HttpClient,) {
  }

  loadImages() {
    return this.http.jsonp('https://api.flickr.com/services/feeds/photos_public.gne?format=json&jsoncallback=JSON_CALLBACK', 'callback');
  }

  // requestJsonp(url, options, callback = 'callback') {
  //   // options.params is an HttpParams object
  //   const params = options.params.toString();
  //   return this.http.jsonp(`${url}?${params}`, callback)
  //     .map((response: Response) => response[1])
  //     .map((results: any[]) => results.map((result: string) => result[0]));
  // }

}
