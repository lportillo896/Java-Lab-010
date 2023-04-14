/**
 * @author Trevor Hartman
 * @author Logan Portillo
 *
 * @since Version 1.0
 */

public class StatisticsDisplay implements Display {
    private WeatherStation ws;
    private float tempMin;
    private float tempMax;
    private float tempTotal;
    private int readings;
    public StatisticsDisplay(WeatherStation ws) {
        this.ws = ws;
        this.tempMin = Float.MIN_VALUE;
        this.tempMax = Float.MAX_VALUE;
        this.tempTotal = 0;
        this.ws.registerDisplay(this);
    }
    @Override

    public void update() {
        float temp = this.ws.getTemperature();
        if (temp > tempMax) {
            tempMax = temp;
        }
        if (temp < tempMin) {
            tempMin = temp;
        }
        tempTotal += temp;
        readings ++;
        display();
    }
    @Override

    public void display() {
        System.out.println("Max Temperature: "+tempMax+" F");
        System.out.println("Min Temperature: "+tempMin+" F");
        System.out.println("Total Temperature: "+tempTotal+" F");
        System.out.println("Average Temperature: "+tempTotal/readings+" F");
    }
}
