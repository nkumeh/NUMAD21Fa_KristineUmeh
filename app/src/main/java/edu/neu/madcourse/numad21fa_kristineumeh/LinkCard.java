package edu.neu.madcourse.numad21fa_kristineumeh;

public class LinkCard implements LinkClickListener {

    private final String linkName;
    private final String linkUrl;
    private boolean isClicked;

    public LinkCard(String linkName, String linkUrl, boolean isClicked) {
        this.linkName = linkName;
        this.linkUrl = linkUrl;
        this.isClicked = isClicked;
    }

    public String getLinkName() {
        return linkName + (isClicked ? "clicked" : "");
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public boolean isClicked() {
        return isClicked;
    }

    @Override
    public void clickItem(int position) {
        isClicked = !isClicked;
    }
}
