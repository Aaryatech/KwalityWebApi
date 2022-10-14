package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.entity.GetStockDetails;

public interface GetStockDetailRepository extends JpaRepository<GetStockDetails,String>,
JpaSpecificationExecutor<GetStockDetails> {

	@Query(value="select UUID() as id, a.item_name,a.rol,ifnull(c.opening_quantity,0) as opening_quantity,ifnull(c.approved_quantity,0) as approved_quantity,\n" + 
			"ifnull(d.item_issue,0) as issue_quantity\n" + 
			"from\n" + 
			"(select * from item) as a\n" + 
			"LEFT JOIN\n" + 
			"(select md.id as id,osd.opening_quantity as opening_quantity,sum(md.approved_qty) as approved_quantity,md.item_id\n" + 
			"from opening_stock_header osh,opening_stock_detail osd,\n" + 
			"mrn_header mh, mrn_detail md\n" + 
			"where osh.id=osd.opening_stock_header_id and mh.id=md.mrn_id and\n" + 
			"osd.item_id=md.item_id and mh.mrn_date between osh.from_date and :strDate and osh.status=0 \n" + 
			"group by osd.item_id,md.item_id) as c\n" + 
			"on c.item_id=a.id\n" + 
			"LEFT JOIN\n" + 
			"(select mrn_detail_id as id,sum(item_issue_qty) as item_issue\n" + 
			"from item_issue_detail group by item_id) as d\n" + 
			"on d.id=c.id",nativeQuery=true)
	List<GetStockDetails> getStockDetails(@Param("strDate")String strDate);
	
	

}
