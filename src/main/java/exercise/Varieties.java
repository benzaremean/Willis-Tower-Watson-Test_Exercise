package exercise;

enum Varieties {
    VARIETY1("Variety 1"), 
    VARIETY2("Variety 2"), 
    VARIETY3("Variety 2"), 
    VARIETY4("Variety 4");

    private String displayName;

    public String getDisplayName() {
        return this.displayName;
    }

    private Varieties(String name) {
        this.displayName = name;
    }
}