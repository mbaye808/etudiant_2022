import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IEtudiant } from 'app/shared/model/etudiant.model';

type EntityResponseType = HttpResponse<IEtudiant>;
type EntityArrayResponseType = HttpResponse<IEtudiant[]>;

@Injectable({ providedIn: 'root' })
export class EtudiantService {
  public resourceUrl = SERVER_API_URL + 'register';

  constructor(protected http: HttpClient) {}

  create(etudiant: IEtudiant): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(etudiant);
    return this.http
      .post<IEtudiant>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

 update (etudiant: IEtudiant): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(etudiant);
    return this.http
      .put<IEtudiant>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }


  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IEtudiant>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }


  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IEtudiant[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(etudiant: IEtudiant): IEtudiant {
    const copy: IEtudiant = Object.assign({}, etudiant, {
      dateNaissance: etudiant.dateNaissance && etudiant.dateNaissance.isValid() ? etudiant.dateNaissance.format(DATE_FORMAT) : undefined,
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.dateNaissance = res.body.dateNaissance ? moment(res.body.dateNaissance) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((etudiant: IEtudiant) => {
        etudiant.dateNaissance = etudiant.dateNaissance ? moment(etudiant.dateNaissance) : undefined;
      });
    }
    return res;
  }
}
