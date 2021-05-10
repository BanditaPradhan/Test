package com.spectrum.sci.completeorder.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderIdRepository {
	
	private static final Logger log = LoggerFactory.getLogger("OrderIdRepository.class");
	
	@Value("${osm.service.fallout.moveindate}")
	String moveInDate;
	
	@Value("${osm.service.fallout.task}")
	String falloutTask;
	
	public String getOrderIds() {	
		log.info("moveInDate = " + moveInDate);
		/*
		String orderIds = "select\r\n" + 
				"distinct c.order_Seq_ID from\r\n" + 
				"ooid_header_gen2 a\r\n" + 
				"inner join otc_d_cartridge b on a.cartridge_id = b.cartridge_id and a.SYS_ID = b.SYS_ID\r\n" + 
				"inner join ooid_task_gen2 c on a.ORDER_SEQ_ID = c.ORDER_SEQ_Id and a.SYS_ID = c.SYS_ID\r\n" + 
				"inner join ooid_error_history_gen2 d on c.ORDER_SEQ_ID = d.ORDER_SEQ_Id and c.SYS_ID = d.SYS_ID and c.parent_hist_seq_id = d.parent_hist_seq_id\r\n" + 
				"inner join ooid_order_gen2 e on a.SOLO_ORDER_ID = e.SOLO_ORDER_ID and a.SYS_ID = e.SYS_ID\r\n" + 
				"where b.version in ('1.0.0.124.0','1.0.0.125.0', '1.0.0.123.0')\r\n" + 
				"and a.sys_id = 3\r\n" + 
				"and a.ORD_STATE_ID = 4\r\n" + 
				"and c.move_in_date > to_date('" + moveInDate + "','DD-MON-YY')\r\n" +
				"and c.task_mnemonic = '" + falloutTask +  "'\r\n" +  
				"and c.move_out_date > sysdate + 1"  +
				"and rownum < 25 "; */
		
	  String orderIds = "select osm_order_id from ocm_stg where oc_id in (2, 3) \r\n" +
			  "and rownum < 2000";
		
	log.info("orderIds = " + orderIds);	
	return orderIds;
	}
		
}
