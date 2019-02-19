import { Component, OnInit } from '@angular/core';

import { HotspotService } from '../hotspot.service';
import { MethodCall } from '../method-call';

@Component({
  selector: 'app-method-call-log',
  templateUrl: './method-call-log.component.html',
  styleUrls: ['./method-call-log.component.css']
})
export class MethodCallLogComponent implements OnInit {

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
