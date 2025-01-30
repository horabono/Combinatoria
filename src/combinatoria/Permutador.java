package combinatoria;

import java.util.ArrayList;
import java.util.List;

public class Permutador implements IOperacion {
	private final int[] vector;
	private List<int[]> lista = null;
	private int cuenta;
	private int fact;
	
	public Permutador(int[] vec) {
		vector = vec;
		cuenta = 0;
	}
	
	@Override
	public void ejecutar() {
		lista = new ArrayList<>();
		do {
			lista.add(vector.clone());
		} while(permutar());
	}

	@Override
	public void ordenar() {
		if(lista != null) {
			boolean hayCambio;
			int tam = lista.size();
			do {
				hayCambio = false;
				for(int i = 1; i < tam; i++) {
					if(comparar(lista.get(i-1), lista.get(i)) > 0) {
						int[] x = lista.get(i);
						lista.set(i, lista.get(i-1));
						lista.set(i-1, x);
						hayCambio = true;
					}
				}
				tam--;
			} while(hayCambio);
		}
	}
	
	@Override
	public List<int[]> getResultado() {
		return lista;
	}
	
	// genera una nueva permutación del vector
	// retorna true si aún quedan permutaciones
	// o false si las ha generado todas 
	public boolean permutar() {
		return permutar(0, vector.length);
	}
	
	private boolean permutar(int inicio, int tam) {
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
	
	private void rotar(int inicio) {
		int i, primero;
		primero = vector[inicio];
		for(i = inicio + 1; i < vector.length; i++) {
			vector[i-1] = vector[i];
		}
		vector[i-1] = primero;
	}
		
	// p.length == q.length
	protected int comparar(int p[], int q[]) {
		int dif = 0;
		for(int i = 0; i < p.length && dif == 0; i++) {
			dif = p[i] - q[i];
		}
		return dif;
	}

}
