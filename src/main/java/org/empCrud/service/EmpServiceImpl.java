package org.empCrud.service;

import java.util.List;

import org.empCrud.model.Emp;
import org.empCrud.repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("empService")
public class EmpServiceImpl implements EmpService {
    @Autowired
	EmpRepo empRepo;
	@Override
	public int addEmp(Emp e) {
		// TODO Auto-generated method stub
		return empRepo.addEmp(e);
	}

	@Override
	public int deleteEmp(int eid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateEmp(Emp e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Emp> viewEmp() {
		// TODO Auto-generated method stub
		return null;
	}

}
