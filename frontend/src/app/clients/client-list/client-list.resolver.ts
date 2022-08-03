import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { Client } from 'src/app/utils/types';
import { ClientService } from '../client.service';

@Injectable({
  providedIn: 'root'
})
export class ClientListResolver implements Resolve<Client[]> {

  constructor(private clientService: ClientService) {}

  resolve(): Client[] | Observable<Client[]> | Promise<Client[]> {
    return this.clientService.getClientList();
  }

}
