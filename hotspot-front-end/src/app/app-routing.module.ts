import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MethodCallLogComponent } from './method-call-log/method-call-log.component';
import { MethodCallListComponent } from './method-call-list/method-call-list.component';

const routes: Routes = [
    { path: '', redirectTo: '/log', pathMatch: 'full' },
    { path: 'log', component: MethodCallLogComponent },
    { path: 'list', component: MethodCallListComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes)],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
