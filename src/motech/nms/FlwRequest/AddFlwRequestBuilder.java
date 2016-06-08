package motech.nms.FlwRequest;

/**
 * Created by atish on 1/6/16.
 */
public class AddFlwRequestBuilder {

    public static AddFlwRequest build(String name, String mctsFlwId,
            String contactNumber, String stateId, String districtId,
            String talukaId, String phcId, String subcentreId, String villageId,
            String healthblockId, String type) {
        AddFlwRequest flwRequest = new AddFlwRequest();
        flwRequest.setName(name);
        flwRequest.setMctsFlwId(mctsFlwId);
        flwRequest.setContactNumber(Long.parseLong(contactNumber));
        flwRequest.setStateId(Integer.parseInt(stateId));
        flwRequest.setDistrictId(Integer.parseInt(districtId));
        flwRequest.setTalukaId(talukaId);
        flwRequest.setVillageId((villageId.equals("NULL")) ? null : Integer.parseInt(villageId));
        flwRequest.setHealthblockId((healthblockId.equals("NULL")) ? null : Integer.parseInt(healthblockId));
        flwRequest.setPhcId((phcId.equals("NULL")) ? null : Integer.parseInt(phcId));
        flwRequest.setSubcentreId((subcentreId.equals("NULL")) ? null : Integer.parseInt(subcentreId));
        flwRequest.setType(type);
        return flwRequest;

    }
}
