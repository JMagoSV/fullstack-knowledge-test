import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { CharacterModel } from '../models/character.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MarvelService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<CharacterModel> {
    const url = `${environment.api_url}/characters`;
    return this.http.get<CharacterModel>(url).pipe(
      tap(_ => console.log(`fetched characters`)),
      catchError(this.handleError<CharacterModel>(`getAll`))
    );
  }

  getAllById(id: number): Observable<CharacterModel> {
    const url = `${environment.api_url}/characters/${id}`;
    return this.http.get<CharacterModel>(url).pipe(
      tap(_ => console.log(`fetched characters id=${id}`)),
      catchError(this.handleError<CharacterModel>(`getAllById id=${id}`))
    );
  }

   /**
 * Handle Http operation that failed.
 * Let the app continue.
 * @param operation - name of the operation that failed
 * @param result - optional value to return as the observable result
 */
   private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
       console.error(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  /** Log a HeroService message with the MessageService */
  private log(message: string) {
    console.error('MarvelService: ' + message);
  }
}
