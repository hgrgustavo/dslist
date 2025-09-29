import { forkJoin, from, map, Observable, switchMap } from "rxjs";
import { GameMinDTO } from "../dtos/game-min-dto";
import { IGameService } from "./game-service.interface";
import { GameService } from "./game-service";
import { environment } from "../../../environment/environment";

export class CachedGameService implements IGameService {
  private gameService: GameService;

  constructor(gameService: GameService) {
    this.gameService = gameService;
  }

  fetchGameData(): Observable<GameMinDTO[]> {
    return this.gameService.fetchGameData().pipe(
      switchMap(array => {
        return forkJoin(array.map(game => {
          const url = `${environment.SPRING_API}/games/${game.id}`
          return from(caches.open("games-cache")
            .then(async cache => {
              if (!await cache.match(url)) {
                await cache.add(url);
              }
              return game;
            }));
        }));
      })
    )
  }
}

