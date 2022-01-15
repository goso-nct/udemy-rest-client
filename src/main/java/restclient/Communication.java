package restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import restclient.entity.Employee;

import java.util.List;

@Component
public class Communication {

    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8080/udemy_rest/api/employees";

    public List<Employee> getAllEmployees() {
        ResponseEntity<List<Employee>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Employee>>() {
                });
        return responseEntity.getBody();
    }

    public Employee getEmployee(int id) {
        Employee emp = restTemplate.getForObject(URL + "/" + id, Employee.class);
        return emp;
    }

    public void saveEmployee(Employee emp) {
        int id = emp.getId();
        if (id == 0) {
            ResponseEntity<String> response = restTemplate.postForEntity(URL, emp, String.class);
            System.out.println("New employee was added");
            System.out.println(response.getBody());
        } else {
            restTemplate.put(URL, emp);
            System.out.println("Employee with id=" + id + " was updated");
        }
    }

    public void deleteEmployee(int id) {
        restTemplate.delete(URL + "/" + id);
        System.out.println("Employee with id=" + id + " was deleted");
    }
}
