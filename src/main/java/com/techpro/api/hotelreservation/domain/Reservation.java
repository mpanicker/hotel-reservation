package com.techpro.api.hotelreservation.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

import java.util.Map;

/**
 * Created by manoj on 8/8/2019.
 */
public class Reservation {

    @JsonIgnore
    @Id
    public String id;

    public String bookingNumber;

    //Start of JSON format
    public String check_in_date;
    public String check_out_date;
    public Integer num_of_guest;
    public Integer num_of_rooms;
    public Double reservation_total_price;
    public String reservation_currency;
    public Double reservation_tax;
    public String payment_method;
    public Map<String, String> hotel_details;

    public Map<String, String> payment_details;

    public Map<String, String> room_details;

    public Map<String, String> primary_guest_details;
    //End of JSON format


    public Reservation(String bookingNumber, Integer num_of_guest, Integer num_of_rooms) {
        this.num_of_guest = num_of_guest;
        this.num_of_rooms = num_of_rooms;
        this.bookingNumber = bookingNumber;
    }

    public Reservation(){

    }

    @Override
    public String toString() {
        return String.format(
                "Reservation[id=%s, Number of Rooms='%s', Number of Guests='%s']",
                id, num_of_rooms, num_of_guest);
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public String getCheck_in_date() {
        return check_in_date;
    }

    public void setCheck_in_date(String check_in_date) {
        this.check_in_date = check_in_date;
    }

    public String getCheck_out_date() {
        return check_out_date;
    }

    public void setCheck_out_date(String check_out_date) {
        this.check_out_date = check_out_date;
    }

    public Double getReservation_total_price() {
        return reservation_total_price;
    }

    public void setReservation_total_price(Double reservation_total_price) {
        this.reservation_total_price = reservation_total_price;
    }

    public String getReservation_currency() {
        return reservation_currency;
    }

    public void setReservation_currency(String reservation_currency) {
        this.reservation_currency = reservation_currency;
    }

    public Double getReservation_tax() {
        return reservation_tax;
    }

    public void setReservation_tax(Double reservation_tax) {
        this.reservation_tax = reservation_tax;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public Map<String, String> getHotel_details() {
        return hotel_details;
    }

    //handled in ReservationService
    public void setHotel_details(Map<String, String> hotel_details) {
        this.hotel_details = hotel_details;
    }

    public Map<String, String> getPayment_details() {
        return payment_details;
    }

    public void setPayment_details(Map<String, String> payment_details) {
        this.payment_details = payment_details;
    }

    public Map<String, String> getRoom_details() {
        return room_details;
    }

    public void setRoom_details(Map<String, String> room_details) {
        this.room_details = room_details;
    }

    public Integer getNum_of_guest() {
        return num_of_guest;
    }

    public void setNum_of_guest(Integer num_of_guest) {
        this.num_of_guest = num_of_guest;
    }

    public Integer getNum_of_rooms() {
        return num_of_rooms;
    }

    public void setNum_of_rooms(Integer num_of_rooms) {
        this.num_of_rooms = num_of_rooms;
    }

    public Map<String, String> getPrimary_guest_details() {
        return primary_guest_details;
    }

    public void setPrimary_guest_details(Map<String, String> primary_guest_details) {
        this.primary_guest_details = primary_guest_details;
    }
}
