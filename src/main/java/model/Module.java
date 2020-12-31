package model;

public class Module {
    private int id;
    private String name;
    private String courseId;

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

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Module(int id, String name, String courseId) {
        this.id = id;
        this.name = name;
        this.courseId = courseId;
    }

    public Module() {
    }
}
