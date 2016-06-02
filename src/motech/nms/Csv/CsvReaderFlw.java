package motech.nms.Csv;

import motech.nms.Constants.MotechUpdaterConstants;
import motech.nms.Csv.CsvModel.CsvModelFlw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderFlw extends CsvReaderGeneric<CsvModelFlw> {

    @Override public List<CsvModelFlw> read(String csvFile) {
        BufferedReader br = null;
        String line = "";
        List<CsvModelFlw> returnList = new ArrayList<>();

        try {

            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {
                Object[] column = line
                        .split(MotechUpdaterConstants.CSV_DELIMITER);
                CsvModelFlw csvModelFlw = new CsvModelFlw();
                csvModelFlw = setColumnToField(column, csvModelFlw,
                        CsvModelFlw.class);
                returnList.add(csvModelFlw);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return returnList;
    }

}


