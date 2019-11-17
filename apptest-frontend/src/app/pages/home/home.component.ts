import { Component, OnInit } from '@angular/core';
import { PersonaService } from '../../services/persona.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [ PersonaService ]
})
export class HomeComponent implements OnInit {

  public busquedaForm: FormGroup;
  displayedColumns: string[] = ['id', 'apellido', 'nombre','fechaNacimiento', 'tipo','numero', 'action'];
  dataSource: any;

  constructor(
    private _personaService: PersonaService
  ){}  

  ngOnInit() {
    this._personaService.getPersonas().subscribe(
      result => {
        this.dataSource = result;        
      },
      error => {
        console.log(<any> error);
      }
    );

    this.busquedaForm = new FormGroup({
      nombre: new FormControl('', [Validators.required]),
      tipoDocumento: new FormControl('', [Validators.required])      
    });
  }  

  public hasError = (controlName: string, errorName: string) =>{
    return this.busquedaForm.controls[controlName].hasError(errorName);
  }

  onSubmit = (formValue) => {
    if(this.busquedaForm.valid){
      let nombre = this.busquedaForm.controls.nombre.value;
      let tipo = this.busquedaForm.controls.tipoDocumento.value;
      this._personaService.busquedaPersona(nombre, tipo).subscribe(
        result => {
          this.dataSource = result;          
        },
        error => {
          console.log(<any> error);
        }
      );
    }

  }

  eliminarPersona = (id) =>{
        
    this._personaService.eliminarPersona(id).subscribe(
      result => {        
        console.log(result);
      },
      error => {
        console.log(<any> error);
      }
    );
  }

}