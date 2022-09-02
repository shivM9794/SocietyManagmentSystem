package app.societymanagementsystem.View.HelperClass;

public class NoticeHelperClass {

    String date,notice,noticeDetails;

    public NoticeHelperClass(String date, String notice, String noticeDetails) {
        this.date = date;
        this.notice = notice;
        this.noticeDetails = noticeDetails;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getNoticeDetails() {
        return noticeDetails;
    }

    public void setNoticeDetails(String noticeDetails) {
        this.noticeDetails = noticeDetails;
    }
}
