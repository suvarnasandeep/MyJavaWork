package Builder;

public class main {
    public static void main(String[] args) {
        ProductBuilderBean builder = new ProductBuilderBeanImpl();
        Product p = builder.create()
                .withNAme("sandeep")
                .withUser("suvarna")
                .withId(1111)
                .build();

        System.out.println(p.toString());
    }
}
