package hibernate.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Hello World!");
        
        Configuration config=new Configuration();
		/*
		 * config.setProperty("hibernate.connection.driver_class",
		 * "com.mysql.jdbc.Driver"); config.setProperty("hibernate.connection.url",
		 * "jdbc:mysql://localhost:3306/employee");
		 * config.setProperty("hibernate.connection.username", "root");
		 * config.setProperty("hibernate.connection.password", "root");
		 * config.setProperty("hibernate.dialect",
		 * "org.hibernate.dialect.MySQLDialect");
		 */
        config.addAnnotatedClass(Employee.class);
        config.addAnnotatedClass(Account.class);
        
        SessionFactory sessionFactory = config.buildSessionFactory();  
       
        App app=new App();
        
        //app.example1(sessionFactory);
        app.example11(sessionFactory);
        //app.example2(sessionFactory);
        //app.example3(sessionFactory);
        
        sessionFactory.close();
    }

	private void example3(SessionFactory sf) {
		Session s = sf.openSession();
		Query q=s.createQuery("from Employee emp join fetch emp.account");
		//N+1 won't be fired
        List<Employee> lst=q.getResultList();
        for(Employee emp:lst) {
        	System.out.println("Emp ID:"+emp.getEmployeeId()+": Acc no:"+emp.getAccount().getAccountNumber());
        }
        
        s.close();
	}

	private void example2(SessionFactory sf) {
		Session s = sf.openSession();
		Query q=s.createQuery("from Employee");//Using LAZY or EAGER(default) fetch type on account
        //N+1 queries will be fired
        List<Employee> lst=q.getResultList();
        for(Employee emp:lst) {
        	System.out.println("Emp ID:"+emp.getEmployeeId()+": Acc no:"+emp.getAccount().getAccountNumber());
        }
        
        s.close();
	}

	private void example1(SessionFactory sf) {
        
		Session s = sf.openSession();
        Employee e=s.get(Employee.class, 1);//When FetchType is Lazy on private Account account in Employee
        //on OneToOne annotation then one query is fired from Employee table
        System.out.println("Emp ID:"+e.getEmployeeId());
        
        s.close();
        
        Account ac=e.getAccount();
        //System.out.println("Account Object: "+ac);	//Give Lazy exception when FetchType is Lazy
        //System.out.println(ac.getAccountNumber());	//Give Lazy exception when FetchType is Lazy
        System.out.println(ac.getAccountId());

	}
	private void example11(SessionFactory sf) {
        
		Session s = sf.openSession();
        Employee e=s.get(Employee.class, 1);//When FetchType is Lazy on private Account account in Employee
        //on OneToOne annotation then one query is fired from Employee table
        System.out.println("Emp ID:"+e.getEmployeeId());
        Hibernate.initialize(e.getAccount());
        
        s.close();
        
        Account ac=e.getAccount();
        System.out.println("Account Object: "+ac);	//Give Lazy exception when FetchType is Lazy
        System.out.println(ac.getAccountNumber());	//Give Lazy exception when FetchType is Lazy
        System.out.println(ac.getAccountId());

	}
}
