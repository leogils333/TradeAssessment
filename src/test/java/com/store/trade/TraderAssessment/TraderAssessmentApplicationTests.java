package com.store.trade.TraderAssessment;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.store.trade.web.control.ITradeController;
import com.store.trade.web.control.impl.TradeControllerImpl;
import com.store.trade.web.dao.ITradeRepository;
import com.store.trade.web.model.Tradedetails;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class TraderAssessmentApplicationTests {
	
	@Mock
	List<Tradedetails> test;
	
	@Autowired
	ITradeController iTradeCnontroll;
	
	@InjectMocks
	TradeControllerImpl service;
      
    @Mock
    ITradeRepository dao;
	
	@Test
    public void testFindAllTraders()
    {
		List<Tradedetails> list = new ArrayList<Tradedetails>();
		Tradedetails tradeOne = new Tradedetails("T1", 2,"CP-2","B1", new Date(), new Date(),"Y");
		Tradedetails tradeTwo = new Tradedetails("T2", 2,"CP-1","B1", new Date(), new Date(),"Y");
		Tradedetails tradeThree = new Tradedetails("T3", 2,"CP-2","B1", new Date(), new Date(),"Y");
		
		list.add(tradeOne);
        list.add(tradeTwo);
        list.add(tradeThree);
          
        when(dao.findAll()).thenReturn(list);
          
        //test
        ResponseEntity<List<Tradedetails>> tradeList = (ResponseEntity<List<Tradedetails>>) service.fetchAllTradeController();
        
        assertEquals(tradeList.getStatusCodeValue(), 200);
        verify(dao, times(1)).findAll();
    }
	
	@Test
    public void testSearchTradeController()
    {
		List<Tradedetails> traderSearch = dao.findByTradeID("T1").stream().map(data -> (Tradedetails) data).filter(s -> s.getCreatedDate().compareTo(s.getMaturityDate()) == 1).collect(Collectors.toList());
		
        ResponseEntity<List<Tradedetails>> tradeList = (ResponseEntity<List<Tradedetails>>) service.searchTradeController("T1");
        assertEquals(traderSearch.size(), 1);
        assertEquals(tradeList.getStatusCodeValue(), 200);
        verify(dao, times(1)).findByTradeID("T1");
    }
	
	@Test
    public void testAddTradeController()
    {
		Tradedetails tradeOne = new Tradedetails("T1", 2,"CP-2","B1", new Date(), new Date(),"Y");
        String tradeList = service.addTradeController(tradeOne);
        assertEquals(tradeList, "Trade Detail is updated Successfully");
    }
	
	@Test
	void contextLoads() {
	}

}
