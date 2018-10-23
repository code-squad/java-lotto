package coordinate;

public enum Type {
    LINE(2), TRIANGLE(3), RECTANGLE(4);

    int size;

    Type(int size) {
        this.size = size;
    }

    public boolean matchSize(int size) {
        return this.size == size;
    }

    public static Type findType(int size) {
        for (Type type : Type.values()) {
            if(type.matchSize(size)) {
                return type;
            }
        }
        return null;
    }
}
