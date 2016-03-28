package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by winch on 28.03.2016.
 */
public class FileNameGenerator {
    public static String fileName;
    public String fileNameGenerator(String prefix) {

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = null;
        dateFormat = new SimpleDateFormat("HHmmssddMMYYYY");
        String date = dateFormat.format(currentDate);

        fileName = prefix +date;
        return fileName;

        //System.out.println(email);
    }
}
