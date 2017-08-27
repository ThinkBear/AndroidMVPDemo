package cn.thinkbear.app.androidmvpdemo.vo;

/**
 * @author ThinkBear
 * @version 1.0.0
 * @date 2017-6-23
 */
public class AndroidUpdate {

    private String updateContent;
    private String link;
    private String versionName;
    private int versionCode;
    private long updateTime;

    public String getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }


}
