package nbki.csv;

public class Model {
    private int fid;
    private String serialNum;
    private String memberCode;
    private String acctType;
    private String openedDt;
    private String acctRteCde;
    private String reportingDt;
    private String creditLimit;

    public Model(int fid, String serialNum, String memberCode, String acctType, String openedDt, String acctRteCde, String reportingDt, String creditLimit) {
        this.fid = fid;
        this.serialNum = serialNum;
        this.memberCode = memberCode;
        this.acctType = acctType;
        this.openedDt = openedDt;
        this.acctRteCde = acctRteCde;
        this.reportingDt = reportingDt;
        this.creditLimit = creditLimit;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public String getOpenedDt() {
        return openedDt;
    }

    public void setOpenedDt(String openedDt) {
        this.openedDt = openedDt;
    }

    public String getAcctRteCde() {
        return acctRteCde;
    }

    public void setAcctRteCde(String acctRteCde) {
        this.acctRteCde = acctRteCde;
    }

    public String getReportingDt() {
        return reportingDt;
    }

    public void setReportingDt(String reportingDt) {
        this.reportingDt = reportingDt;
    }

    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    public static String toCsvLine(Model model) {
        return model.getFid() + ";"
                + model.getSerialNum() + ";"
                + model.getMemberCode() + ";"
                + model.getAcctType() + ";"
                + model.getOpenedDt() + ";"
                + model.getAcctRteCde() + ";"
                + model.getReportingDt() + ";"
                + model.getCreditLimit();
    }
}
