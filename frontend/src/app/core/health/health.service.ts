import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";


@Injectable()
export class HealthService {

    constructor(private http: HttpClient) {
    }

    checkIfBackendIsResponsive() {
        return this.http.get("/api/health/alive", {responseType: "text"}).subscribe(result => {
            const isAlive: boolean = result === "true";

            if(isAlive) {
                console.log("%cBackend API is answering requests.", "color: #36f014");
            }
        }, error => {
            console.log("%cBackend API is not responding", "color: #ff073a" , error);
        });
    }

}