package combinatoria;

public class Permutador {
	private int fact;
	private int cuenta;
	private int[] vector;
	
	public Permutador(int[] vec) {
		vector = vec;
		cuenta = 0;
	}
	
	// genera una nueva permutación del vector
	// retorna true si aún quedan permutaciones
	// o false si las ha generado todas 
	public boolean permutar() {
		return permutar(0, vector.length);
	}
	
	boolean permutar(int inicio, int tam) {
		if(tam > 1) {
			if(!permutar(inicio + 1, tam - 1)) {
				rotar(inicio);
			}
			fact *= tam;
		} else {
			cuenta++;
			fact = 1;
		}
		
		return cuenta % fact != 0;
	}
	
	void rotar(int inicio) {
		int i, primero;

		primero = vector[inicio];

		for(i = inicio + 1; i < vector.length; i++) {
			vector[i-1] = vector[i];
		}

		vector[i-1] = primero;
	}

}
