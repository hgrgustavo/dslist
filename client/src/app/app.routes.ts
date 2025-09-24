import { Routes } from '@angular/router';
import { GameDetails } from './core/components/game-details/game-details';
import { GenreDetails } from './core/components/genre-details/genre-details';

export const routes: Routes = [
  {
    path: "",
    redirectTo: "games",
    pathMatch: "full"
  },

  {
    path: "games",
    component: GameDetails,
    title: "Games"
  },

  {
    path: "genres",
    component: GenreDetails,
    title: "Genres"
  }
];
