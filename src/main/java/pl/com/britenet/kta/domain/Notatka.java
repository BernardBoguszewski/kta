package pl.com.britenet.kta.domain;

/**
 * Created by Britenet on 2017-07-13.
 */
public class Notatka {

    private String text;
    private String attachment;

    public Notatka(String text, String attachment) {
        this.text = text;
        this.attachment = attachment;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}
