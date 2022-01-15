package restclient;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import restclient.entity.Employee;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        var communication = context.getBean("communication", Communication.class);
        //System.out.println(communication.getAllEmployees());
        //System.out.println(communication.getEmployee(100));
        //Employee emp = new Employee("Sveta", "Sokolova", "Sale", 500);
        //communication.saveEmployee(emp);
        //emp.setId(12);
        //emp.setSalary(600);
        //communication.saveEmployee(emp);
        communication.deleteEmployee(9);
    }
}
