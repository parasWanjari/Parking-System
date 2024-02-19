import java.util.*;

public class ParkingLot {

    private final int capacity;
    private final Map<Integer, Car> parkingMap;
    private final Map<String, List<Integer>> colorToSlotMap;
    private final Map<String, String> regNumToColorMap;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkingMap = new HashMap<>();
        this.colorToSlotMap = new HashMap<>();
        this.regNumToColorMap = new HashMap<>();
        initializeParkingSlots();
    }

    private void initializeParkingSlots() {
        for (int i = 1; i <= capacity; i++) {
            parkingMap.put(i, null);
        }
    }

    public void parkCar(String regNum, String color) {
        for (int i = 1; i <= capacity; i++) {
            if (parkingMap.get(i) == null) {
                parkingMap.put(i, new Car(regNum, color));
                updateColorToSlotMap(color, i);
                updateRegNumToColorMap(regNum, color);
                System.out.println("Allocated slot number: " + i);
                return;
            }
        }
        System.out.println("Sorry, parking lot is full");
    }

    public void leaveSlot(int slot) {
        if (parkingMap.containsKey(slot) && parkingMap.get(slot) != null) {
            Car car = parkingMap.get(slot);
            parkingMap.put(slot, null);
            removeFromColorToSlotMap(car.getColor(), slot);
            System.out.println("Slot number " + slot + " is free");
        } else {
            System.out.println("Slot number " + slot + " is already empty");
        }
    }

    public void getStatus() {
        System.out.println("Slot No. Registration No Colour");
        for (int i = 1; i <= capacity; i++) {
            Car car = parkingMap.get(i);
            if (car != null) {
                System.out.println(i + " " + car.getRegNum() + " " + car.getColor());
            }
        }
    }

    public List<Integer> getSlotsByColor(String color) {
        return colorToSlotMap.getOrDefault(color, Collections.emptyList());
    }

    public List<String> getRegNumsByColor(String color) {
        List<Integer> slots = colorToSlotMap.getOrDefault(color, Collections.emptyList());
        List<String> regNums = new ArrayList<>();
        for (int slot : slots) {
            Car car = parkingMap.get(slot);
            if (car != null) {
                regNums.add(car.getRegNum());
            }
        }
        return regNums;
    }

    public int getSlotByRegNum(String regNum) {
        String color = regNumToColorMap.get(regNum);
        List<Integer> slots = colorToSlotMap.getOrDefault(color, Collections.emptyList());
        for (int slot : slots) {
            Car car = parkingMap.get(slot);
            if (car != null && car.getRegNum().equals(regNum)) {
                return slot;
            }
        }
        return -1; // Not found
    }

    private void updateColorToSlotMap(String color, int slot) {
        colorToSlotMap.computeIfAbsent(color, k -> new ArrayList<>()).add(slot);
    }

    private void removeFromColorToSlotMap(String color, int slot) {
        List<Integer> slots = colorToSlotMap.get(color);
        if (slots != null) {
            slots.remove(Integer.valueOf(slot));
            if (slots.isEmpty()) {
                colorToSlotMap.remove(color);
            }
        }
    }

    private void updateRegNumToColorMap(String regNum, String color) {
        regNumToColorMap.put(regNum, color);
    }
}
