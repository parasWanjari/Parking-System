import java.util.*;

public class ParkingLotApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot parkingLot = null;

        while (true) {
            String command = scanner.nextLine();
            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "create_parking_lot":
                    int capacity = Integer.parseInt(tokens[1]);
                    parkingLot = new ParkingLot(capacity);
                    System.out.println("Created a parking lot with " + capacity + " slots");
                    break;

                case "park":
                    parkingLot.parkCar(tokens[1], tokens[2]);
                    break;

                case "leave":
                    int slotToLeave = Integer.parseInt(tokens[1]);
                    parkingLot.leaveSlot(slotToLeave);
                    break;

                case "status":
                    parkingLot.getStatus();
                    break;

                case "registration_numbers_for_cars_with_colour":
                    String colorToSearch = tokens[1];
                    List<String> regNums = parkingLot.getRegNumsByColor(colorToSearch);
                    System.out.println(String.join(", ", regNums));
                    break;

                case "slot_numbers_for_cars_with_colour":
                    String colorToSearchForSlot = tokens[1];
                    List<Integer> slots = parkingLot.getSlotsByColor(colorToSearchForSlot);
                    System.out.println(slots.isEmpty() ? "Not found" : String.join(", ", slots.stream().map(String::valueOf).toArray(String[]::new)));
                    break;

                case "slot_number_for_registration_number":
                    String regNumToSearch = tokens[1];
                    int slot = parkingLot.getSlotByRegNum(regNumToSearch);
                    System.out.println(slot == -1 ? "Not found" : slot);
                    break;

                case "exit":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid command");
            }
        }
    }
}
