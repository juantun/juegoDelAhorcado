package ahorcado;

import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) {
        char secreta[] = pedirPalabraSecreta();
        char parcial[] = new char[secreta.length];
        crearPalabraParcial(parcial);
        int numeroFallos = 0;
        boolean acertado = false;
        do {
            char letra = pedirLetra();
            if (!comprobarLetraPalabra(secreta, parcial, letra)) {
                numeroFallos = incrementarFallo(numeroFallos);
            } else {
                acertado = comprobarPalabraCompletada(parcial);
            }
            mostrarPalabraParcialYFallos(parcial, numeroFallos);
        } while (numeroFallos < 6 && !acertado);
        if (acertado)
            System.out.println("enhorabuena");
        else
            System.out.println("has perdido");
    }

    private static void crearPalabraParcial(char[] parcial) {
        for (int i = 0; i < parcial.length; i++) {
            parcial[i] = '_';
        }
    }
