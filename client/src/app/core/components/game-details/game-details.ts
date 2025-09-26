import { Component, } from '@angular/core';
import { GameService } from '../../services/game-service';
import { map, Observable } from 'rxjs';
import { GameMinDTO } from '../../dtos/game-min-dto';
import { AsyncPipe } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { DomSanitizer } from '@angular/platform-browser';
import { SanitizeUrlPipe } from '../../../shared/pipes/sanitize-url-pipe';

@Component({
  selector: 'app-game-details',
  imports: [
    AsyncPipe,
    SanitizeUrlPipe,
    MatCardModule
  ],
  templateUrl: './game-details.html',
  styleUrl: './game-details.css',
})
export class GameDetails {
  readonly gameData: Observable<GameMinDTO[]>;

  constructor(private gameService: GameService, private domSanitizer: DomSanitizer) {
    this.gameData = this.gameService.fetchGameData();
  }
}
