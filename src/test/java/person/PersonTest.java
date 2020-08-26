package person;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.personapplication.person.PersonApplication;
import com.personapplication.person.entity.Person;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = PersonApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetAllPersons() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/all",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
		System.out.println("Test All Employees Succesfull Recieve Response"+response);
	}

	@Test
	public void testGetPersonById() {
		Person person=restTemplate.getForObject(getRootUrl() +"api/persons/id", Person.class);
		
		System.out.println("Testing Get Employee By Id Response Recieved : "+person.getName());
		assertNotNull(person);
	}

	@Test
	public void testCreatePerson() {
		try {
		Person p =new Person();
		p.setName("Test USers");
		p.setSex("male");
		Date d=new Date();
		p.setAge(10);
		p.setBirthday(d);
		p.setCreated(d);
		p.setModified(d);
		p.setEmail("test@gmail.com");
		ResponseEntity<Person> postResponse = restTemplate.postForEntity(getRootUrl() + "api/addpersons", p, Person.class);
		assertNotNull(postResponse);
		//assertNotNull(postResponse.getBody());
		}
		catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}

	@Test
	public void testUpdatePerson() {
		int id = 1;
		Person person = restTemplate.getForObject(getRootUrl() + "api/persons/" + id, Person.class);
		person.setName("Test Users Changes");
//
		restTemplate.put(getRootUrl() + "/persons/" + id, person);
//
		Person updatedPerson = restTemplate.getForObject(getRootUrl() + "api/persons/" + id, Person.class);
		assertNotNull(updatedPerson);
	}

	@Test
	public void testDeletePerson() {
		int id = 2;
		Person person = restTemplate.getForObject(getRootUrl() + "api/persons/" + id, Person.class);
		assertNotNull(person);

		restTemplate.delete(getRootUrl() + "api/persons/" + id);

		try {
			person = restTemplate.getForObject(getRootUrl() + "api/persons/" + id, Person.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}