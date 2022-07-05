package STR.crypt.Data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

public interface CryptData_repository extends CrudRepository<CryptData, Integer>  {
	public List<CryptData> findById(int id);
	@Query(value = "SELECT DECRYPT_STR((?1),(?2));", nativeQuery = true)
	String decrypt(String phrase, int id);
}
