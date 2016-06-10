package motech.nms.Updator;

import motech.nms.Constants.MotechUpdaterConstants;
import motech.nms.Csv.CsvModel.CsvModelFlw;
import motech.nms.Csv.CsvReaderFlw;
import motech.nms.FlwRequest.AddFlwRequest;
import motech.nms.FlwRequest.AddFlwRequestBuilder;
import motech.nms.HttpMethods.FlwRequestHttpMethods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MotechUpdater {

    public static void main(String[] args) throws IOException {

        CsvReaderFlw csvReaderFlw = new CsvReaderFlw();
//        List<CsvModelFlw> flwsMp = csvReaderFlw
//                .read(MotechUpdaterConstants.CSV_PATH_RAJASTHAN);
//        List<CsvModelFlw> flwsRajastan = csvReaderFlw
//                .read(MotechUpdaterConstants.CSV_PATH_MP);
        List<CsvModelFlw> flwsComplete = csvReaderFlw
                .read(MotechUpdaterConstants.CSV_PATH_COMPLETE);
        List<CsvModelFlw> flws = new ArrayList<>();
        flws.addAll(flwsComplete);
//        flws.addAll(flwsMP);
//        flws.addAll(flwsRajastan);
        for (CsvModelFlw flw : flws) {

            AddFlwRequest flwRequest = AddFlwRequestBuilder
                    .build(flw.getName(), flw.getMctsFlwId(),
                            flw.getContactNumber(), flw.getStateCode(),
                            flw.getDistrictCode(), flw.getTalukaCode(),
                            flw.getPhcCode(), flw.getSubcentreCode(),
                            flw.getVillageCode(), flw.getHealthblockCode(),
                            flw.getType());
            FlwRequestHttpMethods flwRequestHttpMethods = new FlwRequestHttpMethods();
            if(flwRequest!=null) {
                int resultCode = flwRequestHttpMethods
                        .postwithJson(MotechUpdaterConstants.MOTECH_URL, flwRequest,
                                flwRequestHttpMethods.createAuthenticationHeader(
                                        MotechUpdaterConstants.DEFAULT_USER,
                                        MotechUpdaterConstants.DEFAULT_PASSWORD));
                if (resultCode == MotechUpdaterConstants.POST_OK) {
                    System.out.println(
                            "For Request with flw, " + flwRequest.toString()
                                    + "sync successfully done with Motech.");
                } else if (resultCode == MotechUpdaterConstants.POST_FAILED) {
                    System.out.println(
                            "For Request with flw, " + flwRequest.toString()
                                    + "is sync failed with Motech due validation error. ");
                } else {
                    System.out.println(flwRequest.toString()
                            + "is synced with Motech due to Status" + resultCode);
                }
            }
        }

    }

}
