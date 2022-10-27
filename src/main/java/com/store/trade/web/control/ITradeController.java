package com.store.trade.web.control;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import com.store.trade.web.model.Tradedetails;

@Configuration
public interface ITradeController {
	public ResponseEntity<List<Tradedetails>> searchTradeController(String TradeID);
	public String addTradeController(Tradedetails tradeDetails);
	public void updateTradeController();
	ResponseEntity<List<Tradedetails>> fetchAllTradeController();
}
