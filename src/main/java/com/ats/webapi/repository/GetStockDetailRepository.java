package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.entity.GetStockDetails;

public interface GetStockDetailRepository extends JpaRepository<GetStockDetails,String>,
JpaSpecificationExecutor<GetStockDetails> {

	@Query(value="select\n" + 
			"        UUID() as id,\n" + 
			"        a.item_name,\n" + 
			"        a.rol,\n" + 
			"        ifnull(b.opening_quantity,\n" + 
			"        0) as opening_quantity,\n" + 
			"        ifnull(c.approved_quantity,\n" + 
			"        0) as approved_quantity,\n" + 
			"        ifnull(d.item_issue,\n" + 
			"        0) as issue_quantity ,\n" + 
			"        ifnull(b.opening_quantity,0)+ifnull(c.approved_quantity,0)-ifnull(d.item_issue,0) as closing_quantity     \n" + 
			"    from\n" + 
			"        (select\n" + 
			"            *          \n" + 
			"        from\n" + 
			"            item) as a\n" + 
			"    LEFT JOIN\n" + 
			"        (\n" + 
			"            select \n" + 
			"                osd.opening_quantity as opening_quantity, \n" + 
			"                osd.item_id              \n" + 
			"            from\n" + 
			"                opening_stock_header osh,\n" + 
			"                opening_stock_detail osd            \n" + 
			"            where\n" + 
			"                osh.id=osd.opening_stock_header_id                    \n" + 
			"                and osh.status=0               \n" + 
			"            group by\n" + 
			"                osd.item_id         \n" + 
			"        ) as b              \n" + 
			"            on b.item_id=a.id\n" + 
			"    LEFT JOIN\n" + 
			"        (\n" + 
			"            select\n" + 
			"                md.id as id, \n" + 
			"                sum(md.approved_qty) as approved_quantity,\n" + 
			"                md.item_id              \n" + 
			"            from \n" + 
			"                mrn_header mh,\n" + 
			"                mrn_detail md,\n" + 
			"                opening_stock_header osh\n" + 
			"            where\n" + 
			"                mh.id=md.mrn_id           \n" + 
			"                and mh.mrn_date between osh.from_date and :strDate\n" + 
			"                and osh.status=0\n" + 
			"            group by \n" + 
			"                md.item_id         \n" + 
			"        ) as c              \n" + 
			"            on c.item_id=a.id      \n" + 
			"    LEFT JOIN\n" + 
			"        (\n" + 
			"            select\n" + 
			"                mrn_detail_id as id,\n" + 
			"                sum(item_issue_qty) as item_issue              \n" + 
			"            from\n" + 
			"                item_issue_detail,\n" + 
			"                item_issue iss,\n" + 
			"                opening_stock_header osh\n" + 
			"            where item_issue_detail.item_issue_id=iss.id\n" + 
			"                and iss.issue_date between osh.from_date and :strDate\n" + 
			"                and osh.status=0 \n" + 
			"            group by\n" + 
			"                item_id         \n" + 
			"        ) as d              \n" + 
			"            on d.id=c.id",nativeQuery=true)
	List<GetStockDetails> getStockDetails(@Param("strDate")String strDate);

	
	@Query(value="select z.* from (select\n" + 
			"        UUID() as id,\n" + 
			"        a.item_name,\n" + 
			"        a.rol,\n" + 
			"        ifnull(b.opening_quantity,\n" + 
			"        0) as opening_quantity,\n" + 
			"        ifnull(c.approved_quantity,\n" + 
			"        0) as approved_quantity,\n" + 
			"        ifnull(d.item_issue,\n" + 
			"        0) as issue_quantity ,\n" + 
			"        ifnull(b.opening_quantity,0)+ifnull(c.approved_quantity,0)-ifnull(d.item_issue,0) as closing_quantity     \n" + 
			"    from\n" + 
			"        (select\n" + 
			"            *          \n" + 
			"        from\n" + 
			"            item) as a\n" + 
			"    LEFT JOIN\n" + 
			"        (\n" + 
			"            select \n" + 
			"                osd.opening_quantity as opening_quantity, \n" + 
			"                osd.item_id              \n" + 
			"            from\n" + 
			"                opening_stock_header osh,\n" + 
			"                opening_stock_detail osd            \n" + 
			"            where\n" + 
			"                osh.id=osd.opening_stock_header_id                    \n" + 
			"                and osh.status=0               \n" + 
			"            group by\n" + 
			"                osd.item_id         \n" + 
			"        ) as b              \n" + 
			"            on b.item_id=a.id\n" + 
			"    LEFT JOIN\n" + 
			"        (\n" + 
			"            select\n" + 
			"                md.id as id, \n" + 
			"                sum(md.approved_qty) as approved_quantity,\n" + 
			"                md.item_id              \n" + 
			"            from \n" + 
			"                mrn_header mh,\n" + 
			"                mrn_detail md,\n" + 
			"                opening_stock_header osh\n" + 
			"            where\n" + 
			"                mh.id=md.mrn_id           \n" + 
			"                and mh.mrn_date between osh.from_date and :strDate\n" + 
			"                and osh.status=0\n" + 
			"            group by \n" + 
			"                md.item_id         \n" + 
			"        ) as c              \n" + 
			"            on c.item_id=a.id      \n" + 
			"    LEFT JOIN\n" + 
			"        (\n" + 
			"            select\n" + 
			"                mrn_detail_id as id,\n" + 
			"                sum(item_issue_qty) as item_issue              \n" + 
			"            from\n" + 
			"                item_issue_detail,\n" + 
			"                item_issue iss,\n" + 
			"                opening_stock_header osh\n" + 
			"            where item_issue_detail.item_issue_id=iss.id\n" + 
			"                and iss.issue_date between osh.from_date and :strDate\n" + 
			"                and osh.status=0 \n" + 
			"            group by\n" + 
			"                item_id         \n" + 
			"        ) as d              \n" + 
			"            on d.id=c.id) z\n" + 
			"        where z.closing_quantity<z.rol",nativeQuery=true)
	List<GetStockDetails> getStockDetailsWithRol(@Param("strDate")String strDate);
	
	

}
