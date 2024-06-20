package dev.dopamines.boot_up.board.project.model.response;

public class ProjectBoardRes {
    private Long idx;
    private String title;
    private String video;
    private String contents;
    private int courseNum;
    private String teamName;
    private String member;

    public ProjectBoardRes(Long idx, String title, String video, String contents, int courseNum, String teamName,
                           String member) {
        this.idx = idx;
        this.title = title;
        this.video = video;
        this.contents = contents;
        this.courseNum = courseNum;
        this.teamName = teamName;
        this.member = member;
    }

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(int courseNum) {
        this.courseNum = courseNum;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }
}
