package com.techelevator.control;


import java.util.Scanner;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.model.DAO.*;
import com.techelevator.model.JDBC.*;

public class CampgroundCLI
{
	private String pChoice=null; // variable to save Scanner.in on order to process selection
	private String cChoice=null;
	private String sChoice=null;
	private ParkDAO parkDAO;
	private CampgroundDAO campgroundDAO;
	private SitetableDAO sitetableDAO;
	private ReservationDAO reservationDAO;
	
	public static void main(String[] args) throws Exception
	{
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		while (true)
		{	
		CampgroundCLI application = new CampgroundCLI(dataSource);
		application.run();
		}
	}

	public CampgroundCLI(DataSource datasource)
	{

		// create your DAOs here
		parkDAO = new JDBCParkDAO(datasource);
		campgroundDAO = new JDBCCampgroundDAO(datasource);
		sitetableDAO = new JDBCSitetableDAO(datasource);
		reservationDAO = new JDBCReservationDAO(datasource);
	}

	
	
	
	
	public void run() throws Exception
	{			
		mainmenu();
		while(true)
		{
			choseParkMenu();
			if (pChoice.equals(Integer.toString(parkDAO.parkCount()+1)))
			{
				break;
			}
			parkDAO.displayParkInfo(pChoice);
	
			choseCampMenu();
			if (cChoice.equals(Integer.toString(campgroundDAO.campCount(cChoice)+1)))
			{
				break;
			}
			campgroundDAO.displayCampInfo(pChoice, cChoice);
			
			choseSiteToReserve(cChoice);
			if (sChoice.equals(Integer.toString(sitetableDAO.siteCount(cChoice)+1)))
			{
				break;
			}
			reservationDAO.confirmReservation(pChoice, cChoice, sChoice);

			// method to get input for reservation
			//method to push reservation to dataBase and return confirmation number
			
		}
	}
	
	private String choseParkMenu()
	{
		int validate =0;
		while (pChoice == null)
		{
			Scanner in = new Scanner(System.in);
			parkDAO.getAllParks();
			System.out.println("\n"+(parkDAO.parkCount()+1)+") Return to Main");
			try
			{
				validate = in.nextInt();
				if (validate  <=0 || validate >parkDAO.parkCount()+1)
				{
					System.out.printf("Invalid Selection please try again\n");
					throw new Exception();
				} 
				if (validate == parkDAO.parkCount()+1)
				{
					pChoice="4";
					break;
				}
				else
				pChoice = Integer.toString(validate);

			} catch (Exception InputMismatchException )
			{
				pChoice =null;
			}
		}
		return 	pChoice = Integer.toString(validate);
	}
	
	
	
	private String choseCampMenu()
	{
		int validate =0;
		while (cChoice == null)
		{
			Scanner in = new Scanner(System.in);
			campgroundDAO.getAllCampgrounds(pChoice);
			System.out.println("\n"+(campgroundDAO.campCount(pChoice)+1)+") Return to Main");
			try
			{
				validate = in.nextInt();
				if (validate  <=0 || validate >campgroundDAO.campCount(pChoice)+1)
				{
					System.out.printf("Invalid Selection please try again\n");
					throw new Exception();
				} 
				if (validate == campgroundDAO.campCount(pChoice)+1)
				{
					cChoice=Integer.toString(campgroundDAO.campCount(pChoice)+1);
					break;
				}
				else
				cChoice = Integer.toString(validate);

			} catch (Exception InputMismatchException )
			{
				cChoice =null;
			}
		}
		if (pChoice.equals("1"))
		{
			return 	cChoice = Integer.toString(validate);

		}else if (pChoice.equals("2")) 
		{
			validate+=3;
			return 	cChoice = Integer.toString(validate);
		}
		validate=+4;
		
		return 	cChoice = Integer.toString(validate);
	}
	
	private String choseSiteToReserve(String cChoice) 
	{
		int validate =0;
		while (sChoice == null)
		{
			Scanner in = new Scanner(System.in);
			sitetableDAO.getAllSites(cChoice);
			System.out.println("\n"+(sitetableDAO.siteCount(cChoice)+1)+") Return to Main");
			try
			{
				validate = in.nextInt();
				if (validate  <=0 || validate >sitetableDAO.siteCount(cChoice)+1)
				{
					System.out.printf("Invalid Selection please try again\n");
					throw new Exception();
				} 
				if (validate == sitetableDAO.siteCount(cChoice)+1)
				{
					sChoice=Integer.toString(sitetableDAO.siteCount(cChoice)+1);
					break;
				}
				else
				sChoice = Integer.toString(validate);

			} catch (Exception InputMismatchException )
			{
				sChoice =null;
			}
		}
		return 	sChoice = Integer.toString(validate);
	}
	

	
	
	
	public void mainmenu()
	{
		
		System.out.println(" _       _         _ ");
		System.out.println("| |     | |       | |");
		System.out.println("| | _ _ | |  ___  | |   ___   ___  ___ __ __   ___ ");
		System.out.println("| |  |  | |// _ \\ | | // __|// _ \\|  '_ ` _ \\// _ \\    ");
		System.out.println("||  | |  ||   __/ | |   (__   (_) | | | | | |   __/ ");
		System.out.println("|___| |___|\\\\___| |_|\\\\____|\\\\___/|_| |_| |_|\\\\___| ");
		System.out.println("  ______             ");
		System.out.println(" |__  __|              ");
		System.out.println("   |  |");
		System.out.println("   |  |   ___     ");
		System.out.println("   |__| // _ \\\\ ");
		System.out.println("        | (_) |   ");
		System.out.println("        \\\\___// ");
		System.out.println("  _ ___               _   __ __________ ____                            _");
		System.out.println(" | '_  \\  ___        | | / / _________/   __|         ___              | |           ");
		System.out.println(" | |_ ) |/   \\   ___ | |/ /___________\\  \\      ___  /   \\   ___   ___ | |____     ");
		System.out.println(" | .___/| ( ) |/ '__||    |____________\\  \\  //  _ \\| ( ) |/  __|/  __||  __  |      ");
		System.out.println(" | |    |  _  || |   | |\\  \\________\\ \\_\\  \\ |   __/|  _  || |   | (__ | |  | |        ");
		System.out.println(" |_|    |_| |_||_|   |_| \\__\\________\\ ___ / \\\\___| |_| |_||_|    \\___||_|  |_|    ");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println(
				"        ……………………….._,,-~’’’¯¯¯’’~-,,…………………………………………………………………………………………………………………………………………………………………    ");
		System.out.println(
				"    ……………………..,-‘’ ; ; ;_,,---,,_  …………………………………………………………………………………………………………………………………………………………                  ");
		System.out.println(
				"    ………………..,-‘’ ; ; ;_,,---,,_ ; ;’’-,…………………………….._,,,---,,   _______... ,,-~’’’¯¯¯’’’’,, ");
		System.out.println("    ……………….,’ ; ; ;,-‘ , , , , , ‘-, ; ;’-,,,,---~~’’’’’’~--,,,_…..,,-~’’ ; ; ; ;__;’-, ");
		System.out.println(
				"    ……………….| ; ; ;,’ , , , _,,-~’’ ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ¯’’~’-,,_ ,,-~’’ , , ‘, ;’, ");
		System.out.println(
				"    ……………….’, ; ; ‘-, ,-~’’ ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ;’’-, , , , , ,’ ; | ");
		System.out.println(
				"    …………………’, ; ;,’’ ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ;’-, , ,-‘ ;,-‘ ");
		System.out.println(
				"    ………………….,’-‘ ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ;’’-‘ ;,,-‘ ");
		System.out
				.println("    ………………..,’ ; ; ; ; ; ; ; ; ; ; ; ;__ ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ‘-,’ ");
		System.out.println(
				"    ……………… ,-‘ ; ; ; ; ; ; ; ; ; ;,-‘’¯: : ’’-, ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; _ ; ; ; ; ; ; ’, ");
		System.out.println(
				"    ……………..,’ ; ; ; ; ; ; ; ; ; ; ;    ()    : :| ; ; ; ; ; ; ; ; ; ; ; ; ,-‘’¯  : :’’-, ; ; ;’, ");
		System.out.println(
				"    …………….,’ ; ; ; ; ; ; ; ; ; ; ; ‘-,_: : _,-‘ ; ; ; ; ; ; ; ; ; ; ; ; | :      ()    :| ; ; ; | ");
		System.out.println(
				"    ……………, ’ ; ; ; ; ; ; ; ; ; ; ; ; ; ; ¯¯ ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ;’-,,_ : :,- ‘ ; ; ; ;| ");
		System.out.println(
				"    …………..,-‘ ; ; ; ; ; ; ; ; ; ; ; ; ; ; ,,-~’’ , , , , ,,   ~--~  ,, _ ; ; ;¯¯ ; ; ; ; ; ; ;| ");
		System.out.println(
				"    ………………,-‘ ; ; ; ; ; ; ; ; ; ; ; ; ; ; ;,’ , , , , , ,(           ) , , , ,’’-, ; ; ; ; ; ; ; ;");
		System.out.println(
				"    ……….,-‘ ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ;’, , , , , , ,  ’’~---~’’ , , , , , ,’ ; ; ; ; ; ; ; ;’, ");
		System.out.println(
				"    …….,-‘’ ; _, ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ‘’~-,,,,--~~’’’¯’’’~-,,_ , ,_,-‘ ; ; ; ; ; ; ; ; ; ‘, ");
		System.out.println(
				"    ….,-‘’-~’’,-‘ ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ; ;                  ,’; ,’’¯ ; ; ; ; ; ; ; ; ;  ");
		System.out.println(
				"    ……….,’ ; ;,-, ; ;, ; ; ;, ; ; ; ; ; ; ; ; ; ; ‘, ; ;’, . . . . .,’ ;,’ ; ; ; ;, ; ; ;,’-, ; ;,’  ");
		System.out.println(
				"    ………,’-~’ ,-‘-~’’ ‘, ,-‘ ‘, ,,- ; ; ; ; ; ; ; ; ‘, ; ; ‘~-,,,-‘’ ; ,’ ; ; ; ; ‘, ;,-‘’ ; ‘, ,-‘, ");
		System.out.println(
				"        ……….,-‘’ ; ; ; ; ; ‘’ ; ; ;’’ ; ; ; ; ; ; ; ; ; ; ‘’-,,_ ; ; ; _,-‘ ; ; ; ; ; ;’-‘’ ; ;  ");
		System.out.println("");
		System.out.println("");
		
		System.out.printf("\n\n1) List all Parks");
		System.out.printf("\n2) EXIT\n");
		
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		if (choice==1)
		{
			System.out.println("Thank You\n");
		}
		else
		{
			System.exit(0);
		}	
	}

	
	
}