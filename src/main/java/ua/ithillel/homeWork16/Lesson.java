package ua.ithillel.homeWork16;

public class Lesson {
    private int id;
    private String name;
    private String homework;

    public Lesson() {
    }

    public Lesson(int id, String name, String homework) {
        this.id = id;
        this.name = name;
        this.homework = homework;
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

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", homework='" + homework + '\'' +
                '}';
    }
}
