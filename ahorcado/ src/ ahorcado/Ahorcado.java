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
    public static void mostrarPalabraParcialYFallos(char[] palabraParcial, int fallos) {
		// Aqui comienza
		for (int i = 0; i < palabraParcial.length; i++) {
			System.out.print(palabraParcial[i] + " ");
		}
		System.out.println();
		// Aqui termina
		System.out.println("Numero Fallos " + fallos);
	}

	/
	 * examina si la palabra parcial ha sido completada, retornando un valor
	 * boolean que confirma o desmiente este evento
	 * 
	 * @param parcial
	 * @return
	 */
	public static boolean comprobarPalabraCompletada(char[] parcial) {
		boolean completada = true;
		for (int i = 0; i < parcial.length && completada; i++) {
			if (parcial[i] == '_')
				completada = false;
		}
		return completada;
	}

	public static int incrementarFallo(int numeroFallos) {
		// Aqui comienza
		int nuevosFallos = numeroFallos + 1;
		// Aqui termina
		return nuevosFallos;
	}

	/
	 * cuenta con la palabra secreta y la letra actual y además con otro vector
	 * de letras llamado parcial, de igual tamaño que palabra, que comienza
	 * lleno de '_'. Estos '_' serán sustituidos por las letras que vamos
	 * adivinando. Retorna este vector de aciertos junto con una respuesta
	 * booleana que nos dice si la letra actual se encontraba en la palabra
	 * secreta o no.
	 * 
	 * @param palabra
	 * @param parcial
	 * @param letra
	 * @return
	 */
