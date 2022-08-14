package day11.thread.produceconsume;

public class Cake {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cake(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "name='" + name + '\'' +
                '}';
    }
}
