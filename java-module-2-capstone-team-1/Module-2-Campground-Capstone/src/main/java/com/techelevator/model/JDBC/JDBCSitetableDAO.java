package com.techelevator.model.JDBC;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.DateFormatSymbols;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Sitetable;
import com.techelevator.model.DAO.SitetableDAO;

public class JDBCSitetableDAO implements SitetableDAO
{
	private JdbcTemplate jdbcTemplate;

	public JDBCSitetableDAO(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	Scanner in = new Scanner(System.in);

	@Override
	public void getAllSites(String cChoice) 
	{
		String sChoice = null;
		Sitetable siteResult;
		int validate = 0;
		int i = 1;
		System.out.printf("\n\n%s", "Please select a camp site to reserve:\n");
		System.out.printf("\t\n%-30s%-35s%-30s%-35s%-30s\n", "Site ID", "Max Occupancy", "\u267F", "Max RV Length", "Utilities");
	
			String sqlGetAllSites = "SELECT * FROM site where campground_id =" + cChoice + " ";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllSites);

			while (results.next())
			{
				siteResult=mapRowToSites(results);
				
				System.out.printf("\n%-35d%-35d%-30b%-35d%-30b\n",siteResult.getSite_Id(),siteResult.getMax_Occupancy(),siteResult.getAccessible()
																			,siteResult.getMax_rv_length(),siteResult.getUtilities());
				i++;
			
			}
		}
			
	

	


	/*
	 * private Long site_Id; private int campground_Id; private int site_Number;
	 * private int max_Occupancy; private Boolean accessible; private int
	 * max_rv_length; private Boolean utilities;
	 */
	private Sitetable mapRowToSites(SqlRowSet results)
	{
		Sitetable sitetable = new Sitetable();
		sitetable.setSite_Id(results.getLong("site_Id"));
		sitetable.setCampground_Id(results.getInt("campground_Id"));
		sitetable.setSite_Number(results.getInt("site_number"));
		sitetable.setMax_Occupancy(results.getInt("max_Occupancy"));
		sitetable.setAccessible(results.getBoolean("accessible"));
		sitetable.setMax_rv_length(results.getInt("max_rv_length"));
		sitetable.setUtilities(results.getBoolean("utilities"));

		return sitetable;
	}
	public int siteCount(String cChoice)
	{
		int count = 0;
		String sqlGetcampInfo = "select count(campground_id) as total from site where campground_id="+cChoice+";";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetcampInfo);
		if (results.next())
		{
			count = results.getInt(1);
		}
		return count;
	}
	

	

}
