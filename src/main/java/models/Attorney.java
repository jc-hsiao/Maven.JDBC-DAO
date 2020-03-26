package models;

public class Attorney {

    private Integer id;
    private String firstName;
    private String lastName;
    private int age;
    private String occupation;
    private String eyeColor;
    private String hairColor;
    private String themeColor;
    private String office;

    public Attorney(){}

    public Attorney(Integer id, String firstName, String lastName, int age, String occupation, String eyeColor, String hairColor, String themeColor, String office) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.occupation = occupation;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.themeColor = themeColor;
        this.office = office;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getThemeColor() {
        return themeColor;
    }

    public void setThemeColor(String themeColor) {
        this.themeColor = themeColor;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }


    @Override
    public String toString() {
        return "Attorney{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", hairColor='" + hairColor + '\'' +
                ", themeColor='" + themeColor + '\'' +
                ", office='" + office + '\'' +
                "}\n";
    }
}
