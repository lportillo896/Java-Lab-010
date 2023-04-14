/**
 *
 * @author Trevor Hartman
 * @author Logan Portillo
 *
 * @since Version 1.0
 */

public class CurrentConditions implements Display {
    private WeatherStation weatherStation;
    private float temp;
    private float press;
    private float hum;
    public CurrentConditions(WeatherStation ws) {
        this.weatherStation = ws;
        this.weatherStation.registerDisplay(this);
    }
    @Override

    public void update() {
        this.temp = this.weatherStation.getTemperature();
        this.hum = this.weatherStation.getHumidity();
        this.press = this.weatherStation.getPressure();
        display();
    }
    @Override

    public void display() {
        System.out.println("Current Temperature: "+temp+" F");
        System.out.println("Current Pressure: "+press+" inHg");
        System.out.println("Current Humidity: "+hum);
    }
}
