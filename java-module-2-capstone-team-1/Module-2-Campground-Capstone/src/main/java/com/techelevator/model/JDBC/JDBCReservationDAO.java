package com.techelevator.model.JDBC;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.mockito.internal.verification.AtLeast;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Reservation;
import com.techelevator.model.DAO.ReservationDAO;

public class JDBCReservationDAO implements ReservationDAO
{
	private JdbcTemplate jdbcTemplate;

	public JDBCReservationDAO (DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Reservation> getAllReservations()
	{
		List<Reservation> allReservations = new ArrayList<>();
		String sqlGetAllReservations = "SELECT * , FROM reservation";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllReservations);
		while (results.next())
		{
			Reservation parkResult = mapRowToParks(results);
			allReservations.add(parkResult);
		}
		return allReservations;
	}
	
	public void confirmReservation(String pChoice, String cChoice, String sChoice)
	{
		String parkName = "Select name from park where park_id="+pChoice+";";
		String campground ="Select name from campground where park_id=+"+pChoice+" and campground_id ="+cChoice+";";
		String site ="Select site_id from site where campground_id="+sChoice+";";
		SqlRowSet rParkName= jdbcTemplate.queryForRowSet(parkName);
		SqlRowSet rcampground = jdbcTemplate.queryForRowSet(campground);
		SqlRowSet rSite = jdbcTemplate.queryForRowSet(site);
		System.out.println(" You want to make a reservation for"+rParkName+" at campground"+campground+" for site "+rSite);
		
	}
	
	
	
	
	private Reservation mapRowToParks(SqlRowSet results)
	{
		Reservation reservations = new Reservation();
		reservations.setReservation_id(results.getLong("reservation_id"));
		reservations.setSite_id(results.getInt("site_id"));
		reservations.setName(results.getString("name"));
		reservations.setFrom_date(results.getDate("from_date"));
		reservations.setTo_date(results.getDate("to_date"));
		reservations.setCreate_date(results.getDate("create_date"));

		return reservations;
	}
	
	
}
