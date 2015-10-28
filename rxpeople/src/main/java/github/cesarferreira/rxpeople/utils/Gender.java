package github.cesarferreira.rxpeople.utils;

public enum Gender {

    MALE("male"), FEMALE("female");

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
