import { DATE_FORMAT } from './../shared/constants/input.constants';
import { IUser, User } from './../core/user/user.model';
import { Parcours } from './../core/user/alumni.model';
import { IEtudiant } from './../shared/model/etudiant.model';
// import { RegisterService } from './register.service';

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpRequest, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import * as moment from 'moment';

import { map } from 'rxjs/operators';
import { SERVER_API_URL } from '../app.constants';
import { Experience } from 'app/core/user/experience.model';
import { AuthServerProvider } from 'app/core/auth/auth-jwt.service';
type EntityResponseType = HttpResponse<IEtudiant>;
type EntityArrayResponseType = HttpResponse<IEtudiant[]>;

@Injectable({ providedIn: 'root' })
export class RegisterService {

  constructor( private _http : HttpClient, private authServerProvider:AuthServerProvider) {}

  public baseURL = "http://localhost:8080/parcours";

  public baseURL1 = "http://localhost:8080/experience";

  public registerUserFromRemote(user: User):Observable<any>{

    return this._http.post<any>("http://localhost:8080/register",user)
    
  
  }
   protected convertDateFromClient(etudiant: IEtudiant): IEtudiant {
    const copy: IEtudiant = Object.assign({}, etudiant, {
      dateNaissance: etudiant.dateNaissance && etudiant.dateNaissance.isValid() ? etudiant.dateNaissance.format(DATE_FORMAT) : undefined,
    });
    return copy;
  }
  public registerAlumni(alumni: Parcours):Observable<Object>{

    return this._http.post("http://localhost:8080/parcours",alumni)
  }
  public registerAlumni2(alumni2: Experience):Observable<Object>{

    return this._http.post("http://localhost:8080/experience",alumni2)
  }

/*   getParcoursById(id:number): Observable<Parcours>{

    return this._http.get<Parcours>(`${this.baseURL}/${id}`);

  } */
  getParcoursList(): Observable<Parcours[]>{
    return this._http.get<Parcours[]>(`${this.baseURL}`);  
  }
  getExperienceList(): Observable<Experience[]>{
    return this._http.get<Experience[]>(`${this.baseURL1}`);  
  }
}

