import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Login {
	@Id
	@GeneratedValue
	private int id;
	@Column(nullable=false)
	private long PhNo;
	@CreationTimestamp
	private LocalDateTime LoggedTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getPhNo() {
		return PhNo;
	}
	public void setPhNo(long phNo) {
		PhNo = phNo;
	}
	public LocalDateTime getLoggedTime() {
		return LoggedTime;
	}
	public void setLoggedTime(LocalDateTime loggedTime) {
		LoggedTime = loggedTime;
	}
}
