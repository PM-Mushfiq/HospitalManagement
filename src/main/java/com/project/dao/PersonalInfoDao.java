package com.project.dao;

import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.entity.Employee;

@Component
public class PersonalInfoDao 
{
	@Autowired
	SessionFactory sf;
	
	@Transactional
	public Employee info(String id)
	{
		try 
		{
			System.out.println("in PersonalInfoDao-info: got= "+id);
			
			Session session= sf.getCurrentSession();
			Query q1=session.createQuery("from Employee where eid= :id");
			q1.setParameter("id", id);
		
			Employee temp= (Employee) q1.uniqueResult();
			System.out.println("in PersonalInfoDao-info: found= "+temp);
			return temp;
		}
		catch(Exception e)
		{
			System.out.println("in PersonalInfoDao-info: "+e);
			return null;
		}

	}
}
