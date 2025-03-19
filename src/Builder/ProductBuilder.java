package Builder;

public interface ProductBuilder {
    Product build();

    ProductBuilder withNAme(String name);
    ProductBuilder withAddress(String address);
    ProductBuilder withUser(String user);
    ProductBuilder withId(int id);

}
