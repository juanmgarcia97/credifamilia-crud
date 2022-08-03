import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Client } from '../utils/types';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ClientService {
  private clientApi = 'http://localhost:8090/credifamilia/api/clients/';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET, POST, DELETE',
      'Access-Control-Allow-Headers': 'X-Requested-With,Content-Type'
    }),
  };

  constructor(private http: HttpClient) {}

  getClientList() {
    return this.http.get<{ body: Client[] }>(this.clientApi).pipe(
      map((data) => {
        return data.body.map(client => {
          let newBirthday = ''
          return {
            ...client,
            birthday: `${client.birthday[2]}/${client.birthday[1]}/${client.birthday[0]}`
          }
        });
      })
    );
  }

  saveClient(client: Client) {
    return this.http.post(this.clientApi, client, this.httpOptions);
  }

  deleteClient(document: string) {
    return this.http.delete(this.clientApi + document, this.httpOptions);
  }
}
