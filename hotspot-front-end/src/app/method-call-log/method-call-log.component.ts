import { Component, OnInit, Input } from '@angular/core';

import { HotspotService } from '../hotspot.service';
import { MethodCallTimes } from '../method-call-times';

@Component({
  selector: 'app-method-call-log',
  templateUrl: './method-call-log.component.html',
  styleUrls: ['./method-call-log.component.css']
})
export class MethodCallLogComponent implements OnInit {

  @Input() methodCallTimes: MethodCallTimes;

  constructor(private hotspotService: HotspotService) { }

  ngOnInit() {
      this.getMethodCalls();
  }

  getMethodCalls(): void {
      console.log('Log component get call times');
      this.hotspotService.getMethodCallsAll()
        .subscribe(methodCalls => this.methodCallTimes = methodCalls);
  }

}
