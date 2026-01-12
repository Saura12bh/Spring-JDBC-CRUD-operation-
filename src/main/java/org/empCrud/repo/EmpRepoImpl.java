package org.empCrud.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.empCrud.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("empRepo")
public class EmpRepoImpl implements EmpRepo {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int addEmp(Emp e) {
		return jdbcTemplate.update("insert into emp values(?,?,?)",
				new Object[] { e.getEid(), e.getName(), e.getSal() });
	}

	@Override
	public int deleteEmp(int eid) {
		return jdbcTemplate.update("delete from emp where eid=?",
				new Object[] { eid});
	}

	@Override
	public int updateEmp(Emp e) {
		return jdbcTemplate.update("update emp set name=?,sal where eid=?",
				new Object[] {e.getName(), e.getSal(),e.getEid()});
	}

	@Override
	public List<Emp> viewEmp() {
		List<Emp> list=new ArrayList<>();
		list=jdbcTemplate.query("select * from emp",
				
				new RowMapper<Emp>()
		{
				//rowMapper functional interface ahe  method ->mapRow
			@Override
			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
				Emp e=new Emp();
				e.setEid(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSal(rs.getInt(3));
				return e;
			}
		}
				);
		return list;
	}

}
