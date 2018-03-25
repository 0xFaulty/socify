import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ChannelsComponent} from './core/channels/channels.component';
import {SettingsComponent} from './core/settings/settings.component';
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
