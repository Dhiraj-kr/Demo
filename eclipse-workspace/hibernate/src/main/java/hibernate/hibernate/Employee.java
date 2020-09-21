package hibernate.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee
{
  @Id
  @Column(name="ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private int employeeId;
  
  @OneToOne(fetch=FetchType.LAZY)
  //@OneToOne
  @JoinColumn(name="ACCOUNT_ID")
  private Account account;
  
  /*
   By default, the JPA @ManyToOne and @OneToOne annotations are fetched EAGER, 
   while the @OneToMany and @ManyToMany relationships are considered LAZY. 
   */

  // omitting code for getters and setters for username, password

  public Account getAccount()
  {
    return account;
  }
  public int getEmployeeId() {
	return employeeId;
  }
  public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
  }
  private void setAccount(Account account)
  {
    this.account = account;
  }
}
