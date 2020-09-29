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
public class TrainControl {
	
@Autowired
private TrainService ser;

	@RequestMapping("/hello")
	public String sayHi() {
		return "Hi";
	}
	
	
	@RequestMapping("/ticketdet/{id}/train")
	public List<TrainDetails> getAllTicketDetails(@PathVariable String id){
		return ser.getAllTicketDetails(id);
	}
	
	@RequestMapping("/ticketdet/{tkid}/train/{id}")
	public Optional<TrainDetails> searchDetails(@PathVariable String id){
		return ser.searchTicket(id);
	}
	
	@RequestMapping(value="/addticket/{id}/addtrain",method=RequestMethod.POST)
	public void addTicket(@RequestBody TrainDetails td,@PathVariable String id) {
		td.setTk(new TicketDetails(id,""));
		ser.addTicketDetailks(td);
	}
	
	@RequestMapping(value="/upticket/{tkid}/uptraindet/{id}",method=RequestMethod.PUT)
	public void updateTicket(@RequestBody TrainDetails tk,@PathVariable String tkid,@PathVariable String id) {
		tk.setTk(new TicketDetails(tkid,"") );
		ser.updateTicket(tk);
	}
	
	@RequestMapping(value="/detticket/{tkid}/dettraindet/{id}",method=RequestMethod.DELETE)
	public void deleteTicket(@PathVariable String id) {
		ser.deleteTicketDetailks(id);
	}
}
