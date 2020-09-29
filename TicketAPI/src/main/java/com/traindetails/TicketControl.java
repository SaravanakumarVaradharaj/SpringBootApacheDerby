package com.traindetails;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketControl {
	
@Autowired
private TicketService ser;

	/*@RequestMapping("/hello")
	public String sayHi() {
		return "Hi";
	}*/
	
	
	@RequestMapping("/ticketdet")
	public List<TicketDetails> getAllTicketDetails(){
		return ser.getAllTicketDetails();
	}
	
	@RequestMapping("/ticketdet/{id}")
	public Optional<TicketDetails> searchDetails(@PathVariable String id){
		return ser.searchTicket(id);
	}
	
	@RequestMapping(value="/addticket",method=RequestMethod.POST)
	public void addTicket(@RequestBody TicketDetails td) {
		ser.addTicketDetailks(td);
	}
	
	@RequestMapping(value="/upticket/{id}",method=RequestMethod.PUT)
	public void updateTicket(@RequestBody TicketDetails tk,@PathVariable String id) {
		ser.updateTicket(tk,id);
	}
	
	@RequestMapping(value="/detticket/{id}",method=RequestMethod.DELETE)
	public void deleteTicket(@PathVariable String id) {
		ser.deleteTicketDetailks(id);
	}
	@RequestMapping("/check")
	public void checkData() {
		
	}
}
