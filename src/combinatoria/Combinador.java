package combinatoria;

import java.util.ArrayList;

public class Combinador {
	
	public static ArrayList<int[]> combinar(int[] vec, int tam) {
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
					ordenar(sub);
					for(j = 0; j < lista.size() && !igual(sub, lista.get(j)); j++);
					
					if(j == lista.size()) {
						lista.add(sub.clone());
					}
				}
				
			} while(p.permutar());
		}
		
		return lista;
	}
	
	static boolean igual(int[] p, int[] q) {
		int i;

		for(i = 0; i < p.length && p[i] == q[i]; i++);
		
		return i == p.length;
	}
	
	static void ordenar(int[] v) {
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
