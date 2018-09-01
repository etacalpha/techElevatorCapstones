package com.techelevator.model.JDBC;

import java.text.DateFormatSymbols;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Campground;
import com.techelevator.model.DAO.CampgroundDAO;

public class JDBCCampgroundDAO extends Campground implements CampgroundDAO
{
	private JdbcTemplate jdbcTemplate;

	public JDBCCampgroundDAO(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	Scanner in = new Scanner(System.in);

	@Override
	public void getAllCampgrounds(String pChoice)
	{
		String cChoice = null;
		String campResult;

		int i = 1;
		//while (cChoice == null)
		{
			String sqlGetAllCamps = "SELECT * FROM campground where park_id =" + pChoice + " ";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllCamps);
			System.out.printf("\n\n%s", "Please select a campground :");
			while (results.next())
			{
				campResult = results.getString("name");
				System.out.println("\n" + i + ") " + campResult);
				i++;
			}
		}
	}

	public void displayCampInfo(String pChoice, String cChoice)
	{
		Campground campResults = new Campground();
		String sqlGetCampInfo = "Select * from campground where campground_id =" + cChoice + "and park_id =" + pChoice
				+ ";";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetCampInfo);
		System.out.printf("\t\n%-30s%-22s%-35s%-35s\n", "Camp Name", "Open from", "Open to", "Daily Fee");

		while (results.next())
		{
			campResults = mapRowToCampground(results);

		}
		System.out.printf("\n\t%-30s%-22s%-35s$%-35.2f\n", campResults.getName(),
				/*dateFormat(campResults.getOpen_from_mm())*/campResults.getOpen_from_mm(), /*dateFormat(campResults.getOpen_to_mm())*/campResults.getOpen_to_mm(),
				campResults.getDaily_fee());

	}

	private Campground mapRowToCampground(SqlRowSet results)
	{
		Campground campground = new Campground();
		campground.setCampground_id(results.getLong("campground_id"));
		campground.setName(results.getString("name"));
		campground.setPark_id(results.getInt("park_id"));
		campground.setOpen_from_mm(results.getString("open_from_mm"));
		campground.setOpen_to_mm(results.getString("open_to_mm"));
		campground.setDaily_fee(results.getBigDecimal("daily_fee"));

		return campground;
	}

	public int campCount(String pChoice)
	{
		int count = 0;
		String sqlGetcampInfo = "select count(campground_id) as total from campground where park_id ="+pChoice+";";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetcampInfo);
		if (results.next())
		{
			count = results.getInt(1);
		}
		return count;
	}

	private String dateFormat(String date)
	{
		System.out.println(date);
		int ndate = Integer.parseInt(date);
		return new DateFormatSymbols().getMonths()[ndate -1];

	}

}
