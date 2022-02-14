package officespace.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;

import officespace.model.Employee;

@Component
public class EmpRepo {
	@Autowired
	private CloudantClient cloudantClient;
	@Value( "${dbname}" )
	private static String CLOUDANT_DB;
	    
	 public Employee saveEmployee(Employee emp){
		 Database db = cloudantClient.database(CLOUDANT_DB, true);
		 System.out.println("Saving employee details in DB >>>>>>>>"+CLOUDANT_DB );
		 db.save(emp);
		 System.out.println("Saved employee details >>>>>>>>"+emp.toString() );
		return emp;
	    }

}
