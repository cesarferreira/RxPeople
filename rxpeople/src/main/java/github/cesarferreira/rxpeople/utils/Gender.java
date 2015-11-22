package github.cesarferreira.rxpeople.utils;

public class Gender {

    public static final String MALE = "male";
    public static final String FEMALE = "female";

    private final String name;

    private Gender(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    public String toString() {
        return name;
    }


}
