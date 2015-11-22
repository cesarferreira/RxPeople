package github.cesarferreira.rxpeople.utils;


public class Nationality {

    public static final String AU = "AU";
    public static final String ES = "ES";
    public static final String FR = "FR";
    public static final String GB = "GB";
    public static final String IE = "IE";
    public static final String NL = "NL";
    public static final String US = "US";
    public static final String BR = "BR";
    public static final String CA = "CA";
    public static final String DE = "DE";
    public static final String FI = "FI";
    public static final String NZ = "NZ";

    private final String name;

    Nationality(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return (otherName != null) && name.equals(otherName);
    }

    public String toString() {
        return name;
    }

}
