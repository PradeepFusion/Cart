import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
public class Carts {
	@Id
	@GeneratedValue
	private int id;
	@Column(nullable=false,unique=true)
	private long phNo;
	
	private int NoofchoosedCategories;
	private int Totalprice;
	private int finalAmount;
	@CreationTimestamp
	private LocalDateTime loggedTime;
	@UpdateTimestamp
	private LocalDateTime exitTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getPhNo() {
		return phNo;
	}
	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}
	public int getNoofchoosedCategories() {
		return NoofchoosedCategories;
	}
	public void setNoofchoosedCategories(int noofchoosedCategories) {
		NoofchoosedCategories = noofchoosedCategories;
	}
	public int getTotalprice() {
		return Totalprice;
	}
	public void setTotalprice(int totalprice) {
		Totalprice = totalprice;
	}
	public int getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(int finalAmount) {
		this.finalAmount = finalAmount;
	}
	public LocalDateTime getLoggedTime() {
		return loggedTime;
	}
	public void setLoggedTime(LocalDateTime loggedTime) {
		this.loggedTime = loggedTime;
	}
	public LocalDateTime getExitTime() {
		return exitTime;
	}
	public void setExitTime(LocalDateTime exitTime) {
		this.exitTime = exitTime;
	}
	
	
}
