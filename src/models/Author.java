package models;
import java.time.LocalDate;
import java.time.Period;
public class Author {
	private String name;
	private String lastName;
	private LocalDate birthDate;
	private LocalDate dateDeath; // null if alive
	
	public Author (String name, String lastName,
			LocalDate birthDate, LocalDate dateDeath) {
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.dateDeath = dateDeath;
	}
	
	public int getAge() {
		if (birthDate == null) {
			throw new NullPointerException("The birthdate is not defined");
		}
		if (dateDeath != null) {
			return -1; // Return -1 if deceased
		}
		// Calculate age and return it 
		return Period.between(birthDate, LocalDate.now()).getYears();
	}
}
