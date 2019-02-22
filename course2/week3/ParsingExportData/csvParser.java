
// By Clint Looney (clooney@)
// Assignment URL: https://www.coursera.org/learn/java-programming/supplement/Qu17T/programming-exercise-parsing-export-data
import edu.duke.*;
import org.apache.commons.csv.*;

public class csvParser {
    public void tester() {
        readCSV();
    }
    
    public void readCSV() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        for(CSVRecord record : parser) {
            System.out.println(record.get("Country"));
        }
    }
}
