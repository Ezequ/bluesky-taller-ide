package main.model.instrucciones;

import main.model.instrucciones.factorys.*;
import main.model.instrucciones.tipos.Instruccion;

/**
 * Created by Juan-Asus on 21/03/2014.
 */
public class FabricaInstrucciones {


    public Instruccion crearInstruccion(String lineaCodigo){
        ValidadorFormatoInstrucciones validadorFormatoInstrucciones = new ValidadorFormatoInstrucciones(lineaCodigo);

        if (!validadorFormatoInstrucciones.esLineaValida()) return null;

        char codigoOp = validadorFormatoInstrucciones.obtenerCodigoOp();
        String posMemoria = validadorFormatoInstrucciones.obtenerPosMemoria();
        String comentario = validadorFormatoInstrucciones.obtenerComentario();
        String lineaInst = validadorFormatoInstrucciones.obtenerPorcionInstruccion();

        CreadorInstruccion creadorInstruccion = obtenerCreadorInstruccionSCodigoOP(codigoOp);
        return creadorInstruccion.factoryMethod(posMemoria,lineaInst,comentario);
    }

    public CreadorInstruccion obtenerCreadorInstruccionSCodigoOP(char codigoOp) {
        switch (codigoOp){
            case '1':
                return new CreadorInstruccionCargarMemoria();
            case '2':
                return new CreadorInstruccionCargarInmediato();
            case '3':
                return new CreadorInstruccionAlmacenar();
            case '4':
                return new CreadorInstruccionCopiar();
            case '5':
                return new CreadorInstruccionSumarA2();
            case '6':
                return new CreadorInstruccionSumarPF();
            case '7':
                return new CreadorInstruccionOR();
            case '8':
                return new CreadorInstruccionAND();
            case '9':
                return new CreadorInstruccionXOR();
            case 'A':
            case 'a':
                return new CreadorInstruccionRotar();
            case 'B':
            case 'b':
                return new CreadorInstruccionSaltar();
            case 'C':
            case 'c':
                return new CreadorInstruccionParar();
            default: return null;

        }
    }

}
