package io.egen.entity;

import org.hibernate.annotations.GenericGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries (
			@NamedQuery(name="User.findByEmail", query="Select u from User u where u.email= :pEmail")
		)
public class User
{
	@Id
	@GenericGenerator(strategy="uuid2", name="myuuid")
	@GeneratedValue(generator="myuuid")
	private String id;
	private String firstName;
	private String lastName;
	
	@Column(unique=true)
	private String email;
	public String getEmail() { return email;}
	public void setEmail(String email) {this.email = email;}
	
	private String password;
}