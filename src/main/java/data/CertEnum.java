package data;

public enum CertEnum {

    INVALID("invalid"),
    NOVALID("novalid");

    private String type;


    CertEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
