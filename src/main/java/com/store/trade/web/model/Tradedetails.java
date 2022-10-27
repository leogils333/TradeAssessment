package com.store.trade.web.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "trade_details")
public class Tradedetails {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private String tradeID;
	private int Version;
	@Column(name="counter_partyid")
	private String Counter_PartyID;
	private String BookID;
	private Date MaturityDate;
	private Date CreatedDate;
	private String Expired;
	
	public Tradedetails() {
		
	}
	
	public Tradedetails(String tradeID, int version, String counterPartyID, String bookID, Date maturityDate,
			Date createdDate, String expired) {
		super();
		this.tradeID = tradeID;
		this.Version = version;
		this.Counter_PartyID = Counter_PartyID;
		this.BookID = bookID;
		this.MaturityDate = maturityDate;
		this.CreatedDate = createdDate;
		this.Expired = expired;
	}
	@Override
	public int hashCode() {
		return Objects.hash(BookID, Counter_PartyID, CreatedDate, Expired, MaturityDate, tradeID, Version);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tradedetails other = (Tradedetails) obj;
		return Objects.equals(BookID, other.BookID) && Objects.equals(Counter_PartyID, other.Counter_PartyID)
				&& Objects.equals(CreatedDate, other.CreatedDate) && Objects.equals(Expired, other.Expired)
				&& Objects.equals(MaturityDate, other.MaturityDate) && Objects.equals(tradeID, other.tradeID)
				&& Objects.equals(Version, other.Version);
	}
	public String gettradeID() {
		return this.tradeID;
	}
	public void settradeID(String tradeID) {
		this.tradeID = tradeID;
	}
	public int getVersion() {
		return this.Version;
	}
	public void setVersion(int version) {
		this.Version = version;
	}
	public String getCounterPartyID() {
		return this.Counter_PartyID;
	}
	public void setCounterPartyID(String Counter_PartyID) {
		this.Counter_PartyID = Counter_PartyID;
	}
	public String getBookID() {
		return this.BookID;
	}
	public void setBookID(String bookID) {
		this.BookID = bookID;
	}
	public Date getMaturityDate() {
		return this.MaturityDate;
	}
	public void setMaturityDate(Date maturityDate) {
		this.MaturityDate = maturityDate;
	}
	public Date getCreatedDate() {
		return this.CreatedDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.CreatedDate = createdDate;
	}
	public String getExpired() {
		return this.Expired;
	}
	public void setExpired(String expired) {
		this.Expired = expired;
	}
}
