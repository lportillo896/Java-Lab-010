/**
 *
 * @author Trevor Hartman
 * @author Logan Portillo
 *
 * @since Version 1.0
 */

import java.io.IOException;
public class Main {
    public static void main(String[]args) {
        WeatherStation ws = new WeatherStation();
        CurrentConditions cc = new CurrentConditions(ws);
        StatisticsDisplay sd = new StatisticsDisplay(ws);
        ForecastDisplay fd = new ForecastDisplay(ws);
        try {
            ws.measure();
        } catch (IOException e) {
            System.out.println("Could not find any weather data");
        }
    }
}
