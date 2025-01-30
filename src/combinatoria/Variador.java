package combinatoria;

import java.util.ArrayList;
import java.util.List;

public class Variador implements IOperacion {
	protected List<int[]> lista = null;
	protected final int[] vec; 
	protected final int tam;
	
	public Variador(int[] vec, int tam) {
		this.vec = vec;
		this.tam = tam;
		ejecutar();
	}
	
	@Override
	public void ejecutar() {
		lista = variar(vec, tam);
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
	
	// p.length == q.length
	protected int comparar(int p[], int q[]) {
		int dif = 0;
		for(int i = 0; i < p.length && dif == 0; i++) {
			dif = p[i] - q[i];
		}
		return dif;
	}
	
	// Métodos estáticos

	public static List<int[]> variar(int[] vec, int tam) {
		ArrayList<int[]> lista = null;

		if(tam > 0 && tam <= vec.length) {
			lista = new ArrayList<>();
			Permutador p = new Permutador(vec);
			int[] sub = new int[tam];
			do {
				for(int i = tam-1; i < vec.length; i++) {
					int j = i;
					int k = tam;
					while(k > 0) {
						sub[--k] = vec[j--];
					}
					j = lista.size();
					while(--j >= 0 && !igual(sub, lista.get(j)));
					if(j < 0) {
						lista.add(sub.clone());
					}
				}
			} while(p.permutar());
		}
		
		return lista;
	}
	
	// p.length == q.length
	protected static boolean igual(int[] p, int[] q) {
		int i = p.length;
		while(--i >= 0 && p[i] == q[i]);
		return i < 0;
	}
}
