import { Component, OnInit } from '@angular/core';
import { PersonaService } from '../../services/persona.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material';
import { ConfirmacionDialogComponent } from 'src/app/components/confirmacion-dialog/confirmacion-dialog.component';

export interface Item {
  value: string;
  display: string;
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [ PersonaService ]
})
export class HomeComponent implements OnInit {

  public busquedaForm: FormGroup;
  displayedColumns: string[] = ['id', 'nombre', 'apellido', 'numero', 'tipo', 'fechaNacimiento', 'action'];
  dataSource: any;
  selectedValue: string; 
  itemsTipo: Item[] = [
    {value: 'DNI', display: 'DNI'},
    {value: 'PASAPORTE', display: 'PASAPORTE'},
    {value: 'CEDULA', display: 'CEDULA'}
  ];

  constructor(
    private _personaService: PersonaService,
    public dialog : MatDialog
  ){}  

  ngOnInit() {

    this.refresh();

    this.busquedaForm = new FormGroup({
      nombre: new FormControl('', [Validators.required]),
      tipoDocumento: new FormControl('', [Validators.required])      
    });
  }  

  public hasError = (controlName: string, errorName: string) =>{
    return this.busquedaForm.controls[controlName].hasError(errorName);
  }

  refresh = () => {
    this._personaService.getPersonas().subscribe(
      result => {
        this.dataSource = result;
        console.log(result)
      },
      error => {
        console.log(<any> error);
      }
    );
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
        this.refresh();
      },
      error => {
        console.log(<any> error);
      }
    );
  }

  openDialog(id): void {
    console.log(id);
    const dialogRef = this.dialog.open(ConfirmacionDialogComponent, {
      width: '350px',
      data: "Desea eliminar el registro?"
    });
    dialogRef.afterClosed().subscribe(result => {
      if(result) {        
        this.eliminarPersona(id);
      }
    });
  }
}