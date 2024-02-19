# Parking Lot Application

This Java application simulates an automated parking ticketing system for a parking lot. It allows users to create a parking lot, park cars, leave parking slots, and query information about the parked cars based on various criteria.

## Prerequisites

- Java Development Kit (JDK) installed (minimum Java 8)
- Java IDE or text editor (e.g., IntelliJ IDEA, Eclipse, or Visual Studio Code)
- Command-line interface (CLI)

## Usage

1. Clone the repository or download the source code.

```bash
git clone https://github.com/your-username/parking-lot.git
cd parking-lot

## Compile the Java files.
javac ParkingLotApp.java

## Run the application.
java ParkingLotApp

## Commands

1. create_parking_lot <capacity>: Create a parking lot with the specified capacity.
2. park <registration_number> <color>: Park a car with the given registration number and color.
3. leave <slot_number>: Vacate the specified parking slot.
4. status: Display the current status of the parking lot.
5. registration_numbers_for_cars_with_colour <color>: Retrieve registration numbers of cars with the specified color.
6. slot_numbers_for_cars_with_colour <color>: Retrieve slot numbers of cars with the specified color.
7. slot_number_for_registration_number <registration_number>: Retrieve the slot number for a car with the specified registration number.
8. exit: Exit the application.
