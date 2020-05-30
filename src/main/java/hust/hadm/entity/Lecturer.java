package hust.hadm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "lecturer")
public class Lecturer {
	
	@Id
	@Column
	private String id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column
	private String username;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {
			CascadeType.DETACH, 
			CascadeType.MERGE, 
			CascadeType.PERSIST,
			CascadeType.REFRESH
			})
	@JoinColumn(name = "school_id")
	private School school;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.DETACH, 
					CascadeType.MERGE, 
					CascadeType.PERSIST, 
					CascadeType.REFRESH})
	@JoinTable(
			name = "subject_lecturer",
			joinColumns = @JoinColumn(name = "lecturer_id"),
			inverseJoinColumns = @JoinColumn(name = "subject_id")
			)
	private List<Subject> subjects;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(
			name = "lecturer_article",
			joinColumns = @JoinColumn(name = "lecturer_id")
	)
	@Column(name = "title")
	private List<String> articles;

	public Lecturer(String id, String firstName, String lastName, String username) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
	}

	public Lecturer(String id, String firstName, String lastName, String username, List<String> articles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.articles = articles;
	}
	
	public void addSubject(Subject newSubject) {
		subjects.add(newSubject);
	}
	
	public void removeSubject(Subject toRemove) {
		subjects.remove(toRemove);
	}
	

}
