# Flight_Scheduler

This is a Flight Scheduling application designed for the Fly-By-Night Airline, which has GUI interface and is Derby database driven application. The Airline has one or more flights per day but they are not by time. Every Flight will be available for each day the airline flies. The customer gets booked on a specific flight for a specific day. Each Flight has a name and a number of seats on the flight. Each date is just a specific day. The Customer is identified by a single name. The application design include four classes besides the the main GUI class, specifically Flight class, Day class, Booking class, and waitList class. Main implementations consist of the following user commands:

Book Customer Day Flight 
The customer will be assigned the flight for the requested day, if there are seats available. If seats are not available, the customer will be put on the wait list for that flight. The waiting list must be maintained in the order the customers tried to book their flights.

Status Flight Day 
The Status command for flight and day will display the customers that have been booked for that flight on that day.

Status Waiting List by Day 
The Status command for the Waitlist will display all the customers waiting for flights on the specified day.

Add Flight Seats 
Add a new flight to the system. The Flight name is a string and Seats is the number of seats in the flight.

Cancel Customer Day 
The booking for that Customer and Day must be removed from the flight’s bookings or the waiting list. If the booked entry is removed from a flights bookings, the waiting list must be checked to determine if another customer can be booked with that flight for that day.

Add Day 
Add a new Day for flights to the system.

Status Customer 
The Status command for a customer will display the flight and day for each flight the customer has booked and/or is waitlisted for.

Drop Flight 
The Drop command must remove a flight from the application. Any customers that have been booked for this flight on any day must be rebooked with another flight for that day if possible in priority sequence and the rebooking reported to the user. If the customer cannot be rebooked, the user is informed that the customer could not be rebooked. Any customers on the waitlist for that flight must also be deleted
