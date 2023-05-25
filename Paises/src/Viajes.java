


import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Viajes {
	public void iniciar() {
		String menu="GESTION ESTUDIANTES\n";
		menu+="1. Registrar país\n";
		menu+="2. Registrar ciudades\n";
		menu+="3. Consultar ciudades por país\n";
		menu+="4. Consultar ciudad\n";
		menu+="5. Salir\n";
		menu+="Ingrese una opción:\n";

		int opc=0;
		do {
			opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			validarMenu(opc);
			
		} while (opc!=5);
	}
	HashMap<String, ArrayList<String>> paisesYCiudades = new HashMap<String, ArrayList<String>>();
	
	public void validarMenu(int opc) {
		
		switch (opc) {
		case 1:
			 añadirPais();
			 break;
		case 2:
			añadirCiudad();
		 	break;
		case 3:
			consultarCiudadesPorPais();
		 	break;
		case 4:
			consultarCiudad();
			break;
		case 5:
			System.out.println("Chao!");
			break;
		
		default:
			System.out.println("Ingrese una opción válida");
			break;
		}
	
	}
	public void añadirPais() {
		String pais = JOptionPane.showInputDialog("Ingrese el nombre del país");
		ArrayList<String> ciudades = new ArrayList<String>();
		paisesYCiudades.put(pais, ciudades);
		System.out.println(paisesYCiudades);
	}
	
	public void añadirCiudad() {
		int valid;
		String pais = JOptionPane.showInputDialog("Ingrese el país donde desea registrar la ciudad");
		if(paisesYCiudades.containsKey(pais)) {
			String ciudad = JOptionPane.showInputDialog("Ingrese el nombre de la ciudad");
			paisesYCiudades.get(pais).add(ciudad);
			
		}else {
			JOptionPane.showMessageDialog(null, "El país no se encuentra registrado");
			valid = JOptionPane.showConfirmDialog(null, "¿Desea registrar el país?");
			if(valid == 0) {
				añadirPais();
			}else {
				añadirCiudad();
			}
		}
		System.out.println(paisesYCiudades);
		
	}
	
	public void consultarCiudadesPorPais(){
		int valid;
		String pais = JOptionPane.showInputDialog("Ingrese el país donde desea consultar las ciudades");
		if(paisesYCiudades.containsKey(pais)) {
			System.out.println("Ciudades de "+ pais + ":");
			 for (int i = 0; i < paisesYCiudades.get(pais).size(); i++) {
				System.out.println(paisesYCiudades.get(pais).get(i));
			}
		}else {
			JOptionPane.showMessageDialog(null, "El país no se encuentra registrado");
			valid = JOptionPane.showConfirmDialog(null, "¿Desea registrar el país?");
			if(valid == 0) {
				añadirPais();
			}else {
				añadirCiudad();
			}
		}
	}
	
	public void consultarCiudad() {
	    String ciudad = JOptionPane.showInputDialog("Ingrese el nombre de la ciudad que desea consultar");
	    boolean encontrado = false;
	    for (String pais : paisesYCiudades.keySet()) {
	        if (paisesYCiudades.get(pais).contains(ciudad)) {
	            System.out.println(ciudad + " pertenece a " + pais);
	            encontrado = true;
	        }
	    }
	    if (!encontrado) {
	        System.out.println(ciudad + " no se encuentra registrada en ningún país");
	    }
	}
}

