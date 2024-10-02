// Import statements must be at the top of the file
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.StringReader;

// IWeatherService.java equivalent
interface IWeatherService {
    double getTemperature();
    double getHumidity();
}

// WeatherServiceA.java equivalent
class WeatherServiceA implements IWeatherService {
    @Override
    public double getTemperature() {
        return 25.0;  // Mocked temperature for service A
    }

    @Override
    public double getHumidity() {
        return 60.0;  // Mocked humidity for service A
    }
}

// WeatherServiceB.java equivalent (Service B using XML data)
class WeatherServiceB {
    public String getWeatherDataXML() {
        return "<weather><temperature>30.0</temperature><humidity>65.0</humidity></weather>";
    }
}

// Adapter for WeatherServiceB to convert XML data
class WeatherServiceBAdapter implements IWeatherService {
    private WeatherServiceB serviceB;

    public WeatherServiceBAdapter(WeatherServiceB serviceB) {
        this.serviceB = serviceB;
    }

    @Override
    public double getTemperature() {
        String xmlData = serviceB.getWeatherDataXML();
        return parseXMLData(xmlData, "temperature");
    }

    @Override
    public double getHumidity() {
        String xmlData = serviceB.getWeatherDataXML();
        return parseXMLData(xmlData, "humidity");
    }

    // Helper method to parse XML data
    private double parseXMLData(String xml, String tagName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new org.xml.sax.InputSource(new StringReader(xml)));
            NodeList nodeList = document.getElementsByTagName(tagName);
            return Double.parseDouble(nodeList.item(0).getTextContent());
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}

// Main class (AdapterDesignPattern.java)
public class AdapterDesignPattern {
    public static void main(String[] args) {
        // Using Service A
        IWeatherService serviceA = new WeatherServiceA();
        System.out.println("Service A - Temperature: " + serviceA.getTemperature());
        System.out.println("Service A - Humidity: " + serviceA.getHumidity());

        // Using Service B with Adapter
        WeatherServiceB serviceB = new WeatherServiceB();
        IWeatherService serviceBAdapter = new WeatherServiceBAdapter(serviceB);
        System.out.println("Service B (via Adapter) - Temperature: " + serviceBAdapter.getTemperature());
        System.out.println("Service B (via Adapter) - Humidity: " + serviceBAdapter.getHumidity());
    }
}
