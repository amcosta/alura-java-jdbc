package dev.amcosta.model;

public class Product {

    private Integer id;
    private String name;
    private String description;

    public Product(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("O produto [%d] é: %s, %s",
                this.id,
                this.name,
                this.description
        );
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
