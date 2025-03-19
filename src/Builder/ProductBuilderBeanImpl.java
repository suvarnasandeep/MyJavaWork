package Builder;

public class ProductBuilderBeanImpl implements ProductBuilderBean{

    private static class ProductBuilderImplementation implements ProductBuilder{
        String name = null;
        String address = null;
        String user = null;
        int id = 0;

        @Override
        public ProductBuilder withNAme(String name) {
            this.name = name;
            return this;
        }
        @Override
        public ProductBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        @Override
        public ProductBuilder withUser(String user) {
            this.user = user;
            return this;
        }

        @Override
        public ProductBuilder withId(int id) {
            this.id = id;
            return this;
        }

        @Override
        public Product build() {
            Product p = new Product();
            p.setName(name);
            p.setAddress(address);
            p.setUser(user);
            p.setId(id);
            return p;
        }
    }

    @Override
    public ProductBuilder create() {
        return new ProductBuilderImplementation();
    }
}
