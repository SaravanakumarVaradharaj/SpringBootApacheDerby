package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.dto.EmpDTO;

public class EmpDAO {
JdbcTemplate jdbc;

public int save(EmpDTO ed) {
	String insert="insert into emp_det values('"+ed.getEid()+"','"+ed.getEname()+"')";
    return jdbc.update(insert) ;
}

public int edit(EmpDTO et) {
	String update="update emp_det set ename='"+et.getEname()+"' where eid='"+et.getEid()+"'";
	return jdbc.update(update);
}

public List<EmpDTO> getAllEmployees(){
   String query="select * from emp_det";
   return jdbc.query(query,new RowMapper<EmpDTO>() {

	public EmpDTO mapRow(ResultSet rs, int row) throws SQLException {
		// TO
		EmpDTO emp=new EmpDTO();
		emp.setEid(rs.getString(1));
		emp.setEname(rs.getString(2));
		return emp;
	}
	   
   });
}

public EmpDTO getById(int id) {
	String query1="select * from emp_det where eid=?";
	return jdbc.queryForObject(query1,new Object[]{id}, new BeanPropertyRowMapper<EmpDTO>(EmpDTO.class));
}

public int delete(int id) {
	String delete="delete from emp_det where eid='"+id+"'";
	return jdbc.update(delete);
}
}
