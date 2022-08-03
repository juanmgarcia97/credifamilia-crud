import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import {
  MatFormFieldModule,
  MAT_FORM_FIELD_DEFAULT_OPTIONS,
} from '@angular/material/form-field';
import { MatTableModule } from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { ClientListComponent } from './client-list/client-list.component';
import { ClientRoutingModule } from './client-routing.module';
import { ClientAddComponent } from './add/client-add.component';

const materialDeclarations = [
  MatFormFieldModule,
  MatInputModule,
  MatTableModule,
  MatButtonModule,
  MatAutocompleteModule,
];

@NgModule({
  declarations: [ClientListComponent, ClientAddComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    ClientRoutingModule,
    FontAwesomeModule,
    ...materialDeclarations,
  ],
  exports: [],
  providers: [
    {
      provide: MAT_FORM_FIELD_DEFAULT_OPTIONS,
      useValue: { appearance: 'fill' },
    },
  ],
})
export class ClientModule {}
