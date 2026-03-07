package Builder;

public class ProductBuilderBeanImpl implements ProductBuilderBean{

    private static class ProductBuilderImplementation extends ProductProperties{

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
