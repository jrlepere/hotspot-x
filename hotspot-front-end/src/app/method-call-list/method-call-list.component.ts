import { Component, OnInit } from '@angular/core';

import { MethodCall } from '../method-call';
import { HotspotService } from '../hotspot.service';

@Component({
  selector: 'app-method-call-list',
  templateUrl: './method-call-list.component.html',
  styleUrls: ['./method-call-list.component.css']
})
export class MethodCallListComponent implements OnInit {

  methodCalls: MethodCall[];

  constructor(private hotspotService: HotspotService) { }

  ngOnInit() {
      this.getMethodCalls();
  }

  getMethodCalls(): void {
      this.hotspotService.getMethodCalls()
        .subscribe(methodCalls => this.methodCalls = methodCalls);
  }

}
