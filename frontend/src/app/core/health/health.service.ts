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
                console.log("Backend API is answering requests.");
            }
        }, error => {
            console.log("Backend API is not responding", error);
        });
    }

}