package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.nt.model.Employee;
//import com.nt.model.Hospital;
import com.nt.model.Hospital;

@Repository
public class HospitalDaoImpl implements IHospitalDAO{
	
	  private static final String GET_HOS_BY_LOC="SELECT HNO,HNAME,TYPE,speciality FROM HOSPITAL WHERE LOCATION IN(?,?,?) ORDER BY LOCATION";
	    

	  @Autowired
	    private DataSource ds;//inject HikariDataSource class as a dependent class
	@Override
	public List<Hospital> showHospitalByLoc(String loc1, String loc2, String loc3) throws Exception {
	
		 List<Hospital> list=null;
	        try( //get Pooled jdbc con object
	                Connection con=ds.getConnection();
	                //create PreparedStatement object
	                PreparedStatement ps=con.prepareStatement(GET_HOS_BY_LOC);
	            ){
	                //set values to Queyr params
	                ps.setString(1, loc1);
	                ps.setString(2, loc2);
	                ps.setString(3, loc3);
	                //execute the Query
	                try(ResultSet rs=ps.executeQuery()){
	                    //copy ResultSET obj records to ArrayList Collection
	                    list=new ArrayList<Hospital>();
	                    
	                    while(rs.next()) {
	                    	Hospital hos=new Hospital(); //create emp class obj
	                        hos.setHno(rs.getInt(1)); //setting all values in emp class obj
	                        hos.setNnmae(rs.getString(2));
	                        hos.setType(rs.getString(3));
	                        hos.setSpeciality(rs.getString(4));
	                        list.add(hos);//adding emp obj into list collection
	                    }//while
	                }//try2
	            }//try1
	            catch(SQLException se) {
	                throw se; //Exception Rethrowing
	            }
	            catch(Exception e) {
	                throw e;
	            }
		return list;
	}

}
