
# API Documentation

This document provides the endpoints for the flight booking system. Below are the endpoints for managing airports, airlines, flights, seats, bookings, and other related entities.

## 1. Airport

### GET /api/airports
- **Response:** Returns a list of all airports.
```json
[
  {
    "id": 1,
    "name": "Soekarno-Hatta International Airport",
    "city": "Jakarta",
    "country": "Indonesia",
    "code": "CGK"
  },
  {
    "id": 2,
    "name": "Ngurah Rai International Airport",
    "city": "Denpasar",
    "country": "Indonesia",
    "code": "DPS"
  }
]
```

### GET /api/airports/{id}
- **Response:** Returns the details of a specific airport.
```json
{
  "id": 1,
  "name": "Soekarno-Hatta International Airport",
  "city": "Jakarta",
  "country": "Indonesia",
  "code": "CGK"
}
```

### POST /api/airports
- **Request:**
```json
{
  "name": "Juanda International Airport",
  "city": "Surabaya",
  "country": "Indonesia",
  "code": "SUB"
}
```
- **Response:** 
```json
{
  "message": "Airport created successfully",
  "airport": {
    "id": 3,
    "name": "Juanda International Airport",
    "city": "Surabaya",
    "country": "Indonesia",
    "code": "SUB"
  }
}
```

### PUT /api/airports/{id}
- **Request:**
```json
{
  "name": "Updated Airport Name",
  "city": "Updated City",
  "country": "Updated Country",
  "code": "NEWCODE"
}
```
- **Response:**
```json
{
  "message": "Airport updated successfully",
  "airport": {
    "id": 1,
    "name": "Updated Airport Name",
    "city": "Updated City",
    "country": "Updated Country",
    "code": "NEWCODE"
  }
}
```

### DELETE /api/airports/{id}
- **Response:**
```json
{
  "message": "Airport deleted successfully"
}
```

## 2. Airline

### GET /api/airlines
- **Response:** Returns a list of all airlines.
```json
[
  {
    "id": 1,
    "name": "Garuda Indonesia",
    "code": "GA"
  },
  {
    "id": 2,
    "name": "Lion Air",
    "code": "JT"
  }
]
```

### GET /api/airlines/{id}
- **Response:** Returns the details of a specific airline.
```json
{
  "id": 1,
  "name": "Garuda Indonesia",
  "code": "GA"
}
```

### POST /api/airlines
- **Request:**
```json
{
  "name": "AirAsia",
  "code": "AK"
}
```
- **Response:**
```json
{
  "message": "Airline created successfully",
  "airline": {
    "id": 3,
    "name": "AirAsia",
    "code": "AK"
  }
}
```

### PUT /api/airlines/{id}
- **Request:**
```json
{
  "name": "Updated Airline Name",
  "code": "NEWCODE"
}
```
- **Response:**
```json
{
  "message": "Airline updated successfully",
  "airline": {
    "id": 1,
    "name": "Updated Airline Name",
    "code": "NEWCODE"
  }
}
```

### DELETE /api/airlines/{id}
- **Response:**
```json
{
  "message": "Airline deleted successfully"
}
```

## 3. Flight

### GET /api/flights
- **Response:** Returns a list of all flights.
```json
[
  {
    "id": 1,
    "flight_number": "GA123",
    "departure_time": "2024-08-19T09:00:00",
    "arrival_time": "2024-08-19T12:00:00",
    "departure_airport_id": 1,
    "arrival_airport_id": 2,
    "airline_id": 1
  }
]
```

### GET /api/flights/{id}
- **Response:** Returns the details of a specific flight.
```json
{
  "id": 1,
  "flight_number": "GA123",
  "departure_time": "2024-08-19T09:00:00",
  "arrival_time": "2024-08-19T12:00:00",
  "departure_airport_id": 1,
  "arrival_airport_id": 2,
  "airline_id": 1
}
```

### POST /api/flights
- **Request:**
```json
{
  "flight_number": "GA456",
  "departure_time": "2024-08-20T09:00:00",
  "arrival_time": "2024-08-20T12:00:00",
  "departure_airport_id": 1,
  "arrival_airport_id": 2,
  "airline_id": 1
}
```
- **Response:**
```json
{
  "message": "Flight created successfully",
  "flight": {
    "id": 2,
    "flight_number": "GA456",
    "departure_time": "2024-08-20T09:00:00",
    "arrival_time": "2024-08-20T12:00:00",
    "departure_airport_id": 1,
    "arrival_airport_id": 2,
    "airline_id": 1
  }
}
```

### PUT /api/flights/{id}
- **Request:**
```json
{
  "flight_number": "GA789",
  "departure_time": "2024-08-21T09:00:00",
  "arrival_time": "2024-08-21T12:00:00",
  "departure_airport_id": 1,
  "arrival_airport_id": 2,
  "airline_id": 1
}
```
- **Response:**
```json
{
  "message": "Flight updated successfully",
  "flight": {
    "id": 1,
    "flight_number": "GA789",
    "departure_time": "2024-08-21T09:00:00",
    "arrival_time": "2024-08-21T12:00:00",
    "departure_airport_id": 1,
    "arrival_airport_id": 2,
    "airline_id": 1
  }
}
```

### DELETE /api/flights/{id}
- **Response:**
```json
{
  "message": "Flight deleted successfully"
}
```

## 4. Seats

### GET /api/flights/{flightId}/seats
- **Response:** Returns a list of all seats for a specific flight.
```json
[
  {
    "id": 1,
    "seat_number": "1A",
    "class": "Economy",
    "flight_id": 1
  },
  {
    "id": 2,
    "seat_number": "1B",
    "class": "Economy",
    "flight_id": 1
  }
]
```

### GET /api/seats/{id}
- **Response:** Returns the details of a specific seat.
```json
{
  "id": 1,
  "seat_number": "1A",
  "class": "Economy",
  "flight_id": 1
}
```

### POST /api/flights/{flightId}/seats
- **Request:**
```json
{
  "seat_number": "2A",
  "class": "Business"
}
```
- **Response:**
```json
{
  "message": "Seat created successfully",
  "seat": {
    "id": 3,
    "seat_number": "2A",
    "class": "Business",
    "flight_id": 1
  }
}
```

### PUT /api/seats/{id}
- **Request:**
```json
{
  "seat_number": "2B",
  "class": "Business"
}
```
- **Response:**
```json
{
  "message": "Seat updated successfully",
  "seat": {
    "id": 1,
    "seat_number": "2B",
    "class": "Business",
    "flight_id": 1
  }
}
```

### DELETE /api/seats/{id}
- **Response:**
```json
{
  "message": "Seat deleted successfully"
}
```

Certainly! I'll continue with the remaining entities: Booking, Booking Detail, Discount, Payment, Notification, Users, Role, and Passenger.

---

## 5. Booking

### GET /api/bookings
- **Response:** Returns a list of all bookings.
```json
[
  {
    "id": 1,
    "booking_date": "2024-08-19T08:00:00",
    "total_price": 5000000,
    "status": "Confirmed",
    "flight_id": 1,
    "passenger_id": 1,
    "payment_id": 1
  }
]
```

### GET /api/bookings/{id}
- **Response:** Returns the details of a specific booking.
```json
{
  "id": 1,
  "booking_date": "2024-08-19T08:00:00",
  "total_price": 5000000,
  "status": "Confirmed",
  "flight_id": 1,
  "passenger_id": 1,
  "payment_id": 1
}
```

### POST /api/bookings
- **Request:**
```json
{
  "booking_date": "2024-08-19T08:00:00",
  "total_price": 5000000,
  "status": "Confirmed",
  "flight_id": 1,
  "passenger_id": 1,
  "payment_id": 1
}
```
- **Response:**
```json
{
  "message": "Booking created successfully",
  "booking": {
    "id": 2,
    "booking_date": "2024-08-20T08:00:00",
    "total_price": 7500000,
    "status": "Pending",
    "flight_id": 2,
    "passenger_id": 2,
    "payment_id": 2
  }
}
```

### PUT /api/bookings/{id}
- **Request:**
```json
{
  "booking_date": "2024-08-19T08:00:00",
  "total_price": 5500000,
  "status": "Confirmed"
}
```
- **Response:**
```json
{
  "message": "Booking updated successfully",
  "booking": {
    "id": 1,
    "booking_date": "2024-08-19T08:00:00",
    "total_price": 5500000,
    "status": "Confirmed",
    "flight_id": 1,
    "passenger_id": 1,
    "payment_id": 1
  }
}
```

### DELETE /api/bookings/{id}
- **Response:**
```json
{
  "message": "Booking deleted successfully"
}
```

## 6. Booking Detail

### GET /api/bookings/{bookingId}/details
- **Response:** Returns a list of all booking details for a specific booking.
```json
[
  {
    "id": 1,
    "seat_id": 1,
    "booking_id": 1
  },
  {
    "id": 2,
    "seat_id": 2,
    "booking_id": 1
  }
]
```

### GET /api/details/{id}
- **Response:** Returns the details of a specific booking detail.
```json
{
  "id": 1,
  "seat_id": 1,
  "booking_id": 1
}
```

### POST /api/bookings/{bookingId}/details
- **Request:**
```json
{
  "seat_id": 3
}
```
- **Response:**
```json
{
  "message": "Booking detail created successfully",
  "booking_detail": {
    "id": 3,
    "seat_id": 3,
    "booking_id": 1
  }
}
```

### PUT /api/details/{id}
- **Request:**
```json
{
  "seat_id": 4
}
```
- **Response:**
```json
{
  "message": "Booking detail updated successfully",
  "booking_detail": {
    "id": 1,
    "seat_id": 4,
    "booking_id": 1
  }
}
```

### DELETE /api/details/{id}
- **Response:**
```json
{
  "message": "Booking detail deleted successfully"
}
```

## 7. Discount

### GET /api/discounts
- **Response:** Returns a list of all discounts.
```json
[
  {
    "id": 1,
    "code": "SUMMER2024",
    "description": "20% off summer sale",
    "amount": 20
  }
]
```

### GET /api/discounts/{id}
- **Response:** Returns the details of a specific discount.
```json
{
  "id": 1,
  "code": "SUMMER2024",
  "description": "20% off summer sale",
  "amount": 20
}
```

### POST /api/discounts
- **Request:**
```json
{
  "code": "WINTER2024",
  "description": "15% off winter sale",
  "amount": 15
}
```
- **Response:**
```json
{
  "message": "Discount created successfully",
  "discount": {
    "id": 2,
    "code": "WINTER2024",
    "description": "15% off winter sale",
    "amount": 15
  }
}
```

### PUT /api/discounts/{id}
- **Request:**
```json
{
  "code": "NEWCODE2024",
  "description": "Updated discount description",
  "amount": 10
}
```
- **Response:**
```json
{
  "message": "Discount updated successfully",
  "discount": {
    "id": 1,
    "code": "NEWCODE2024",
    "description": "Updated discount description",
    "amount": 10
  }
}
```

### DELETE /api/discounts/{id}
- **Response:**
```json
{
  "message": "Discount deleted successfully"
}
```

## 8. Payment

### GET /api/payments
- **Response:** Returns a list of all payments.
```json
[
  {
    "id": 1,
    "amount": 5000000,
    "payment_date": "2024-08-19T09:00:00",
    "status": "Paid",
    "booking_id": 1
  }
]
```

### GET /api/payments/{id}
- **Response:** Returns the details of a specific payment.
```json
{
  "id": 1,
  "amount": 5000000,
  "payment_date": "2024-08-19T09:00:00",
  "status": "Paid",
  "booking_id": 1
}
```

### POST /api/payments
- **Request:**
```json
{
  "amount": 7500000,
  "payment_date": "2024-08-20T09:00:00",
  "status": "Pending",
  "booking_id": 2
}
```
- **Response:**
```json
{
  "message": "Payment created successfully",
  "payment": {
    "id": 2,
    "amount": 7500000,
    "payment_date": "2024-08-20T09:00:00",
    "status": "Pending",
    "booking_id": 2
  }
}
```

### PUT /api/payments/{id}
- **Request:**
```json
{
  "amount": 8000000,
  "payment_date": "2024-08-19T10:00:00",
  "status": "Paid"
}
```
- **Response:**
```json
{
  "message": "Payment updated successfully",
  "payment": {
    "id": 1,
    "amount": 8000000,
    "payment_date": "2024-08-19T10:00:00",
    "status": "Paid",
    "booking_id": 1
  }
}
```

### DELETE /api/payments/{id}
- **Response:**
```json
{
  "message": "Payment deleted successfully"
}
```

## 9. Notification

### GET /api/notifications
- **Response:** Returns a list of all notifications.
```json
[
  {
    "id": 1,
    "message": "Your booking has been confirmed",
    "sent_at": "2024-08-19T09:00:00",
    "user_id": 1
  }
]
```

### GET /api/notifications/{id}
- **Response:** Returns the details of a specific notification.
```json
{
  "id": 1,
  "message": "Your booking has been confirmed",
  "sent_at": "2024-08-19T09:00:00",
  "user_id": 1
}
```

### POST /api/notifications
- **Request:**
```json
{
  "message": "Your flight is delayed",
  "user_id": 2
}
```
- **Response:**
```json
{
  "message": "Notification created successfully",
  "notification": {
    "id": 2,
    "message": "Your flight is delayed",
    "sent_at": "2024-08-20T09:00:00",
    "user_id": 2
  }
}
```

Certainly! I'll continue with the remaining entities: Notification, Users, Role, and Passenger.

---

### PUT /api/notifications/{id}
- **Request:**
```json
{
  "message": "Your booking has been updated",
  "user_id": 1
}
```
- **Response:**
```json
{
  "message": "Notification updated successfully",
  "notification": {
    "id": 1,
    "message": "Your booking has been updated",
    "sent_at": "2024-08-19T09:00:00",
    "user_id": 1
  }
}
```

### DELETE /api/notifications/{id}
- **Response:**
```json
{
  "message": "Notification deleted successfully"
}
```

## 10. Users

### GET /api/users
- **Response:** Returns a list of all users.
```json
[
  {
    "id": 1,
    "username": "john_doe",
    "email": "john@example.com",
    "role_id": 1
  }
]
```

### GET /api/users/{id}
- **Response:** Returns the details of a specific user.
```json
{
  "id": 1,
  "username": "john_doe",
  "email": "john@example.com",
  "role_id": 1
}
```

### POST /api/users
- **Request:**
```json
{
  "username": "jane_doe",
  "email": "jane@example.com",
  "password": "password123",
  "role_id": 2
}
```
- **Response:**
```json
{
  "message": "User created successfully",
  "user": {
    "id": 2,
    "username": "jane_doe",
    "email": "jane@example.com",
    "role_id": 2
  }
}
```

### PUT /api/users/{id}
- **Request:**
```json
{
  "username": "john_updated",
  "email": "john_updated@example.com",
  "role_id": 1
}
```
- **Response:**
```json
{
  "message": "User updated successfully",
  "user": {
    "id": 1,
    "username": "john_updated",
    "email": "john_updated@example.com",
    "role_id": 1
  }
}
```

### DELETE /api/users/{id}
- **Response:**
```json
{
  "message": "User deleted successfully"
}
```

## 11. Role

### GET /api/roles
- **Response:** Returns a list of all roles.
```json
[
  {
    "id": 1,
    "name": "Admin"
  },
  {
    "id": 2,
    "name": "User"
  }
]
```

### GET /api/roles/{id}
- **Response:** Returns the details of a specific role.
```json
{
  "id": 1,
  "name": "Admin"
}
```

### POST /api/roles
- **Request:**
```json
{
  "name": "Manager"
}
```
- **Response:**
```json
{
  "message": "Role created successfully",
  "role": {
    "id": 3,
    "name": "Manager"
  }
}
```

### PUT /api/roles/{id}
- **Request:**
```json
{
  "name": "Super Admin"
}
```
- **Response:**
```json
{
  "message": "Role updated successfully",
  "role": {
    "id": 1,
    "name": "Super Admin"
  }
}
```

### DELETE /api/roles/{id}
- **Response:**
```json
{
  "message": "Role deleted successfully"
}
```

## 12. Passenger

### GET /api/passengers
- **Response:** Returns a list of all passengers.
```json
[
  {
    "id": 1,
    "first_name": "John",
    "last_name": "Doe",
    "email": "john@example.com",
    "phone_number": "+123456789"
  }
]
```

### GET /api/passengers/{id}
- **Response:** Returns the details of a specific passenger.
```json
{
  "id": 1,
  "first_name": "John",
  "last_name": "Doe",
  "email": "john@example.com",
  "phone_number": "+123456789"
}
```

### POST /api/passengers
- **Request:**
```json
{
  "first_name": "Jane",
  "last_name": "Doe",
  "email": "jane@example.com",
  "phone_number": "+987654321"
}
```
- **Response:**
```json
{
  "message": "Passenger created successfully",
  "passenger": {
    "id": 2,
    "first_name": "Jane",
    "last_name": "Doe",
    "email": "jane@example.com",
    "phone_number": "+987654321"
  }
}
```

### PUT /api/passengers/{id}
- **Request:**
```json
{
  "first_name": "John Updated",
  "last_name": "Doe Updated",
  "email": "john_updated@example.com",
  "phone_number": "+123456780"
}
```
- **Response:**
```json
{
  "message": "Passenger updated successfully",
  "passenger": {
    "id": 1,
    "first_name": "John Updated",
    "last_name": "Doe Updated",
    "email": "john_updated@example.com",
    "phone_number": "+123456780"
  }
}
```

### DELETE /api/passengers/{id}
- **Response:**
```json
{
  "message": "Passenger deleted successfully"
}
```

