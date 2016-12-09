package au.com.vicfaith.android.weatherforecast.utils;

public class TemperatureFormatter {
    public static String format(double temperature) {
        temperature = ((temperature - 32) * 5) / 9;
        return String.format("%.1f %cC", temperature, (char) 0x00B0);
    }
}
