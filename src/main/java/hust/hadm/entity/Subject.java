package hust.hadm.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "subject")
public class Subject {
	
	@Id
	@Column
	private String id;
	
	@Column
	private String name;
	
	@ManyToMany(mappedBy = "subjects")
	private List<Student> students;
	
	@ManyToMany(mappedBy = "subjects")
	private List<Lecturer> lecturers;

	public Subject(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	

}
