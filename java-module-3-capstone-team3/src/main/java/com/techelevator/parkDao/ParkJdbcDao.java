package com.techelevator.parkDao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Park;
import com.techelevator.model.Survey;


@Component
public class ParkJdbcDao implements ParkDao
{

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ParkJdbcDao(DataSource datasource)
	{
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public List<Park> getAllParks()
	{
		List<Park> allParks = new ArrayList<>();
		String allParksSql = "SELECT * FROM park ORDER BY parkname";
		SqlRowSet results = jdbcTemplate.queryForRowSet(allParksSql);
		while (results.next())
		{
			allParks.add(mapRowToPark(results));
		}
		return allParks;
	}
	
	@Override
	public Park getParkDetail(String parkcode) {
		String parkDetailSql = "SELECT * FROM park WHERE parkcode = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(parkDetailSql, parkcode);
		Park park = new Park();
		while (result.next())
		{
		
		park = mapRowToPark(result);
		}
		return park;
	}
	
	@Override
	public List<Park> getPopularParks() {
		List<Park> popularParks = new ArrayList<>();
		String allParksSql = "SELECT park.*, COUNT(park.parkcode) as survey_count "
						   + " FROM park "
						   + " JOIN survey_result"
						   + " ON park.parkcode = survey_result.parkcode"
						   + " GROUP BY park.parkcode"
						   + " ORDER BY survey_count DESC"
						   + " LIMIT 5";
		SqlRowSet results = jdbcTemplate.queryForRowSet(allParksSql);
		while (results.next())
		{
			popularParks.add(mapRowToPark(results));
			System.out.println(results);
		}
		return popularParks;
	}
	@Override
	public void saveNewSurvey(Survey survey)
	{
		String saveSurveySql="insert into survey_result (parkcode, emailaddress, state, activitylevel) values (?,?,?,?);";
		jdbcTemplate.update(saveSurveySql, survey.getParkcode(), 
										   survey.getEmailaddress(),
										   survey.getState(),
										   survey.getActivitylevel());

	}

	private Park mapRowToPark(SqlRowSet results)
	{
		Park parks = new Park();

		parks.setParkcode(results.getString("parkcode"));
		parks.setParkdescription(results.getString("parkdescription"));
		parks.setParkname(results.getString("parkname"));
		parks.setState(results.getString("state"));
		parks.setAcreage(results.getInt("acreage"));
		parks.setElevationinfeet(results.getInt("elevationinfeet"));
		parks.setMilesoftrail(results.getFloat("milesoftrail"));
		parks.setNumberofcampsites(results.getInt("numberofcampsites"));
		parks.setClimate(results.getString("climate"));
		parks.setYearfounded(results.getInt("yearfounded"));
		parks.setInspirationalquote(results.getString("inspirationalquote"));
		parks.setInspirationquotesource(results.getString("inspirationalquotesource"));
		parks.setEntryfee(results.getInt("entryfee"));
		parks.setNumberofanimalspecies(results.getInt("numberofanimalspecies"));
		parks.setAnnualvisitorcount(results.getInt("annualvisitorcount"));

		return parks;
	}

	

}
