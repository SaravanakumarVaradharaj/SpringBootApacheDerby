package com.traindetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainService {
@Autowired
TrainRepository tck;

public List<TrainDetails> getAllTicketDetails(String id){
	List<TrainDetails> ticket=new ArrayList<TrainDetails>();
    tck.findByTrid(id).forEach(ticket::add);
	return ticket;
	
}
public Optional<TrainDetails> searchTicket(String id){
	return tck.findById(id);
}
  public void addTicketDetailks(TrainDetails tk) {
	  tck.save(tk);
  }
  
  public void updateTicket(TrainDetails upt) {
	  tck.save(upt);
	  }
public void deleteTicketDetailks(String id) {
	// TODO Auto-generated method stub
	tck.deleteById(id);
}

}
