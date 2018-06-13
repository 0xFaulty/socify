import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ChannelsComponent} from './core/channels/channels.component';
import {NotificationsComponent} from './core/notifications/notifications.component';
import {BlockGridComponent} from './core/block-grid/block-grid.component';

const routes: Routes = [
  {
    path: '',
    component: BlockGridComponent
  },
  {
    path: 'channels',
    component: ChannelsComponent
  },
  {
    path: 'notifications',
    component: NotificationsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
