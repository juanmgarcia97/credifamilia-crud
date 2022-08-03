import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientAddComponent } from './add/client-add.component';
import { ClientListComponent } from './client-list/client-list.component';
import { ClientListResolver } from './client-list/client-list.resolver';

const routes: Routes = [
  {
    path: '',
    component: ClientListComponent,
    resolve: {
      clients: ClientListResolver
    }
  },
  {
    path: 'add',
    component: ClientAddComponent
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientRoutingModule {}
