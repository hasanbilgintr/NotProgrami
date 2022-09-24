package BLL;

import java.util.Date;
public class notes {

    /*kod düzenleme alt+şift +f */
    private int id;
    private byte noteType;
    private int companyId;
    private String subject;
    private String description;
    private Date createDate;
    private Date requestDate;
    private Date delivertyDate;
    private Date planDate;
    private byte isPicture;
    private byte isWait;
    private byte do_;
    private byte status;
    private int userId;

    public notes(int id, byte noteType, int companyId, String subject, String description, Date createDate, Date requestDate, Date delivertyDate, Date planDate, byte isPicture, byte isWait, byte do_, byte status, int userId) {
        this.id = id;
        this.noteType = noteType;
        this.companyId = companyId;
        this.subject = subject;
        this.description = description;
        this.createDate = createDate;
        this.requestDate = requestDate;
        this.delivertyDate = delivertyDate;
        this.planDate = planDate;
        this.isPicture = isPicture;
        this.isWait = isWait;
        this.do_ = do_;
        this.status = status;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNoteType() {
        return noteType;
    }

    public void setNoteType(byte noteType) {
        this.noteType = noteType;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getDelivertyDate() {
        return delivertyDate;
    }

    public void setDelivertyDate(Date delivertyDate) {
        this.delivertyDate = delivertyDate;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public byte getIsPicture() {
        return isPicture;
    }

    public void setIsPicture(byte isPicture) {
        this.isPicture = isPicture;
    }

    public byte getIsWait() {
        return isWait;
    }

    public void setIsWait(byte isWait) {
        this.isWait = isWait;
    }

    public byte getDo_() {
        return do_;
    }

    public void setDo_(byte do_) {
        this.do_ = do_;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
