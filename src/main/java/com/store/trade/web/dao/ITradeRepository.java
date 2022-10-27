package com.store.trade.web.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.store.trade.web.model.Tradedetails;

@Repository
public interface ITradeRepository extends CrudRepository<Tradedetails, Long> {
	List<Tradedetails> findAll();
	List<Tradedetails> findByTradeID(String TradeID);
}
