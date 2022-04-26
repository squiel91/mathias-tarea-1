import java.util.Scanner;
import java.util.ArrayList;

public class Hola { // llamalo Agenda por lo menos....
	static ArrayList<Contacto> contactos = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	private static Integer numeroo() { // esto seria el
		int number = 0;
		System.out.println("Ingresa su numero:");
		try {
			number = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			try {
				System.out.println("Ingrese su numero:");
				number = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException a) {
				if (number > 1)	{
				numeroo();}
			}
		}
		return number;
	}

	private static String mailVerficator(Scanner sc) {
		String mail;
    // aca deberia ir un while
    do {
      System.out.println("Ingresa su mail(o presiona enter si no lo sabes):");
      mail = sc.nextLine();
    } while (!mail.isEmpty() && !mailIsValid(mail)); // supongo que defini esa funcion arriba mailIsValid 
      
		return mail;
	}

	static void Coso() {
		System.out.println("|--------------------------------------------------------------------------|");
		System.out.println("|¿Quieres [i]ingresar nuevo contacto o [c]consultar un contacto existente? |");
		System.out.println("|--------------------------------------------------------------------------|");
		String option = sc.nextLine();
		String name = null;
		int result;
		String mail;
		switch (option) {
    // un truquito que vi que hacia Facu y funciona...
    case "I":
    case "i":
			do {
				System.out.println("Ingresa el nombre:");
				name = sc.nextLine();
			} while (name.length() < 1); // o !name.isEmpty()
			do {
				result = numeroo();
			} while (result < 1);
			mail = mailVerficator();
			contactos.add(new Contacto(name, result, mail)); // hermoso
			// No estas usando cantidad de contactos. 
      // Y en cualquier caso que lo necesites usar podes usar contactos.size()
			Coso();
			break;
		case "C":
		case "c":
			System.out.println("Ingresa el nombre del contacto que quieres consultar");
			String consultName = sc.nextLine();
			for (int i = 0; i < contactos.size(); i++) {
				Contacto contact = contactos.get(i);
				if (contact.getNombre().equals(consultName)) {
					System.out.println("Nombre: " +contact.getNombre());
					System.out.println("Numero: " +contact.getNumber());
					System.out.println("Mail: " +contact.getMail());
				} 
			}
			Coso();
			break;
		default:
			System.out.println("Por favor ingrese (i) o (c)");
			Coso();
			break;
		}
	}

	public static void main(String[] args) {
    // Te falta una pieza clave que es el while true. Solo podes ejecutar una accion y se cierra el programa.
    while (true) {
      // en vez de hacer una funcion Coso y llamarla de main
      // deberias no tener coso y copiar el codigo adentro del main
      Coso(); 
    }
	}

}

class Contacto {
	private String nombre, mail;
	private int number; // Usaria un string para el numero "09812345" o "+598 (532) 123-567"

  // bien que usaste el contrructor!
	public Contacto(String nombre, int number, String mail) {
    // en este caso super no tiene sentido usarlo xq no hereda de ninguna otra clase.
		this.nombre = nombre;
		this.number = number; // espaniol o ingles??
		this.mail = mail;
	}

	public void presentarse() {
		System.out.println("¡Contacto " + this.nombre + " ingresado!");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getMail() {
		return mail;
	}

	public void setMail() {
		this.mail = mail;
	}

  public void presentYourself () {
    System.out.println("Nombre: " + nombre + " Numero: " + number + " Mail: " + mail);
  }

}
