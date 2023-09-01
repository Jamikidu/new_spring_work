package bbb.service;


import org.apache.ibatis.annotations.Mapper;

import bbb.control.ReserveController;
import bbb.model.Reservation;




@Mapper
public interface ReserveMapper {
	
	int reserve(Reservation rv);

	
}
