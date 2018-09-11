package poly.manhnd.webapp.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROLE_ID")
	private Integer id;

	@Column(name = "ROLE_NAME", length = 45, unique = true, nullable = false)
	private String name;

	@ManyToMany(mappedBy = "roles", cascade=CascadeType.ALL)
	private List<User> users;

}
