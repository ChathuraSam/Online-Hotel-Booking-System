package com.hcl.ohbs.dao;

import java.sql.*;
import java.util.*;
import com.hcl.ohbs.entities.Hotel;
import com.hcl.ohbs.entities.HotelOwner;

public class HotelDAO {
	
	public boolean addHotel(Hotel hotel) {
		Connection con = null;
        PreparedStatement pstmt = null;       
        try{
            con = DBConnection.getConnection();
            String query = "INSERT INTO hotel(name,city,phone_number,address,status,maximum_capacity,available_capacity,hotel_owner_id,category,features,price) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,hotel.getName());
            pstmt.setString(2,hotel.getCity());
            pstmt.setString(3,hotel.getPhoneNumber());
            pstmt.setString(4,hotel.getAddress());
            pstmt.setString(5,hotel.getStatus());
            pstmt.setInt(6,hotel.getMaximum_capacity());
            pstmt.setInt(7,hotel.getAvailable_capacity());
            pstmt.setInt(8,hotel.getHotelOwner().getId());
            pstmt.setString(9,hotel.getCategory());
            pstmt.setString(10,hotel.getFeatures());
            pstmt.setDouble(11,hotel.getPrice());
            int n = pstmt.executeUpdate();
		return n>0?true:false;   
        }catch(ClassNotFoundException e1){
            e1.printStackTrace();
        }catch(SQLException e2){
            e2.printStackTrace();
        }finally{
            try{
                if(pstmt!=null)
                    pstmt.close();
                if(con!=null)
                    con.close();                       
            }catch(SQLException e3){
            	e3.printStackTrace();
            }
        }
        return false;
	}
	
	public List<Hotel> findHotelByName(String name){
		
		List<Hotel> hotels = new ArrayList<Hotel>();
		try{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

			con = DBConnection.getConnection();
			String query = "select name,city,phone_number,address,status,maximum_capacity,available_capacity,hotel_owner_id,category,features,price from hotel where name like '"+name+"%'";
			st = con.createStatement();
			
			rs = st.executeQuery(query);
			if(rs.next()){
				Hotel h = new Hotel(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),new HotelOwner(rs.getInt(8)),rs.getString(9),rs.getString(10),rs.getDouble(11));
				hotels.add(h);
				
			}
	    }catch(ClassNotFoundException e1){
	            e1.printStackTrace();
	    }catch(SQLException e2){
	            e2.printStackTrace();
	    }
	    return hotels;
	}
	
	public List<Hotel> findHotelByCity(String city){
		List<Hotel> list =new ArrayList<>();
		try{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

			con = DBConnection.getConnection();
			String query = "select name,city,phone_number,address,status,maximum_capacity,available_capacity,hotel_owner_id,category,features,price from hotel where CITY=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, city);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Hotel h = new Hotel(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),new HotelOwner(rs.getInt(8)),rs.getString(9),rs.getString(10),rs.getDouble(11));
				list.add(h);
				
			}
	    }catch(ClassNotFoundException e1){
	            e1.printStackTrace();
	    }catch(SQLException e2){
	            e2.printStackTrace();
	    }
	    return list;
	}
	
	public Hotel findHotelDetailsByName(String name){
		System.out.println("Begin findHotelDetailsByName: Name=" + name);
		try{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

			con = DBConnection.getConnection();
			String query = "select * from hotel where name like '"+name+"%'";
			st = con.createStatement();
			
			rs = st.executeQuery(query);
			if(rs.next()){
				Hotel h = new Hotel(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),new HotelOwner(rs.getInt(9)),rs.getString(10),rs.getString(11),rs.getDouble(12));
				System.out.println("End findHotelDetailsByName: Hotel=" + h);
				return h;				
			}
	    }catch(ClassNotFoundException e1){
	            e1.printStackTrace();
	    }catch(SQLException e2){
	            e2.printStackTrace();
	    }
		System.out.println("End findHotelDetailsByName: Hotel=null");
	    return null;
	}
	
	public int getIdByName(String hotelName) {
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = DBConnection.getConnection();
            String query = "SELECT id FROM hotel WHERE name=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, hotelName);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        }catch(ClassNotFoundException e1){
            e1.printStackTrace();
        }catch(SQLException e2){
            e2.printStackTrace();
        }finally{
            try{
                if(pstmt!=null)
                    pstmt.close();
                if(con!=null)
                    con.close();
            }catch(SQLException e3){
                e3.printStackTrace();
            }
        } 
        return 0;
	}
	
	public int getMaxCapacityById(int id) {
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = DBConnection.getConnection();
            String query = "SELECT maximum_capacity FROM hotel WHERE id=?";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()){
          
                return rs.getInt(1);
                
            }
        }catch(ClassNotFoundException e1){
            e1.printStackTrace();
        }catch(SQLException e2){
            e2.printStackTrace();
        }finally{
            try{
                if(pstmt!=null)
                    pstmt.close();
                if(con!=null)
                    con.close();
            }catch(SQLException e3){
                e3.printStackTrace();
            }
        } 
        return 0;
	}
	
	public int getAvailableCapacityById(int id) {
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = DBConnection.getConnection();
            String query = "SELECT available_capacity FROM hotel WHERE id=?";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
                
            }
        }catch(ClassNotFoundException e1){
            e1.printStackTrace();
        }catch(SQLException e2){
            e2.printStackTrace();
        }finally{
            try{
                if(pstmt!=null)
                    pstmt.close();
                if(con!=null)
                    con.close();
            }catch(SQLException e3){
                e3.printStackTrace();
            }
        } 
        return 0;
	}
	

	public List<Hotel> findHotelByOwnerId(int ownerId){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Hotel> list = null;
		try{
			con = DBConnection.getConnection();
			String query = "select name,city,phone_number,address,status,maximum_capacity,available_capacity,hotel_owner_id,category,features,price from hotel where hotel_owner_id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ownerId);
			rs = pstmt.executeQuery();
			list = new ArrayList<>();
			while(rs.next()){
				Hotel h = new Hotel(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),new HotelOwner(rs.getInt(8)),rs.getString(9),rs.getString(10),rs.getDouble(11));
				list.add(h);				
			}
	    }catch(ClassNotFoundException e1){
	            e1.printStackTrace();
	    }catch(SQLException e2){
	            e2.printStackTrace();
	    }finally{
            try{
                if(pstmt!=null)
                    pstmt.close();
                if(con!=null)
                    con.close();
                if(rs!=null)
                    rs.close();
            }catch(SQLException e) {
            
            }
	    }
       return list;
    }


	public List<Hotel> getAllHotels() {
		Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        List<Hotel> hotels = new ArrayList<>();
        System.out.println("inside get all hotels");
        try{
            con = DBConnection.getConnection();
            String query = "SELECT * FROM hotel";
            st = con.createStatement();
            rs = st.executeQuery(query);
            
           while(rs.next()) {
        	   Hotel h = new Hotel(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
        	   hotels.add(h);
        	   System.out.println(h);
           }
          
          }catch(ClassNotFoundException e1){
            e1.printStackTrace();
        }catch(SQLException e2){
            e2.printStackTrace();
        }finally{
            try{
                if(rs!=null)
                    rs.close();
                if(con!=null)
                    con.close();

            }catch(SQLException e3){
                e3.printStackTrace();
            }
        } 
        return hotels;
	}  

	public String getNameById(int id) {
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = DBConnection.getConnection();
            String query = "SELECT name FROM hotel WHERE id=?";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
        }catch(ClassNotFoundException e1){
            e1.printStackTrace();
        }catch(SQLException e2){
            e2.printStackTrace();
        }finally{
            try{
                if(pstmt!=null)
                    pstmt.close();
                if(con!=null)
                    con.close();
            }catch(SQLException e3){
                e3.printStackTrace();
            }
        } 
        return null;
	}
	
	public double getPriceById(int id) {
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = DBConnection.getConnection();
            String query = "SELECT price FROM hotel WHERE id=?";
            pstmt = con.prepareStatement(query);
            pstmt.setDouble(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getDouble(1);
            }

        }catch(ClassNotFoundException e1){
            e1.printStackTrace();
        }catch(SQLException e2){
            e2.printStackTrace();
        }finally{
            try{

                if(rs!=null)
                    rs.close();
                if(pstmt!=null)
                    pstmt.close();
                if(con!=null)
                    con.close();
            }catch(SQLException e3){
                e3.printStackTrace();
            }
        } 
        return 0.0;
	}
}
