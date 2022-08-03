export type Client = {
  documentNumber: string;
  documentType: DocumentType;
  firstname: string;
  lastname: string;
  birthday: string;
  city: string;
  email: string;
  phoneNumber: string;
  occupation: Occupation;
  viable: boolean;
}

export enum DocumentType {
  CC = 'Cedula de Ciudadania',
  TI = 'Tarjeta de Identidad',
  PA = 'Pasaporte',
  CE = 'Cedula de Extranjeria',
}

export enum Occupation {
  INDEPENDIENTE = 'Independiente',
  EMPLEADO = 'Empleado',
  PENSIONADO = 'Pensionado',
}

export type City = {
  id: number
  departamento: string
  ciudades: string[]
}

export type ResponseBody = {
  message: string
  statusCode: number
  body: Client | Client[] | null
}
