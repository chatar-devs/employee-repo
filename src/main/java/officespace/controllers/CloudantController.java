package officespace.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.cloudant.client.api.CloudantClient;
import officespace.repo.EmpRepo;
import officespace.model.Employee;

/**
 * A class to test interactions with the MySQL database using the AccountDao class.
 *
 * @author Chatar
 */
@RestController
public class CloudantController {

  @Autowired
  private CloudantClient client;
  
  @Autowired
  private EmpRepo EmpRepo;
  
  /**
   * Compute Interest and store remainder in an account that I control
   *
   * @param transaction The transaction to compute interest
   *
   * @return A string describing the result of the interest computation
   */
  @GetMapping("cloudant")
  public List<String> cloudant() {
	  List<String> dbs=new ArrayList<String>();
	  try{
		  dbs = client.getAllDbs();
	  }
	  catch(NullPointerException e){
		  System.out.println("Error...");
	  }
	return dbs;
    
  }

  @PostMapping("saveEmp")
  @ResponseBody
  public Employee saveEmp(@RequestBody Employee emp) {
	  return EmpRepo.saveEmployee(emp);
  }

} // class UserController
