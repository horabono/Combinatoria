package combinatoria;

import java.util.ArrayList;
import java.util.List;

public class Partidor implements IOperacion {
	public final List<Particion> particiones = new ArrayList<Particion>();
	public final int numero;

	public Partidor(int num) {
		this.numero = num;
		ejecutar();
	}
	
	@Override
	public void ejecutar() {
		particiones.add(new Particion(numero));
		extender(0);		
	}
	
	@Override
	public void ordenar() {
		boolean hayCambio;
		int tam = particiones.size();
		do {
			hayCambio = false;
			Particion p = particiones.get(0);
			for(int i = 1; i  < tam; i++) {
				Particion q = particiones.get(i);
				if(p.compareTo(q) < 0) {
					particiones.set(i-1, q);
					particiones.set(i, p);
					hayCambio = true;
				} else {
					p = q;
				}
			}
			tam--;
		} while(hayCambio);
	}
	
	@Override
	public List<int[]> getResultado() {
		List<int[]> lista = new ArrayList<>();
		for(Particion particion : particiones) {
			lista.add(particion.toArray());
		}
		return lista;
	}
	
	private void extender(int i) {
		Particion par = particiones.get(i);
		if(par.get(0) > 1) {
			Particion nueva = par.clone();
			nueva.extender();
			particiones.add(nueva);
			extender(i+1);
		} else {
			agrupar(0, 1);
		}
	}
	
	private void agrupar(int i, int pos) {
		Particion par = particiones.get(i);
		if(pos < par.size() - 1) {
			int anterior = par.get(pos-1);
			int nuevo = par.get(pos) + par.get(pos+1);
			if(nuevo <= anterior) {
				Particion nueva = par.clone();
				nueva.agrupar(pos);
				particiones.add(nueva);
			}
		}
		if(++i < particiones.size()) {
			agrupar(i, pos);
		} else if(++pos < numero-2) {
			agrupar(0, pos);
		}
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		int j = 0;
		for(Particion p : particiones) {
			sb.append(String.format("\n[%2d] ", ++j) + p);
		}
	
		return sb.toString() + "\n";
	}
	
	public static List<int[]> partir(int num) {
		List<Particion> particiones = new Partidor(num).particiones;
		List<int[]> lista = new ArrayList<>();
		for(Particion p : particiones) {
			lista.add(p.toArray());
		}
		return lista;
	}

}
