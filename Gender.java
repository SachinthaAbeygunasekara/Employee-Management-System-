public class Gender {

    private int id;
    private String name;

    Gender() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    public boolean equals(Gender obj) {
        return obj.id ==this.id;
    }

}