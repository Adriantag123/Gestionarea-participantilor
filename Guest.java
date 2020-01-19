package guestList;

	public class Guest {
		
		private String lastName;
		private String name;
		private String email;
		private String phoneNumber;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		public Guest (String lastName, String firstName, String email, String phoneNumber) {
			this.lastName = lastName;
			this.name = firstName;
			this.email = email;
			this.phoneNumber = phoneNumber;
		}
		
		
		@Override
		public String toString() {
			return "Guest: \n nume = " + lastName + "\n prenume = " + name + "\n email = " + email + "\n phoneNumber = "
					+ phoneNumber + "";
		}
		
	}

