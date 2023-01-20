import { Component, HostListener } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  navbar: any;

  ngOnInit() {
    this.navbar = document.getElementById('navbar');
  }
  // Sticky navbar
  @HostListener('window:scroll', ['$event'])
  onWindowScroll(e: any) {
    if (window.pageYOffset) {
      this.navbar.classList.add('sticky', 'top-0', 'bg-white', 'border');
    } else {
      this.navbar.classList.remove('sticky', 'top-0', 'bg-white', 'border');
    }
  }
}
