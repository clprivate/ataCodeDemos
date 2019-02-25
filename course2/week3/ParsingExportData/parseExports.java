
// By Clint Looney (clooney@)
// Assignment URL: https://www.coursera.org/learn/java-programming/supplement/Qu17T/programming-exercise-parsing-export-data
import edu.duke.*;
import org.apache.commons.csv.*;

public class parseExports {
    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        // parser = fr.getCSVParser();
        
        // Test countryInfo
        // System.out.println(countryInfo(new FileResource().getCSVParser(), "Germany"));
        System.out.println(countryInfo(fr.getCSVParser(), "Germany"));
        System.out.println(countryInfo(fr.getCSVParser(), "Malawi"));
        System.out.println(countryInfo(fr.getCSVParser(), "Angola"));
        System.out.println(countryInfo(fr.getCSVParser(), "MadeUpCountry"));
        
        // Test listExportersTwoProducts
        System.out.println("================================================");
        listExportersTwoProducts(fr.getCSVParser(), "motor vehicles", "machinery");
        listExportersTwoProducts(fr.getCSVParser(), "tobacco", "textiles");
        listExportersTwoProducts(fr.getCSVParser(), "MadeUpExport1", "textiles");
        
        // Test numberOfExporters
        System.out.println("================================================");
        System.out.println(numberOfExporters(fr.getCSVParser(), "coffee") + " countries export coffee");
        System.out.println(numberOfExporters(fr.getCSVParser(), "gold") + " countries export gold");
        System.out.println(numberOfExporters(fr.getCSVParser(), "MadeUpExport") + " countries export MadeUpExport");
        
        // Test bigExporters
        System.out.println("================================================");
        bigExporters(fr.getCSVParser(), "$1,000,000,000");
        bigExporters(fr.getCSVParser(), "$1000000000000000000000000000000000000000000");
    }
    
    public String countryInfo(CSVParser parser, String country) {
        // System.out.println("countryInfo running");
        for(CSVRecord record : parser) {
            // System.out.println("country == " + country);
            if(record.get("Country").equals(country)) {
                return record.get("Country") + ": " + record.get("Exports") + ": " + record.get("Value (dollars)");
            } 
        }
        return country + ": " + "RECORD NOT FOUND";
    }
   
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        // System.out.println("listExportersTwoProducts running");
        boolean found = false;
        for(CSVRecord record : parser) {
            // System.out.println("listExportersTwoProducts for loop running.");
            // System.out.println(record.get("Exports"));
            if
            (
                record.get("Exports").contains(exportItem1.toLowerCase())
                &&
                record.get("Exports").contains(exportItem2.toLowerCase())
            ) {
                found = true;
                System.out.println(record.get("Country") + " exports " + exportItem1 + " and " + exportItem2);
            }   
        }
        if(!found) {
            System.out.println("No record of countries exporting both " + exportItem1 + " and " + exportItem2);
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportedItem) {
        int exporterCount = 0;
        for(CSVRecord record : parser) {
            if(record.get("Exports").contains(exportedItem.toLowerCase())) {
                exporterCount += 1;
            }
        }
        return exporterCount;
    }
    
    public void bigExporters(CSVParser parser, String amount) {
        boolean found = false;
        for(CSVRecord record : parser) {
            if(record.get("Value (dollars)").length() > amount.length()) {
                found = true;
                System.out.println(record.get("Country") + " has export figure " + record.get("Value (dollars)") + ", whose length exceeds entered amount entry " + amount);
            }
        }
        if(!found) {
            System.out.println("No country has an export figure whose length exceeds amount entry " + amount);
        }
    }
}