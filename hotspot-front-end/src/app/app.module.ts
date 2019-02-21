import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { MethodCallListComponent } from './method-call-list/method-call-list.component';
import { MethodCallLogComponent } from './method-call-log/method-call-log.component';

@NgModule({
  declarations: [
    AppComponent,
    MethodCallListComponent,
    MethodCallLogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
