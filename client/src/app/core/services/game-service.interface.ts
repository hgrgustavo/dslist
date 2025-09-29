import { Observable } from "rxjs";
import { GameMinDTO } from "../dtos/game-min-dto";

export interface IGameService {
  fetchGameData(): Observable<GameMinDTO[]>;
}
