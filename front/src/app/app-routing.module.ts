import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ImageListComponent} from './core/image-list/image-list.component';
import {ChannelsComponent} from './core/channels/channels.component';
import {SettingsComponent} from './core/settings/settings.component';

const routes: Routes = [
  {
    path: '',
    component: ImageListComponent
  },
  {
    path: 'channels',
    component: ChannelsComponent
  },
  {
    path: 'settings',
    component: SettingsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
