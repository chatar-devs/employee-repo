package officespace.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;

import officespace.model.Employee;

@Component
public class EmpRepo {
	@Autowired
	private CloudantClient cloudantClient;
	private static final String CLOUDANT_DB = "demo1";
	    
	 public Employee saveEmployee(Employee emp){
		 Database db = cloudantClient.database(CLOUDANT_DB, true);
		 db.save(emp);
		return emp;
	    }

}
