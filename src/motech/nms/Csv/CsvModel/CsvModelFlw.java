package motech.nms.Csv.CsvModel;

import motech.nms.Csv.CsvElement;

public class CsvModelFlw {

    @CsvElement(index = 0) private String name;
    @CsvElement(index = 1) private String mctsFlwId;
    @CsvElement(index = 2) private String contactNumber;
    @CsvElement(index = 3) private String stateCode;
    @CsvElement(index = 4) private String districtCode;
    @CsvElement(index = 5) private String talukaCode;
    @CsvElement(index = 6) private String phcCode;
    @CsvElement(index = 7) private String subcentreCode;
    @CsvElement(index = 8) private String villageCode;
    @CsvElement(index = 9) private String healthblockCode;
    @CsvElement(index = 10) private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMctsFlwId() {
        return mctsFlwId;
    }

    public void setMctsFlwId(String mctsFlwId) {
        this.mctsFlwId = mctsFlwId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getTalukaCode() {
        return talukaCode;
    }

    public void setTalukaCode(String talukaCode) {
        this.talukaCode = talukaCode;
    }

    public String getPhcCode() {
        return phcCode;
    }

    public void setPhcCode(String phcCode) {
        this.phcCode = phcCode;
    }

    public String getSubcentreCode() {
        return subcentreCode;
    }

    public void setSubcentreCode(String subcentreCode) {
        this.subcentreCode = subcentreCode;
    }

    public String getVillageCode() {
        return villageCode;
    }

    public void setVillageCode(String villageCode) {
        this.villageCode = villageCode;
    }

    public String getHealthblockCode() {
        return healthblockCode;
    }

    public void setHealthblockCode(String healthblockCode) {
        this.healthblockCode = healthblockCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override public String toString() {
        return "CsvModelFlw{" +
                "name='" + name + '\'' +
                ", mctsFlwId='" + mctsFlwId + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", stateCode='" + stateCode + '\'' +
                ", districtCode='" + districtCode + '\'' +
                ", talukaCode='" + talukaCode + '\'' +
                ", phcCode='" + phcCode + '\'' +
                ", subcentreCode='" + subcentreCode + '\'' +
                ", villageCode='" + villageCode + '\'' +
                ", healthblockCode='" + healthblockCode + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
