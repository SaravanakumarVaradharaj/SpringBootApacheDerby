package com.traindetails;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
@Autowired
TicketRepository tck;

public List<TicketDetails> getAllTicketDetails(){
	List<TicketDetails> ticket=new ArrayList<TicketDetails>();
    tck.findAll().forEach(ticket::add);
	return ticket;
	
}
public Optional<TicketDetails> searchTicket(String id){
	return tck.findById(id);
}
  public void addTicketDetailks(TicketDetails tk) {
	  tck.save(tk);
  }
  
  public void updateTicket(TicketDetails upt,String id) {
	  tck.save(upt);
	  }
public void deleteTicketDetailks(String id) {
	// TODO Auto-generated method stub
	tck.deleteById(id);
}

}
