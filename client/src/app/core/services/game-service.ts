import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GameMinDTO } from '../dtos/game-min-dto';
import { environment } from '../../../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class GameService {
  constructor(private httpClient: HttpClient) { }

  public fetchGameData(): Observable<GameMinDTO[]> {
    return this.httpClient.get<GameMinDTO[]>(`${environment.SPRING_API}/games`);
  }
}
