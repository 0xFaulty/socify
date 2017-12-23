import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  // imports: [
  //   BrowserModule
  // ],
  imports: [
    BrowserModule.withServerTransition({ appId: 'front' })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
