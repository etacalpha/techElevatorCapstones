package com.techelevator.model.DAO;

import java.util.List;

import com.techelevator.model.Reservation;

public interface ReservationDAO
{
	public List<Reservation> getAllReservations();
	public void confirmReservation(String pChoice, String cChoice, String sChoice);
}
