package guestList;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bun venit pe pagina Workshopului Devmind.");
			
		//atribute
		int noSeats;
		String command;
		String commandUpdate;
		String printCommandList = "help - Afiseaza aceasta lista de comenzi\n" +
			    "add - Adauga o noua persoana (inscriere)\n" +
				"check - Verifica daca o persoana este inscrisa la eveniment\n" +
				"remove - Sterge o persoana existenta din lista\n" + 
				"update - Actualizeaza detaliile unei persoane\n" + 
				"guests - Lista de persoane care participa la eveniment\n" + 
				"waitlist - Persoanele din lista de asteptare\n" + 
				"available - Numarul de locuri libere\n" + 
				"guests_no - Numarul de persoane care participa la eveniment\n" + 
				"waitlist_no - Numarul de persoane din lista de asteptare\n" + 
				"subscribe_no - Numarul total de persoane inscrise\n" + 
				"search - Cauta toti invitatii conform sirului de caractere introdus\n" + 
				"quit - Inchide aplicatia";
		
		System.out.println("introduceti numarul de locuri disponibile la evenimentul Cum sa incepi o cariera in IT");
		noSeats = sc.nextInt();
		
		GuestList guestList = new GuestList(noSeats);
		
		System.out.println("Acestea sunt comenzile disponibile pentru gestionarea participantilor \n " + printCommandList);
		
		System.out.println("introduceti comanda");
		
		command = sc.nextLine(); 
		
		while (!(command.equals("quit"))) {
			
			command = sc.nextLine(); 
			
			if(command.equals("help")) {
				System.out.println(printCommandList);
			}
			
			if(command.equals("add")) {	
				System.out.println("introduceti nume - metoda add");
				String guestName = sc.nextLine();
				System.out.println("introduceti prenume");
				String guestLastName = sc.nextLine();
				System.out.println("introduceti email");
				String email = sc.nextLine();
				System.out.println("introduceti numar de telefon");
				String phone = sc.nextLine();
				
				Guest g = new Guest(guestLastName, guestName, email, phone);
		
				guestList.addGuest(g);
				
				System.out.println("Introduceti noua comanda sau quit");
			}
			
			if(command.equals("remove")) {
				System.out.println("Cautare persoana in vederea stergerii");
				System.out.println("introduceti numele persoanei inscrise");
				String guestName = sc.nextLine();
				System.out.println("introduceti prenumele persoanei inscrise");
				String guestLastName = sc.nextLine();
				System.out.println("introduceti email");
				String email = sc.nextLine();
				System.out.println("introduceti numar de telefon");
				String phone = sc.nextLine();
				
				if((guestList.checkByName(guestLastName, guestName) == null) || ((guestList.checkByMail(email) == null)) || (guestList.checkByPhone(phone) == null)) {
					System.out.println("Persoana nu exista");
				}
				
				else {
					guestList.delete(guestList.checkByName(guestLastName, guestName));
					System.out.println("Persoana a fost stearsa - check by name");
				}
				
				System.out.println("Introduceti noua comanda sau quit");
			}
			
			if(command.equals("update")) {
				System.out.println("Cautare persoana in vederea stergerii");
				System.out.println("introduceti criteriul dupa care vrei sa cautati persoana\n"
						+ "- nume si prenume\n"
						+ "- email\n"
						+ "- telefon");
				commandUpdate = sc.nextLine();
				
				if(commandUpdate.equals("telefon")) {
					
					System.out.println("Introduceti numarul de telefon");
					String phone = sc.nextLine();
					
					System.out.println("Introduceti noul numar de telefon");
					String newPhone = sc.nextLine();
					
					if(guestList.checkByPhone(phone) != null) {
						guestList.checkByPhone(phone).setPhoneNumber(newPhone);
						System.out.println("Numarul de telefon a fost actualizat");
					} else {
						System.out.println("Persoana nu exista");
					}
				}
				
					
				
				if(commandUpdate.equals("email")) {
					
					System.out.println("Introduceti emailul actual");
					String email = sc.nextLine();
					
					System.out.println("introdu emailul nou");
					String newEmail = sc.nextLine();
					
					if(guestList.checkByMail(email) != null) {
						guestList.checkByMail(email).setEmail(newEmail);
						System.out.println("emailul a fost actualizat");
					}
					
					else {
						System.out.println("persoana nu exista");
					}
					
				}
				
				if(commandUpdate.equals("nume si prenume")) {
					
					System.out.println("Introduceti prenumele");
					String firstName = sc.nextLine();
					System.out.println("Introduceti numele");
					String lastName = sc.nextLine();
					
					if(guestList.checkByName(lastName,firstName) != null) {
						guestList.checkByName(lastName,firstName).setLastName(lastName);
						guestList.checkByName(lastName,firstName).setName(firstName);
						System.out.println("Numele si prenumele au fost actualizate");
					} else {
						System.out.println("Persoana nu exista");
					}
					
				}
				System.out.println("Introduceti noua comanda sau quit");
			
			}
			
			if(command.equals("search")) {
				System.out.println("introduceti substring");
				
				String substring = sc.nextLine();
				for(Guest g : guestList.search(substring)) {
					System.out.println(g.toString());
				}
				System.out.println("Introduceti noua comanda sau quit");
			}
			
			if(command.equals("available")) { // locuri libere
				System.out.println(guestList.seatsLeft());
				System.out.println("Introduceti noua comanda sau quit");
			}
			
			if(command.equals("waiting")) { // lista asteptare
				System.out.println(guestList.waitingListOfParticipants());
				System.out.println("Introduceti noua comanda sau quit");
			}
			
			if(command.equals("guests")) { // lista inscrisi
				System.out.println(guestList.listOfParticipants());
				System.out.println("Introduceti noua comanda sau quit");
			}
			if(command.equals("guests_no")) { //numar inscrisi
				System.out.println(guestList.attendees());
				System.out.println("Introduceti noua comanda sau quit");
			}
			if(command.equals("waiting_no")) { //numar lista asteptare
				System.out.println(guestList.waitingAttendees());
				System.out.println("Introduceti noua comanda sau quit");
			}
			
			if(command.equals("subscribe_no")) { //numar lista toti inscrisii
				System.out.println(guestList.allAttendees());
				System.out.println("Introduceti noua comanda sau quit");
			}
		}
		System.out.println("Ati parasit aplicatia");
	}
	
	
	
	
		/* printam pe ecran optiunile userului
		 * string command
		 * while(command != 'quit') {
		 *  citim comanda
		 *  if(comanda == ...)
		 *  
		 *  
		 *  
		 *  Guest g1 = new Guest("aaa", "bb", "cc", "dd");
		Guest g2 = new Guest("aaa1", "bb1", "cc1", "dd1");
		Guest g3 = new Guest("ab2", "ab3", "ab4", "ab5");
		Guest g4 = new Guest("aaa", "bb", "cc", "dd");
		
		guestList.addGuest(g1);
		guestList.addGuest(g2);
		guestList.addGuest(g3);
		guestList.addGuest(g4);	
		 */ 
		
		
		
		// TODO Auto-generated method stub
	/* 
		
	int noSeats = sc.nextInt();
	ArrayList<Guest> guests = new ArrayList<Guest>(noSeats);
	
	System.out.println("Grupa Dvs. are " + noSeats + " locuri. "
			+ "Asteapta comanda: (help - Afiseaza lista de comenzi)");
	String command = sc.nextLine();
	command = sc.nextLine();
	switch(command){
		case "help" :
			System.out.println(
						
						);
			System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi");
			command = sc.nextLine();
		
		case "add" :
			String lastName;
			String name;
			String email;
			String phoneNumber;
			
			System.out.println("Adauga o persoana noua.");
			
			System.out.println("introduceti nume");
			lastName = sc.nextLine();
			System.out.println("introduceti prenume");
			name = sc.nextLine();
			System.out.println("introduceti email");
			email = sc.nextLine();
			System.out.println("introduceti numar de telefon");
			phoneNumber = sc.nextLine();
			
			Guest g = new Guest(lastName, name, email, phoneNumber);
			
			GuestListArray guest = new GuestListArray(lastName, name, email, phoneNumber);
			guest.addGuest(g);
			
		    break;
	}
	sc.close();	
	} */


}