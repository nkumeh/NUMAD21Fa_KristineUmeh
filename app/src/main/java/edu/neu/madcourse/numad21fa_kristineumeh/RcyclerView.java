package edu.neu.madcourse.numad21fa_kristineumeh;

public class RcyclerView {
    private String linkUrl;
    private String linkName;

    public RcyclerView(String linkUrl, String linkName) {
        this.linkUrl = linkUrl;
        this.linkName = linkName;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }
}
