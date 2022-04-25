package org.framework.data;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

public class FileOperations {

    public Iterator<Object[]> parseCsvData(String fileName) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            CSVParser parser = new CSVParserBuilder().withSeparator(';').withIgnoreQuotations(true).build();
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).withCSVParser(parser).build();
            String[] line;
            ArrayList<Object[]> data = new ArrayList<>();
            while((line = csvReader.readNext()) != null) {
                data.add(line);
            }
            reader.close();
            csvReader.close();
            return data.iterator();
        } catch (Exception e ) {
            e.getMessage();
        }
        return null;
    }

    public String readProperties(String file, String property) {
        try (InputStream input = new FileInputStream(file)) {
            Properties properties = new Properties();
            properties.load(input);
            return properties.getProperty(property);
        } catch (IOException e ) {
            System.out.println("Arquivo de propriedades não foi encontrado...");
            e.printStackTrace();
        }
        return null;
    }
}
