
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router'
import { Observable } from 'rxjs';
import { AuthServerProvider } from './auth-jwt.service';

@Injectable({
    providedIn: 'root'
})
export class AuthGuard implements CanActivate {

    constructor( private auth: AuthServerProvider, private router: Router){}
    canActivate(){
        if(this.auth.IsLoggedIn()){
            return true;
        }
        alert("Vous n'êtes pas connecté")
       this.router.navigate(['log']);
       return false;
    }
    }

