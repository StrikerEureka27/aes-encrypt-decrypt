package STR.crypt;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import STR.crypt.Data.CryptData;
import STR.crypt.Data.CryptData_repository;

@RestController
@RequestMapping("/aes")
public class Controller {
	
	@Value("${crypt.security.phrase}")
	String phrase;

	@Autowired
	CryptData_repository cryptorepo;

	@GetMapping("/decrypt")
	public String getPassEncrypted() throws Exception {
		
		System.out.println("Retriving data from db...");
		Iterable<CryptData> items = cryptorepo.findAll();
		
		
		String pass = "";
		JSONObject json = new JSONObject();
		System.out.println("PHRASE: " + phrase);
		
		System.out.println("Retriving passwords from db...");
		for (CryptData cryptData : items) {
			pass = cryptorepo.decrypt(phrase, cryptData.getId());
			json.put("id"+cryptData.getId(), cryptData.getId());
			json.put("pass"+cryptData.getId(), pass);
		}
		
		return json.toString();
	}

}
