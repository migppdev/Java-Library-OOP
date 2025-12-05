package models;
import java.time.LocalDate;
import java.time.Period;

public class Author {
	private static int idCounter;;
	private final int id;
	private String name;
	private String lastName;
	private LocalDate birthDate;
	private LocalDate dateDeath; // null if alive
	
	// Constructors
	public Author (String name, String lastName,
			LocalDate birthDate) {
		this.id = ++idCounter;
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		
	}
	public Author (String name, String lastName,
			LocalDate birthDate, LocalDate dateDeath) {
		this.id = ++idCounter;
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.dateDeath = dateDeath;
	}
	
	// Getters
	public int getAge() {
		if (dateDeath != null) {
			return -1; // Return -1 if deceased
		}
		// Calculate age and return it 
		return Period.between(birthDate, LocalDate.now()).getYears();
	}
	
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getLastName() {
		return this.lastName;
	}
	
	public LocalDate getbirthDate() {
		return this.birthDate;
	}
	public LocalDate getDateDeath() {
		return this.dateDeath;
	}
	
	public String getFullName() {
		return this.name + " " + this.lastName;
	}
	
	
	
}
