import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenreDTO } from '../dtos/genre-dto';
import { environment } from '../../../environment/environment';


@Injectable({
  providedIn: 'root'
})
export class GenresService {
  constructor(private httpClient: HttpClient) { }

  public fetchGenreData(): Observable<GenreDTO> {
    return this.httpClient.get<GenreDTO>(`${environment.SPRING_API}/genres`);
  }
}
