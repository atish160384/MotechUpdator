package motech.nms.Constants;

public class MotechUpdaterConstants {

    /**
     * SQL parameter will be used to pull data and crate csv , need to compelete.
     */

    public static final String SQL_DRIVER_CLASS = "";
    public static final String SQL_URL = "";
    public static final String SQL_USER = "";
    public static final String SQL_PASSOWRD = "";

    public static final String CSV_PATH_RAJASTHAN = "src/resources/valid_but_not_in_motech_hpd8_all_records_new.csv";
    public static final String CSV_PATH_MP = "src/resources/valid_but_not_in_motech_hpd23_all_records_new.csv";

    public static final String MOTECH_URL = "http://192.168.1.127:8443/motech-platform-server/module/api/ops/addFlw";
    public static final int POST_OK = 200;
    public static final int POST_FAILED = 400;
    public static final String CSV_DELIMITER = ";";

}
