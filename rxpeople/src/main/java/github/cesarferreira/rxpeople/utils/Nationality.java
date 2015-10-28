package github.cesarferreira.rxpeople.utils;


public enum Nationality {
    AU("AU"), ES("ES"), FR("FR"), GB("GB"), IE("IE"), NL("NL"), US("US"), BR("BR"), CA("CA"), DE("DE"), FI("FI"), NZ("NZ");

    private final String name;

    Nationality(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    public String toString() {
        return name;
    }

}
