import { Injectable } from "@angular/core";
import { HealthControllerService } from "generated/openapi";

@Injectable()
export class HealthService {

    constructor(private healthService: HealthControllerService, ) {
    }

    checkIfBackendIsResponsive(): void {
        this.healthService.checkAlive().subscribe(result => {
            const isAlive: boolean = result;

            if(isAlive) {
                console.log("%cBackend API is responsive & answering requests.", "color: #36f014");
            }
        }, error => {
            console.log("%cBackend API is not responding.", "color: #ff073a" , error);
        });
    }

}
