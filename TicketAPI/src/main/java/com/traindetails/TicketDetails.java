package com.traindetails;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class TicketDetails {

@Id
private String tkid;
private String tkname;

public TicketDetails() {
	// TODO Auto-generated constructor stub
}
public TicketDetails(String tkid, String tkname) {
	super();
	this.tkid = tkid;
	this.tkname = tkname;
}
public String getTkid() {
	return tkid;
}
public void setTkid(String tkid) {
	this.tkid = tkid;
}
public String getTkname() {
	return tkname;
}
public void setTkname(String tkname) {
	this.tkname = tkname;
}

}
