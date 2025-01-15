package combinatoria;

import java.util.ArrayList;

public class Variador {

	public static ArrayList<int[]> variar(int[] vec, int tam) {
		ArrayList<int[]> lista = new ArrayList<>();

		if(tam > 0 && tam <= vec.length) {
			Permutador p = new Permutador(vec);
			int[] sub = new int[tam];
			
			do {
				for(int i = tam-1; i < vec.length; i++) {
					int j = i;
					int k = tam;
					while(k > 0) {
						sub[--k] = vec[j--];
					}
					
					for(j = 0; j < lista.size() && !igual(sub, lista.get(j)); j++);
					
					if(j == lista.size()) {
						lista.add(sub.clone());
					}
				}
				
			} while(p.permutar());
		}
		
		return lista;
	}
	
	// p.length == q.length
	static boolean igual(int[] p, int[] q) {
		int i;

		for(i = 0; i < p.length && p[i] == q[i]; i++);
		
		return i == p.length;
	}
}
