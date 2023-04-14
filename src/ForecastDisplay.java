/**
 *
 * @author Trevor Hartman
 * @author Logan Portillo
 *
 * @since Version 1.0
 */

public class ForecastDisplay implements Display {
    private WeatherStation ws;
    private float currentPress;
    private float lastPress;
    public ForecastDisplay(WeatherStation ws) {
        this.ws = ws;
        this.ws.registerDisplay(this);
        lastPress = ws.getPressure();
    }
    @Override

    public void update() {
        this.currentPress = this.ws.getPressure();
        display();
    }
    @Override

    public void display() {
        System.out.print("Forecast: ");
        if (currentPress > lastPress) {
            System.out.println("Improving weather on the way!");
        } else if (currentPress == lastPress) {
            System.out.println("More of the same");
        } else if (currentPress < lastPress) {
            System.out.println("Watch out for cooler, rainy weather");
        }
    }
}
