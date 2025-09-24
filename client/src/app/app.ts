import { Component, signal } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { Searchbar } from './core/components/searchbar/searchbar';
import { Router } from 'express';

@Component({
  selector: 'app-root',
  imports: [
    Searchbar,
    RouterOutlet
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})

export class App {

}
