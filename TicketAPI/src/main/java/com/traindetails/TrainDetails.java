package com.traindetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class TrainDetails {

@Id
private String trid;
private String trname;

@ManyToOne
private TicketDetails tk;

public TrainDetails() {
	// TODO Auto-generated constructor stub
}
public TrainDetails(String trid, String trname,String tkid) {
	super();
	this.trid = trid;
	this.trname = trname;
	this.tk=new TicketDetails(tkid,"");
}
public String getTrid() {
	return trid;
}
public void setTrid(String trid) {
	this.trid = trid;
}
public String getTrname() {
	return trname;
}
public void setTrname(String trname) {
	this.trname = trname;
}

public TicketDetails getTk() {
	return tk;
}
public void setTk(TicketDetails tk) {
	this.tk = tk;
}


}
