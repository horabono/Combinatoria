package combinatoria;

import java.util.ArrayList;
import java.util.List;

public class Combinador extends Variador {

	public Combinador(int[] vec, int tam) {
		super(vec, tam);
	}
	
	@Override
	public void ejecutar() {
		lista = combinar(vec, tam);
	}
	
	// Métodos estáticos
	
	public static List<int[]> combinar(int[] vec, int tam) {
		List<int[]> lista = null;

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
					ordenarSubarray(sub);
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
	
	private static void ordenarSubarray(int[] v) {
		boolean hayCambio;
		int t = v.length;
		do {
			hayCambio = false;
			for(int i = 1; i < t; i++) {
				if(v[i-1] > v[i]) {
					int x = v[i];
					v[i] = v[i-1];
					v[i-1] = x;
					hayCambio = true;
				}
			}
			t--;
		} while(hayCambio);
	}

}
