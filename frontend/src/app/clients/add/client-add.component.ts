import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { map, Observable, startWith } from 'rxjs';
import { cities } from 'src/app/utils/colombianCities';
import { City, Client, Occupation, ResponseBody } from 'src/app/utils/types';
import { ClientService } from '../client.service';

@Component({
  selector: 'app-client-add',
  templateUrl: './client-add.component.html',
  styleUrls: ['./client-add.component.scss'],
})
export class ClientAddComponent implements OnInit {
  profileForm = new FormGroup({
    documentNumber: new FormControl('', [Validators.required]),
    documentType: new FormControl('', [Validators.required]),
    firstname: new FormControl('', [Validators.required]),
    lastname: new FormControl('', [Validators.required]),
    city: new FormControl('', [Validators.required]),
    birthday: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required, Validators.email]),
    phoneNumber: new FormControl('', [Validators.required]),
    occupation: new FormControl('', [Validators.required]),
  });
  occupations: Occupation[] = [
    Occupation.EMPLEADO,
    Occupation.INDEPENDIENTE,
    Occupation.PENSIONADO,
  ];
  citiesGroup: City[] = cities;
  citiesGroupOption!: Observable<City[]>;
  occupationsGroupOption!: Observable<Occupation[]>;

  constructor(private fb: FormBuilder, private clientService: ClientService, private router: Router) {}

  ngOnInit(): void {
    this.citiesGroupOption = this.profileForm.get('city')!.valueChanges.pipe(
      startWith(''),
      map((value) => this.filterGroup(value || ''))
    ) as Observable<City[]>;
    this.occupationsGroupOption = this.profileForm
      .get('occupation')!
      .valueChanges.pipe(
        startWith(''),
        map((value) => this.filter(value || ''))
      ) as Observable<Occupation[]>;
  }

  private filterGroup(searchedCity: string): City[] | Occupation[] {
    if (searchedCity) {
      return this.citiesGroup
        .map((group) => ({
          id: group.id,
          departamento: group.departamento,
          ciudades: this.filterCity(group.ciudades, searchedCity),
        }))
        .filter((group) => group.ciudades.length > 0);
    }

    return this.citiesGroup;
  }

  private filterCity(cities: string[], searchedCity: string) {
    const searchedCityLowerCase = searchedCity.toLowerCase();
    return cities.filter((city) =>
      city.toLowerCase().includes(searchedCityLowerCase)
    );
  }

  private filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.occupations.filter(option => option.toLowerCase().includes(filterValue));
  }

  onSubmit() {
    this.clientService
      .saveClient(this.profileForm.value as Client)
      .subscribe((data) => {
        const response = data as ResponseBody
        if (response.statusCode > 200) {
          this.router.navigate(['/clients'])
          this.profileForm.reset();
        }
      });
  }
}
