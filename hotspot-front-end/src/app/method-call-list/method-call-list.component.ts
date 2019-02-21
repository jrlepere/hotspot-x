import { Component, OnInit } from '@angular/core';

import { MethodCallTimes } from '../method-call-times';
import { HotspotService } from '../hotspot.service';

@Component({
  selector: 'app-method-call-list',
  templateUrl: './method-call-list.component.html',
  styleUrls: ['./method-call-list.component.css']
})
export class MethodCallListComponent implements OnInit {

  methodCallTimes: MethodCallTimes;

  constructor(private hotspotService: HotspotService) { }

  ngOnInit() {
      this.getMethodCalls();
  }

  getMethodCalls(): void {
      this.hotspotService.getMethodCalls(1)
        .subscribe(methodCalls => this.methodCallTimes = methodCalls);
  }

}
