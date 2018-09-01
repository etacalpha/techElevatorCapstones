package com.techelevator.model.JDBC;

import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Park;
import com.techelevator.model.DAO.ParkDAO;

public class JDBCParkDAO implements ParkDAO
{
	private JdbcTemplate jdbcTemplate;

	public JDBCParkDAO(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	Scanner in = new Scanner(System.in);

	public void getAllParks()
	{
		String parkResult;
		int i = 1;
		String sqlGetAllParks = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllParks);
		while (results.next())
		{
			parkResult = results.getString("name");
			System.out.println("\n"+i + ") " + parkResult);
			i++;
		}
	}

	public void displayParkInfo(String pChoice)
	{
		Park parkResults = new Park();
		String sqlGetParkInfo = "Select * from park where park_id =" + pChoice + ";";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetParkInfo);
		while (results.next())
		{
			parkResults = mapRowToParks(results);
		}
		System.out.printf("\t%-22s%-22s%-30s%-22s%-35s\n", "name", "Location", "Established Date", "Area", "Visitors");
		System.out.printf("\n\t%-22s%-22s%-30s%-22s%-22s\n", parkResults.getName(), parkResults.getLocation(),
				parkResults.getEstablish_date(), parkResults.getArea(), parkResults.getVisitors());
		System.out.printf("\n\n\tDescription:\n");
		System.out.printf("\n\t\t%s",
				parkResults.getDescription().substring(0, parkResults.getDescription().length() / 4));
		System.out.printf("\n\t\t%s", parkResults.getDescription().substring(parkResults.getDescription().length() / 4,
				parkResults.getDescription().length() / 2));
		System.out.printf("\n\t\t%s", parkResults.getDescription().substring(parkResults.getDescription().length() / 2,
				parkResults.getDescription().length() - parkResults.getDescription().length() / 4));
		System.out.printf("\n\t\t%s", parkResults.getDescription()
				.substring(parkResults.getDescription().length() - parkResults.getDescription().length() / 4));

	}
	public int parkCount()
	{ 
		int count = 0;
		String sqlGetParkInfo = "select count(park_id) as total from park;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetParkInfo);
		if(results.next())
		{
			count = results.getInt(1);
		}
		return count;
	}

	private Park mapRowToParks(SqlRowSet results)
	{
		Park park = new Park();
		park.setPark_id(results.getLong("park_id"));
		park.setName(results.getString("name"));
		park.setLocation(results.getString("location"));
		park.setEstablish_date(results.getDate("establish_date"));
		park.setArea(results.getInt("area"));
		park.setVisitors(results.getInt("visitors"));
		park.setDescription(results.getString("description"));
		

		return park;
	}
	

}
