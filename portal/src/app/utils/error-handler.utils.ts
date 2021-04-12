import { HttpErrorResponse } from "@angular/common/http";
import { throwError } from "rxjs";

export class ErrorHandler {
    handleError(error: HttpErrorResponse) {
        console.log(error);
        return throwError(error.message);
    }
}
