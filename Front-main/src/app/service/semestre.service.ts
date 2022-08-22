import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { ISemestre } from '../shared/model/semestre.model';
import { Note } from '../shared/model/note.model';


type EntityResponseType = HttpResponse<ISemestre>;
type EntityArrayResponseType = HttpResponse<ISemestre[]>;

@Injectable({ providedIn: 'root' })
export class SemestreService {
  public resourceUrl = SERVER_API_URL + 'api';
  public sessionUrl = SERVER_API_URL + 'api/sessions';
  public noteUrl = SERVER_API_URL + 'api';
  constructor(protected http: HttpClient) {}

//   create(semestre: ISemestre): Observable<EntityResponseType> {
//     return this.http.post<ISemestre>(this.resourceUrl, semestre, { observe: 'response' });
//   }

//   update(semestre: ISemestre): Observable<EntityResponseType> {
//     return this.http.put<ISemestre>(this.resourceUrl, semestre, { observe: 'response' });
//   }

//   find(id: number): Observable<EntityResponseType> {
//     return this.http.get<ISemestre>(`${this.resourceUrl}/${id}`, { observe: 'response' });
//   }

  getSemestre(idgroupe: number): Observable<EntityArrayResponseType> {
    
    return this.http.get<ISemestre[]>(`${this.resourceUrl}/semestres/getSemestresbyNiveau/${idgroupe}`, { observe: 'response' });
  }

  session(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<any[]>(this.sessionUrl, { params: options, observe: 'response' });
  }

  getsNote(idgroupe: number, idsemestre: number, idsession:number): Observable<any> {
    
    return this.http.get<any>(`${this.noteUrl}/notes/getNotesByUniteEnseignement/${idgroupe}/${idsemestre}/${idsession}`, { observe: 'response' });
  }
//   delete(id: number): Observable<HttpResponse<{}>> {
//     return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
//   }
}
