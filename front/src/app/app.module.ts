import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';

import {AppComponent} from './app.component';
import {SidenavComponent} from './core/sidenav/sidenav.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MaterialModule} from './material.module';
import {HeaderComponent} from './core/header/header.component';
import {DataReceiveService} from './shared/data-receive.service';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NotificationsComponent} from './core/notifications/notifications.component';
import {ChannelsComponent} from './core/channels/channels.component';
import {Error404Component} from './core/error404/error-404.component';
import {BlockGridComponent} from './core/block-grid/block-grid.component';

@NgModule({
  declarations: [
    AppComponent,
    SidenavComponent,
    HeaderComponent,
    NotificationsComponent,
    ChannelsComponent,
    Error404Component,
    BlockGridComponent
  ],
  imports: [
    BrowserModule.withServerTransition({appId: 'front'}),
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [DataReceiveService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
