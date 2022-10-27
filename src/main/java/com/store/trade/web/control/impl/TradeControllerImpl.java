package com.store.trade.web.control.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.trade.web.control.ITradeController;
import com.store.trade.web.dao.ITradeRepository;
import com.store.trade.web.model.Tradedetails;

@RequestMapping(value = "/tradecontrol")
@RestController
public class TradeControllerImpl implements ITradeController {
	
	@Autowired
	ITradeRepository iTradeRepo;
	
	
	@RequestMapping(value = "/fetchAllTrade", produces = {MediaType.APPLICATION_JSON_VALUE}) 
	public ResponseEntity<List<Tradedetails>> fetchAllTradeController() { 
		System.out.println("test"); 
		return new ResponseEntity<List<Tradedetails>>(	iTradeRepo.findAll(), HttpStatus.OK); 
	}
	 
	
	@GetMapping(value = "/searchTrade") 
	public ResponseEntity<List<Tradedetails>> searchTradeController(@RequestParam(name = "TradeID") String TradeID) 
	{
		return new ResponseEntity<List<Tradedetails>>(iTradeRepo.findByTradeID(TradeID).stream()
						.map(data -> (Tradedetails) data)
						.filter(s -> s.getCreatedDate().compareTo(s.getMaturityDate()) == 1)
						.collect(Collectors.toList()), HttpStatus.OK); 
	}
	 

	
	@PutMapping(path = "/addTrade")
	public String addTradeController(Tradedetails tradeDetails) {
		System.out.println("test");
		iTradeRepo.save(tradeDetails);
		return "Trade Detail is updated Successfully";
	}
	

	@PutMapping(path = "/updateTrade")
	public void updateTradeController() {
		
		
	}
}
