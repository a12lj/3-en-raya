package MATE2025PROYECTO;
import java.util.Scanner;
public class MATEPROYECTO {
	
	   public static void main(String[] args) {
	        inicializarTablero();
	        jugar();
	    }

	
		 private static final char VACIO = '-';
		    private static final char JUGADOR_X = 'X';
		    private static final char JUGADOR_O = 'O';
		    private static char[][] tablero = new char[3][3];// Matriz para el tablero de 3x3

		   
		    // Método para inicializar el tablero con casillas vacías
		    private static void inicializarTablero() {
		        for (int i = 0; i < 3; i++) {
		            for (int j = 0; j < 3; j++) {
		                tablero[i][j] = VACIO;
		            }
		        }
		    }
		    // Método principal que controla el flujo del juego
		    private static void jugar() {
		        Scanner sc = new Scanner(System.in);
		        char turno = JUGADOR_X;
		        boolean juegoTerminado = false;

		        while (!juegoTerminado) {
		            imprimirTablero();
		            System.out.println("Turno del jugador " + turno + ". Elige fila y columna (0, 1 o 2):");
		            int fila = sc.nextInt();
		            int columna = sc.nextInt();

		            if (esMovimientoValido(fila, columna)) {
		                tablero[fila][columna] = turno;
		                if (hayGanador(turno)) {
		                    imprimirTablero();
		                    System.out.println("¡El jugador " + turno + " ha ganado!");
		                    juegoTerminado = true;
		                } else if (tableroLleno()) {
		                    imprimirTablero();
		                    System.out.println("¡Es un empate!");
		                    juegoTerminado = true;
		                } else {
		                    turno = (turno == JUGADOR_X) ? JUGADOR_O : JUGADOR_X;
		                }
		            } else {
		                System.out.println("Movimiento inválido. Intenta de nuevo.");
		            }
		        }
		    }

		            // Método para imprimir el tablero en consola
		    private static void imprimirTablero() {
		        for (int i = 0; i < 3; i++) {
		            for (int j = 0; j < 3; j++) {
		                System.out.print(tablero[i][j] + " ");
		            }
		            System.out.println();
		        }
		    }

		    private static boolean esMovimientoValido(int fila, int columna) {
		        return fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == VACIO;
		    }

		    private static boolean hayGanador(char jugador) {
		        // Verificar filas
		        for (int i = 0; i < 3; i++) {
		            if (tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) {
		                return true;
		            }
		        }

		        // Verificar columnas
		        for (int j = 0; j < 3; j++) {
		            if (tablero[0][j] == jugador && tablero[1][j] == jugador && tablero[2][j] == jugador) {
		                return true;
		            }
		        }

		        // Verificar diagonales
		        if (tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) {
		            return true;
		        }
		        if (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador) {
		            return true;
		        }

		        return false;
		    }

		    private static boolean tableroLleno() {
		        for (int i = 0; i < 3; i++) {
		            for (int j = 0; j < 3; j++) {
		                if (tablero[i][j] == VACIO) {
		                    return false;
		                }
		            }
		        }
		        return true;
		    }
	}