import { Component, OnInit } from '@angular/core';
import { PersonaService } from '../../services/persona.service'
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { Router,ActivatedRoute, Params } from '@angular/router';

export interface Item {
  value: string;
  display: string;
}

@Component({
  selector: 'app-persona',
  templateUrl: './persona.component.html',
  styleUrls: ['./persona.component.css'],
  providers: [ PersonaService ,DatePipe]
})
export class PersonaComponent implements OnInit {

  public personaForm: FormGroup;
  public idPersona: any;
  public editable: boolean;
  public titulo: String;
  itemsTipo: Item[] = [
    {value: 'DNI', display: 'DNI'},
    {value: 'PASAPORTE', display: 'PASAPORTE'},
    {value: 'CEDULA', display: 'CEDULA'}
  ];

  constructor(
    private _personaService: PersonaService,
    private datePipe: DatePipe,
    private _route: ActivatedRoute,
    private _router: Router

  ) { 
    this.editable = false;
    this.titulo = "Crear Persona";
  }

  ngOnInit() {
    this.personaForm = new FormGroup({
      nombre: new FormControl('', [Validators.required]),
      apellido: new FormControl('', [Validators.required]),
      fechaNacimiento: new FormControl('',[Validators.required]),
      tipoDocumento: new FormControl('', [Validators.required]),
      nroDocumento: new FormControl('', [Validators.required])
    });
    this._route.params.subscribe((params: Params) => {
      this.idPersona = params.id
      if(this.idPersona){
        this.rellenarForm(this.idPersona);
      }
    })

  }

  public hasError = (controlName: string, errorName: string) =>{
    return this.personaForm.controls[controlName].hasError(errorName);
  }

  public onSubmit = (formValue) => {
    if (this.personaForm.valid) {
      if(this.editable){        
        this.editarPersona(this.idPersona, formValue);
      }else{
        this.crearPersona(formValue);
      }
    }
  }

  public crearPersona = (formValue) => {    

    const body = this.personaForm.controls;    
    //body.fechaNacimiento.setValue(this.datePipe.transform(body.fechaNacimiento.value,'dd/MM/yyyy'));
    //body.controls.fechaNacimiento = this.datePipe.transform(body.controls.fechaNacimiento, 'yyyy-MM-dd');
    this._personaService.crearPersona(formValue).subscribe(
      response => {
        console.log(response);
        //form.reset();
        //this.usuario_guardado = response;
        this._router.navigate(['home']);
      },
      error => {
        console.log(<any>error);
      }
    )
  }

  public editarPersona = (id, formValue) => {
    this._personaService.editarPersona(id, formValue).subscribe(
      response => {        
        //form.reset();
        //this.usuario_guardado = response;
        this._router.navigate(['home']);
      },
      error => {
        console.log(<any>error);
      }
    );
  }

  public rellenarForm(id){

    this._personaService.getPersona(id).subscribe(
      response => {
        this.editable = true;
        this.titulo = "Editar Persona";
        let body = this.personaForm.controls;
        let date = Object.values(response)[1].split("/");
        //07111085
        body.fechaNacimiento.setValue(new Date(+date[2], date[1] - 1, +date[0]));
        body.nombre.setValue(Object.values(response)[3].toString());
        body.apellido.setValue(Object.values(response)[2].toString());        
        body.tipoDocumento.setValue(Object.values(response)[4].toString());
        body.nroDocumento.setValue(Object.values(response)[5].toString());                
      },
      error => {
        console.log(<any>error);
      }
    )
  }

}