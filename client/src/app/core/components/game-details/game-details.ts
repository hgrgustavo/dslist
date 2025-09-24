import { Component, } from '@angular/core';
import { GameService } from '../../services/game-service';
import { Observable } from 'rxjs';
import { GameMinDTO } from '../../dtos/game-min-dto';
import { AsyncPipe } from '@angular/common';


@Component({
  selector: 'app-game-details',
  imports: [AsyncPipe],
  templateUrl: './game-details.html',
  styleUrl: './game-details.css',
})
export class GameDetails {
  readonly gameData: Observable<GameMinDTO[]>;

  constructor(private gameService: GameService) {
    this.gameData = this.gameService.fetchGameData();
  }

}
