import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class PersonaService{
    public url : string;
    constructor(
        public _http : HttpClient
    ){
        this.url = "http://localhost:8080/AppTest/";
    }

    busquedaPersona(nombre, tipo){    
        let headers = new HttpHeaders().set('Content-Type', 'application/json');
        return this._http.get(this.url+'listaPersonas?nombre='+nombre+'&tipoDocumento='+tipo);
    }

    crearPersona(persona): Observable<any>{
        let params = JSON.stringify(persona);
        let headers = new HttpHeaders().set('Content-Type', 'application/json');
        return this._http.post(this.url+'personas', params, {headers:headers});
    }

    eliminarPersona(id){
        return this._http.delete(this.url+'personas/'+ id);
    }

    editarPersona(id, persona){
        let params = JSON.stringify(persona);
        let headers = new HttpHeaders().set('Content-Type', 'application/json');
        return this._http.put(this.url+'personas/'+id, params, {headers:headers});
    }

    getPersonas(){
        return this._http.get(this.url +'personas');
    }

    getPersona(id){
        return this._http.get(this.url +'personas/'+id);
    }

    
}