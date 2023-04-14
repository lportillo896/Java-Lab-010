/**
 *
 * @author Trevor Hartman
 * @author Logan Portillo
 *
 * @since Version 1.0
 */

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WeatherStation {
    private URL url;
    private List<Display> displays;
    private Gson gson;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherStation() {
        displays = new ArrayList<Display>();
        gson = new Gson();
        try {
            url = new URL("https://api.openweathermap.org/data/2.5/weather?q=Loleta,us&units=imperial&APPID=132cb2f1db987da116d403e616723290");
        } catch (MalformedURLException m) {}
    }

    public void registerDisplay(Display d) {
        displays.add(d);
    }

    public void removeDisplay(Display d) {
        displays.remove(d);
    }

    public void notifyDisplays() {
        for(Display d : displays) {
            d.update();
        }
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public static float hPaToInHG(float hPa) {
        return hPa * 0.029529983071445f;
    }

    public void measure() throws IOException {
        InputStreamReader reader = new InputStreamReader(url.openStream());
        JsonObject object = gson.fromJson(reader, JsonObject.class);
        JsonObject main = object.get("main").getAsJsonObject();

        this.temperature = main.get("temp").getAsFloat();
        this.humidity = main.get("humidity").getAsFloat();
        this.pressure = WeatherStation.hPaToInHG(main.get("pressure").getAsFloat());
        notifyDisplays();
    }
}
