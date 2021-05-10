package com.spectrum.sci.completeorder.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spectrum.sci.completeorder.model.Order;

public class OrderRowMapper implements RowMapper<Order>{

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Order order = new Order();
		order.setOrderId(rs.getString("osm_order_id"));		
		return order;
	}

}
