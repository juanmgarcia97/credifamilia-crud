import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { faCircleCheck, faCircleXmark, faTrash } from '@fortawesome/free-solid-svg-icons';
import { Client, DocumentType, Occupation } from 'src/app/utils/types';
import { ClientService } from '../client.service';

// const mockData: Client[] = [
//   {
//     documentNumber: '1143873318',
//     documentType: DocumentType.CC,
//     firstname: 'Juan Martin',
//     lastname: 'Garcia',
//     birthday: new Date('1997-09-17').toUTCString(),
//     city: 'Cali',
//     email: 'juanmar-p@hotmail.com',
//     phoneNumber: '3174382620',
//     occupation: Occupation.EMPLEADO,
//     viable: true,
//   },
//   {
//     documentNumber: '1143873318',
//     documentType: DocumentType.CC,
//     firstname: 'Juan Martin',
//     lastname: 'Garcia',
//     birthday: new Date('1997-09-17').toISOString(),
//     city: 'Cali',
//     email: 'juanmar-p@hotmail.com',
//     phoneNumber: '3174382620',
//     occupation: Occupation.EMPLEADO,
//     viable: true,
//   },
//   {
//     documentNumber: '1143873318',
//     documentType: DocumentType.CC,
//     firstname: 'Juan Martin',
//     lastname: 'Garcia',
//     birthday: new Date('1997-09-17').toDateString(),
//     city: 'Cali',
//     email: 'juanmar-p@hotmail.com',
//     phoneNumber: '3174382620',
//     occupation: Occupation.EMPLEADO,
//     viable: true,
//   },
//   {
//     documentNumber: '1143873318',
//     documentType: DocumentType.CC,
//     firstname: 'Juan Martin',
//     lastname: 'Garcia',
//     birthday: new Date('1997-09-17').toDateString(),
//     city: 'Cali',
//     email: 'juanmar-p@hotmail.com',
//     phoneNumber: '3174382620',
//     occupation: Occupation.EMPLEADO,
//     viable: false,
//   },
// ];

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.scss'],
})
export class ClientListComponent implements OnInit {
  displayedColumns: string[] = [
    'documentNumber',
    'documentType',
    'firstName',
    'lastName',
    'birthday',
    'email',
    'city',
    'phoneNumber',
    'occupation',
    'viable',
    'actions'
  ];
  columnsToDisplay: string[] = this.displayedColumns.slice();
  data: Client[] = [];
  viableIcon = faCircleCheck;
  notViableIcon = faCircleXmark;
  deleteIcon = faTrash;

  constructor(private route: ActivatedRoute, private clientService: ClientService) {}

  ngOnInit() {
    this.route.data.subscribe((data) => {
      this.data = data['clients'];
    });
  }

  deleteClient(document: string) {
    this.clientService.deleteClient(document).subscribe(data => {
      console.log(data);
    })
  }
}
