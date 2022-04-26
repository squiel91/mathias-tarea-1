import java.util.Scanner;
import java.util.ArrayList;

public class Hola {
	static ArrayList<Contacto> contactos = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	private static Integer numeroo() {
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

	private static String mailVerficator() {
		String mail;
		System.out.println("Ingresa su mail(o presiona enter si no lo sabes):");
		mail = sc.nextLine();
		if (mail != "" && mail.contains("@") && mail.contains(".") || mail == "")
		{
		} else {
			System.out.println("Ingresa un mail verdadero");
			mail = sc.nextLine();
			if (mail != "" && mail.contains("@") && mail.contains(".") || mail == "")
			{}else {
				mailVerficator();
			}
		}
		return mail;
	}

	static void Coso() {
		int cantContactos = 0;
		System.out.println("|--------------------------------------------------------------------------|");
		System.out.println("|¿Quieres [i]ingresar nuevo contacto o [c]consultar un contacto existente? |");
		System.out.println("|--------------------------------------------------------------------------|");
		String option = sc.nextLine();
		String name = null;
		int result;
		String mail;
		switch (option) {
		case "i":
			do {
				System.out.println("Ingresa el nombre:");
				name = sc.nextLine();
			} while (name.length() < 1);
			do {
				result = numeroo();
			} while (result < 1);
			mail = mailVerficator();
			contactos.add(new Contacto(name, result, mail));
			cantContactos = cantContactos + 1;
			Coso();
			break;
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
		Coso();
	}

}

class Contacto {
	private String nombre, mail;
	private int number;

	public Contacto(String nombre, int number, String mail) {
		super();
		this.nombre = nombre;
		this.number = number;
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

	public void setNumber() {
		this.number = number;
	}

	public String getMail() {
		return mail;
	}

	public void setMail() {
		this.mail = mail;
	}

}
