import { Component, OnInit } from '@angular/core';
import { HealthService } from './core/health/health.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  providers: [HealthService]
})
export class AppComponent implements OnInit {

  constructor(private healthService: HealthService) {
  }
  
  ngOnInit() {
    this.healthService.checkIfBackendIsResponsive();
  }

}
