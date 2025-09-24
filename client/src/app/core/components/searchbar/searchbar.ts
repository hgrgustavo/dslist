import { Component } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms'

@Component({
  selector: 'searchbar',
  imports: [ReactiveFormsModule],
  templateUrl: './searchbar.html',
  styleUrl: './searchbar.css'
})
export class Searchbar {
  control = new FormControl('');
}
