package STR.crypt.Data;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.query.Procedure;

@Entity
@Table(name = "crypt")
public class CryptData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "pass")
	private String pass;	
	
	public int getId() {
		return id;
	}
	
	public void setId(int aId) {
		id = aId;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String aPass) {
		pass = aPass;
	}
	
}
