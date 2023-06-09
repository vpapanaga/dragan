package md.papanaga.usm.tap.laborator3.exception;

import com.sun.corba.se.spi.orbutil.fsm.Input;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class SteaException extends Throwable {
    Exception exception;

    public void printStackTrace() {

        if (exception instanceof FileNotFoundException) {
            System.out.println("Fisierul mentionat nu a  foat gasit!");
        } else if (exception instanceof InputMismatchException) {
            System.out.println("S-au introdus date incorecte de la tastatura!");
        }
        else {
            exception.printStackTrace();
        }

    }

    public SteaException(Exception exception) {
        this.exception  = exception;
    }
}
