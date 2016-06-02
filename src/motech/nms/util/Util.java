package motech.nms.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Util {

    public static String capitalizeFirstLetterOfFieldName(String fieldName) {
        return Character.toUpperCase(fieldName.charAt(0)) + fieldName
                .substring(1, fieldName.length());
    }

    public static String convertIOToString(InputStream is) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int nRead;
        byte[] data = new byte[16384];

        while ((nRead = is.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        buffer.flush();

        return new String(buffer.toByteArray());
    }

}
