package combinatoria;

import java.util.ArrayList;

public class Particion implements Cloneable, Comparable<Particion> {
	public final ArrayList<Integer> partes;
	public int numero;
	
	private Particion() {
		partes = new ArrayList<>();
	}
	
	Particion(int num) {
		this();
		numero = num;
		partes.add(num);
	}
	
	void extender() {
		partes.add(0, partes.remove(0)-1);
		partes.add(1);
	}
	
	void agrupar(int i) {
		int val = partes.get(i) + partes.get(i+1);
		partes.remove(i+1);
		partes.remove(i);
		partes.add(i, val);
	}
	
	int get(int i) {
		return i < partes.size()? partes.get(i) : 0;
	}
	
	@Override
	protected Particion clone() {
		Particion nueva = new Particion();
		nueva.numero = numero;
		for(int i : partes) {
			nueva.partes.add(i);
		}
		return nueva;
	}
	
	public int size() {
		return partes.size();
	}
	
	public int[] toArray() {
		return toArray(partes.size());
	}
	
	public int[] toArray(int tam) {
		int[] vec = new int[tam];
		int i = 0;
		while(i < tam && i < partes.size()) {
			vec[i] = partes.get(i);
			i++;
		}
		while(i < tam) {
			vec[i++] = 0;
		}
		return vec;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(int i : partes) {
			sb.append(" " + i);
		}
		return sb.toString();
	}

	@Override
	public int compareTo(Particion otra) {
		int lim = size() < otra.size() ? size() : otra.size();
		int i = 0;
		int dif = get(i) - otra.get(i);
		while(dif == 0 && ++i < lim) {
			dif = get(i) - otra.get(i);
		}
		return dif;
	}
}
