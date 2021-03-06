
// By Clint Looney (clooney@)
// Lesson URL: https://www.coursera.org/learn/java-programming/supplement/wkC85/programming-exercise-parsing-weather-data
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class ParsingWeatherData {
    public CSVRecord coldestHourInFile(CSVParser parser) {
        CSVRecord lowestSoFar = null;
        for(CSVRecord currentRow : parser) {
            if(lowestSoFar == null) {
                lowestSoFar = currentRow;
            } else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double lowestTemp = Double.parseDouble(lowestSoFar.get("TemperatureF"));
                if(currentTemp < lowestTemp) {
                    lowestSoFar = currentRow;
                }
            }
        }
        return lowestSoFar;
    }
    
    public void testColdestHourInFile() {
        FileResource fr = new FileResource("data/2015/weather-2015-01-01.csv");
        CSVRecord lowest = coldestHourInFile(fr.getCSVParser());
        // System.out.println("Coldest temperature was " + lowest.get("TemperatureF") + " at " + lowest.get("TimeEST"));
        System.out.println("Record for hour with the coldest temperature:\n" + lowest);
    }
    
    public String fileWithColdestTemperature() {
        // TODO:
        return "";
    }
    
    public void testFileWithColdestTemperature() {
    }
    
    public CSVParser lowestHumidityInFile(CSVParser parser) {
        // Print lowest humidity and time of lowest humidity.
        // TODO
        CSVParser testParser = parser;
        // TODO
        return parser;
    }
    
}
