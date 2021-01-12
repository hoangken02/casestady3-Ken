package model;

public class Classroom {
    private int id;
    private String name;
    private int centerId;
    private int courseId;
    private int userId;
    private int recentModuleId;
    private String startDate;
    private String endDate;

    public Classroom() {
    }

    public Classroom(String className) {
        this.name = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRecentModuleId() {
        return recentModuleId;
    }

    public void setRecentModuleId(int recentModuleId) {
        this.recentModuleId = recentModuleId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Classroom(int id, String name, int centerId, int courseId, int userId, int recentModuleId, String startDate, String endDate) {
        this.id = id;
        this.name = name;
        this.centerId = centerId;
        this.courseId = courseId;
        this.userId = userId;
        this.recentModuleId = recentModuleId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Classroom(String name, int centerId, int courseId, int userId, int recentModuleId, String startDate, String endDate) {
        this.name = name;
        this.centerId = centerId;
        this.courseId = courseId;
        this.userId = userId;
        this.recentModuleId = recentModuleId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
