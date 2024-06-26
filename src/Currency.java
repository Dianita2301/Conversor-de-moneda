public enum Currency {
    ARS("peso argentino"),
    BOB("boliviano boliviano"),
    BRL("real brasileño"),
    CLP("peso chileno"),
    COP("peso colombiano"),
    USD("dólar estadounidense");

    private final String name;

    Currency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
