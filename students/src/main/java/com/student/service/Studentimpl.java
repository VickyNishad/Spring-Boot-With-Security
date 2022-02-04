package com.student.service;

//import java.lang.StackWalker.Option;
//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.student.dao.StudentDao;
import com.student.details.StudentDetails;

@Service
public class Studentimpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
//	List<StudentDetails> list;
	
	public Studentimpl()
	{
//		list = new ArrayList<>();
//		list.add(new StudentDetails(001, "om gupta"));
//		list.add(new StudentDetails(002, "Rajesh kumar"));
//		list.add(new StudentDetails(003, "Rishikesh kumar"));
	}

	@Override
	public List<StudentDetails> getDetails() {
		// TODO Auto-generated method stub
//		return list;
		return studentDao.findAll();
	}

	@Override
	public StudentDetails addStudentDetails(StudentDetails details) {
		// TODO Auto-generated method stub
		
//		list.add(details);
//		return details;
		studentDao.save(details);
		return details;
	}

	public Optional<StudentDetails> getStudent(long id) {
		// TODO Auto-generated method stub
//		StudentDetails  Id= null;
//		for(StudentDetails itemDetails : list)
//		{
//			if(itemDetails.getStudent_Id() == id)
//			{
//				Id = itemDetails;
//				break;
//			}
//		}
//		return id;
//		 studentDao.getById(id);
		return studentDao.findById(id);
	}

	@Override
	public StudentDetails updateDetails(StudentDetails details) {
		// TODO Auto-generated method stub
//		list.forEach(e->{
//			if(e.getStudent_Id() == details.getStudent_Id())
//			{
//				e.setStudent_Id(details.getStudent_Id());
//				e.setStudent_Name(details.getStudent_Name());
//				
//			}
//		});
		studentDao.save(details);
		return details;
	}

	
	
	public List<StudentDetails> finddetailsWithSorting(String field)
	{
		return studentDao.findAll(Sort.by(Sort.Direction.ASC,field));
	}

	
	

	@Override
	public void deleteDetails(Long parLong) {
		// TODO Auto-generated method stub
//		list = this.list.stream().filter(e->e.getStudent_Id()!=parLong).collect(Collectors.toList());
		StudentDetails details =studentDao.getById(parLong);
		studentDao.delete(details);
	}

	public Page<StudentDetails> finddetailsByPagenation(int offset, int pagesize) {
		// TODO Auto-generated method stub
		return studentDao.findAll(PageRequest.of(offset, pagesize));
	}

	public Page<StudentDetails> findDetailsByPagenationAndSorting(int offset, int pagesize, String field) {
		// TODO Auto-generated method stub
		return studentDao.findAll(PageRequest.of(offset, pagesize, Sort.by(Sort.Direction.ASC,field)));
	}
	
	
	

}
