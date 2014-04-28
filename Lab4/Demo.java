public class Demo {

    public static void main (String [] args) {
	Car  rolls;
        Driver nigel;
        ServiceStation esso;

        rolls = new Car();
        nigel = new Driver(); 
        esso = new ServiceStation();

        System.out.println("Rolls: " + rolls.getStatus());

        System.out.println("Gas up the Rolls");
        esso.fill(rolls);

        System.out.println("Rolls: " + rolls.getStatus());

        System.out.println("Nigel drives the Rolls");
        nigel.drive(rolls);

        System.out.println("Rolls: " + rolls.getStatus());

        System.out.println("Clean and gas up the Rolls");
        // Substitute code here to clean the Rolls
	// and fill it with gas

        System.out.println("Rolls: " + rolls.getStatus());
    }
}
