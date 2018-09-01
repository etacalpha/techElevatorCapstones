package com.techelevator.park;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.Survey;
import com.techelevator.parkDao.ParkDao;
import com.techelevator.parkDao.WeatherDao;

@Controller
public class ParkController
{

	@Autowired
	private ParkDao parkDao;
	
	@Autowired
	private WeatherDao weatherDao;

	@RequestMapping(path = {"/", "/home"} , method = RequestMethod.GET)
	public String getAllParks(ModelMap modelHolder)
	{
		modelHolder.put("park", parkDao.getAllParks());
		return "home";
	}
	
	
	@RequestMapping(path="/detail", method=RequestMethod.GET)
	public String getParkDetail(@RequestParam String parkcode, ModelMap modelHolder, ModelMap weatherHolder) {
		modelHolder.put("park", parkDao.getParkDetail(parkcode));
		weatherHolder.put("weatherInfo", weatherDao.getParkWeather(parkcode));
		return "detail";
	}
	
	@RequestMapping(path ="/detail" , method = RequestMethod.POST)
	public String setUserTemp(String tempUnit, @RequestParam String parkcode, HttpSession userSession) {
		userSession.setAttribute("tempUnit", tempUnit);
		return "redirect:/detail?parkcode="+parkcode;
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String getSurveyForm(ModelMap modelHolder) {
		modelHolder.put("park", parkDao.getAllParks());

		return "survey";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String postSurveyInfo(@RequestParam String parkcode,
								 @RequestParam String state,
								 @RequestParam String emailaddress,
								 @RequestParam String activitylevel,
								 RedirectAttributes flashScope) 
	{
		Survey survey = new Survey();
		survey.setParkcode(parkcode);
		survey.setState(state);
		survey.setEmailaddress(emailaddress);
		survey.setActivitylevel(activitylevel);
		
		parkDao.saveNewSurvey(survey);
		
		flashScope.addFlashAttribute("message","Thank your for participating in the Daily Survey!!");

		return "redirect:/surveyResults";
	}
	
	@RequestMapping(path="/surveyResults", method=RequestMethod.GET)
	public String getSurveyResults(ModelMap modelHolder) {
		modelHolder.put("popularParks", parkDao.getPopularParks());
		return "surveyResults";
	}
	
	
	
	
}