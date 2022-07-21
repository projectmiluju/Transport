public class Main {
    public static void main(String[] args){
        Transport bus1 = new Bus("Bus1", 1111, 100, 0, 0);
        Transport bus2 = new Bus("Bus2", 2222, 0, 0, 0);
        Transport taxi1 = new Taxi("Taxi1", 1111, 100, 0, 0);
        Transport taxi2 = new Taxi("Taxi2", 2222, 0, 0,0);
        Transport[] transports = {bus1,bus2,taxi1,taxi2};

        for (Transport transport : transports){
            System.out.println(transport.name + "," + transport.number);
        }


        System.out.println("------Bus 시나리오------");

        ((BoardPassenger)bus1).boardPassenger(2);
        ((Now)bus1).now();

        ((FuelChange) bus1).fuelChange(-50);
        ((Now)bus1).now();

        bus1.State("차고지행");
        ((FuelChange) bus1).fuelChange(10);
        ((Now)bus1).now();

        bus1.State("운행중");
        ((BoardPassenger)bus1).boardPassenger(45);

        ((BoardPassenger)bus1).boardPassenger(5);
        ((Now)bus1).now();

        ((FuelChange) bus1).fuelChange(-55);
        ((Now)bus1).now();



        System.out.println("------Taxi 시나리오------");

        ((BoardPassenger)taxi1).boardPassenger(2);
        taxi1.setGoal("서울역", 2);
        taxi1.calPay();
        ((Now)taxi1).now();

        ((FuelChange) taxi1).fuelChange(-80);
        taxi1.pay();
        ((Now)taxi1).now();

        ((BoardPassenger)taxi1).boardPassenger(5);

        ((BoardPassenger)taxi1).boardPassenger(3);
        taxi1.setGoal("구로디지털단지역", 12);
        taxi1.calPay();
        ((Now)taxi1).now();

        ((FuelChange) taxi1).fuelChange(-20);
        taxi1.pay();
        ((Now)taxi1).now();

    }

}
