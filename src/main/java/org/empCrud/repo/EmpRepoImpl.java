package org.empCrud.repo;

import java.util.List;
import org.empCrud.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
		return 0;
	}

	@Override
	public int updateEmp(Emp e) {
		return 0;
	}

	@Override
	public List<Emp> viewEmp() {
		return null;
	}

}
