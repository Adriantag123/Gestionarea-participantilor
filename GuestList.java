package guestList;

import java.util.ArrayList;

public class GuestList {
		
	private int noSeats;
	
	//constructor clasa GuestList
		public GuestList (int noSeats) { 
			this.noSeats = noSeats;
		}
	
	public int getNoSeats() {
		return noSeats;
	}

	public void setNoSeats(int noSeats) {
		this.noSeats = noSeats;
	}
	//arraylist cu inscrisi
	private ArrayList<Guest> guests = new ArrayList<>();
	
	// getter si setter pt ArrayList de guests
	public ArrayList<Guest> getGuests() {
		return guests;
	}

	public void setGuests(ArrayList<Guest> guests) {
		this.guests = guests;
	}
	
	//arraylist lista de asteptare
	private ArrayList<Guest> waitingList = new ArrayList<>();
	
	public ArrayList<Guest> getWaitingList() {
		return waitingList;
	}

	public void setWaitingList(ArrayList<Guest> waitingList) {
		this.waitingList = waitingList;
	}

	// verificare daca persoana exista pe una din cele doua liste - dupa nume si prenume
	public Guest checkByName (String lastName, String firstName) {
		
		for(Guest guest : guests) {
			
			if((guest.getLastName().equals(lastName)) && (guest.getName().equals(firstName))) {
				return guest;
			}
		}
		
		for(Guest guest : waitingList) {
			
			if((guest.getLastName().equals(lastName)) && (guest.getName().equals(firstName))) {
				return guest;
			}
		}
		
		return null;
	}
	
	// verificare daca persoana exista pe una din cele doua liste - dupa mail
	public Guest checkByMail (String mail) {
		
		for(Guest guest : guests) {
			if(guest.getEmail().equals(mail)) {
				return guest;
			}
		}
		
		for (Guest guest : waitingList) {
			if(guest.getEmail().equals(mail)) {
				return guest;
			}
		}
		
		return null;
		
	}
	
	// verificare daca persoana exista pe una din cele doua liste - dupa telefon
	public Guest checkByPhone (String phone) {
		
		for(Guest guest : guests) {
			if(guest.getPhoneNumber().equals(phone)) {
			
				return guest;
			}
		}
		
		for(Guest guest : waitingList) {
			if(guest.getPhoneNumber().equals(phone)) {
				return guest;
			}
		}
		return null;
	}
	
	// adaugare participant
	public int addGuest(Guest g) {
		// verificare daca persoana pe care vrem sa o adaugam este deja inscrisa 
		if( (checkByName(g.getLastName(), g.getName()) != null) || (checkByMail(g.getEmail()) != null) || (checkByPhone(g.getPhoneNumber()) != null)) {
			System.out.println("Esti deja inscris");
			return -1;
		}
		// 
		else if (guests.size() == noSeats) {
			waitingList.add(g);
			System.out.println("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine " + (waitingList.indexOf(g)+1) + ". Te vom notifica daca un loc devine disponibil.");
			return waitingList.indexOf(g);
		}
		
		else {
			guests.add(g);
			System.out.println("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!.");
			return 0;
		}
	}
	// stergere persoana 
	public boolean delete(Guest g) {
		
		if( (checkByName(g.getLastName(), g.getName()) == null) && (checkByMail(g.getEmail()) == null) && (checkByPhone(g.getPhoneNumber()) == null)) {
			System.out.println("Persoana nu este inscrisa pe nicio lista");
			return false;
		}
		System.out.println("1");
		// stergere persoana de pe lista de asteptare daca exista
		if(waitingList.contains(g)) {
			waitingList.remove(g);
			System.out.println("Persoana cautata a fost stearsa din lista de asteptare");
			return true;
		}
		
		// stergere persoana din lista de inscrisi
		else if (guests.contains(g)) {
			
			guests.remove(g);
			System.out.println("Persoana cautata a fost stearsa din lista de inscrisi");
			//Guest g1 = waitingList.get(0);  creat obiect guest ca mai apoi sa il adaug in arrayList-ul guests
			//adaugare in lista principala prima persoana de pe lista de inscrisi
			if(waitingList.size() > 0) {
				guests.add(waitingList.get(0));
				System.out.println("Felicitari! Locul tau la eveniment este confirmat in urma retragerii unei persoane. Te asteptam!.");
				return true;
			}
			
		}
		
		System.out.println("2");
		return false;
	}
	//update nume si prenume
	public boolean updateName(Guest g, String newName, String newLastName) {
		
		if((checkByName(g.getName(), g.getLastName()) != null)) {
			System.out.println("Introduceti noul nume");
			g.setName(newName);
			g.setLastName(newLastName);
			return true;
		}
		return false;
	}
	
	// update Mail
	public boolean updateMail(Guest g, String newMail) {
		
		if( checkByMail(g.getEmail()) != null) {
			System.out.println("Introduceti noul mail");
			g.setEmail(newMail);
			return true;
		}
		return false;
	}
	
	//update telefon
	
	public boolean updatePhone(Guest g, String newPhone) {
			
		if( checkByPhone(g.getPhoneNumber()) != null) {
			System.out.println("Introduceti noul telefon");
			g.setPhoneNumber(newPhone);
			return true;
			}
		return false;
	}

	//search
	
	public ArrayList<Guest> search(String substring) {
		
		ArrayList<Guest> finalList = new ArrayList<>();
		
		for(Guest g : guests) {
			if(g.getLastName().toLowerCase().contains(substring.toLowerCase()) || (g.getName().toLowerCase().contains(substring.toLowerCase())) || (g.getEmail().toLowerCase().contains(substring.toLowerCase())) || (g.getPhoneNumber().toLowerCase().contains(substring.toLowerCase()))) {
				
				finalList.add(g);

			}
			
		}
		return finalList;
	}
	
	// lista de participanti inscrisi
	
	public boolean listOfParticipants() {
		System.out.println("Lista participanti inscrisi");
		for(Guest g : guests) {
			System.out.println(g.getName() + " " + g.getLastName());
		}
		return true;
	}
	
	// lista de participanti pe lista de asteptare
	public boolean waitingListOfParticipants() {
		System.out.println("Lista participanti inscrisi pe lista de asteptare");
		for(Guest g : waitingList) {
			System.out.println(g.getName() + " " + g.getLastName());
		}
		return true;
	}
	
	// numar de locuri disponibile
	public int seatsLeft() {
		System.out.println("Locuri disponibile " + (noSeats - guests.size()));
		return (noSeats - guests.size());
	}
	
	// guests_no - Numarul de persoane care participa la eveniment
	public int attendees() {
		System.out.println("Numar participanti inscrisi" + guests.size());
		return guests.size();
	}
	
	// waitingList_no - Numarul de persoane din lista de asteptare
	public int waitingAttendees() {
		System.out.println("Numar participanti inscrisi" + waitingList.size());
		return waitingList.size();
	}
	
	// Numar total de persoane inscrise
	public int allAttendees () {
		System.out.println("Numar total de persoane inscrise " + (guests.size() + waitingList.size()));
		return (guests.size() + waitingList.size());
	}

}


	
