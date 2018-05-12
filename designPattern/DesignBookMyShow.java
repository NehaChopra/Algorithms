
//https://practice.geeksforgeeks.org/problems/design-bookmyshow
/*
 * How to implement seat booking process? How to handle the cases where two persons are trying to access the same seat almost same time?  Write class based solution asking about different functions that should be used to solve all the cases for booking procedure.
 */

/*
 * Note: While answering design pattern questions, it is expected from you to provide the Data Structure that would be best suited, different classes & relationships between them, etc. You need not provide the whole code in your answer (unless explicitly told to do so). 
 */

package designPattern;

class DesignBookMyShow {

}

How to implement seat booking process?

Solution :

The Main Classes to be used for the user personas :

User
Movie
Theater
Booking
Address
Facilities
// Java skeleton code to design an online movie
// booking system.
Enums :
 
    public enum SeatStatus {
    SEAT_BOOKED,
    SEAT_NOT_BOOKED;
}
 
public enum MovieStatus {
    Movie_Available,
    Movie_NotAvailable;
}
 
public enum MovieType {
    ENGLISH,
    HINDI;
}
 
public enum SeatType {
    NORMAL,
    EXECUTIVE,
    PREMIUM,
    VIP;
}
 
public enum PaymentStatus {
    PAID,
    UNPAID;
}
 
class User {
 
    int userId;
    String name;
    Date dateOfBirth;
    String mobNo;
    String emailId;
    String sex;
}
 
class Movie {
 
    int movieId;
    int theaterId;
    MovieType movieType;
    MovieStatus movieStatus;
}
 
class Theater {
 
    int theaterId;
    String theaterName;
    Adress adress;
 
    List<Movie> movies;
    float rating;
}
 
class Booking {
    int bookingId;
    int userId;
    int movieId;
    List<Movie> bookedSeats;
    int amount;
    PaymentStatus status_of_payment;
    Date booked_date;
    Time movie_timing;
}
 
class Address {
 
    String city;
    String pinCode;
    String state;
    String streetNo;
    String landmark;
}
This is an OOP design question, so full code is not required. The above code has classes and attributes only. In the above code, as you can see enums are self-explanatory.
We have users class in which users details are kept.
Theater class in which name of the theater, it’s address and list of movies currently running are kept.
Booking class lets you book the seat in a particular theater. It keeps a reference in Movie, Payment class.

How to handle the cases where two persons are trying to access the same seat almost same time?

Lets take SeatBook and Transactions class which will be called from the main class. Here from the above code, We expand a bit the payment process which is not shown in the above code. In SeatBook class we will have reference to Transaction class also.

Now to ensure when two persons are trying to access the same seat almost at the same time then we would use Synchronized method of Thread class and will call a thread belong to each log in user.

Class SeatBook
{
    Transaction transaction_obj;
    bool seats[total_seats];
    String place;
    String ticketType;
 
    bool check_availability();
 
    int  position_of_seat()
    {
        return seat_pos_in_theator;
    }
 
    void multiple tickets();
 
    void final_booking()
    {
        place = positon_of_seat();
        if (single_ticket)
            continue;
        else
            mutliple_ticket_booking();
 
        Transaction_obj.pay(ticketType, seats_booked, place);
    }
}