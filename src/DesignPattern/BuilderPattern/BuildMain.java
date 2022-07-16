package BuilderPattern;

public class BuildMain {

	public static void main(String[] args) {
		User user1 = new User.UserBuilder("sandeep", "suvarna").build();
		User user2 = new User.UserBuilder("Anup", "Kumar").age("28").build();
		User user3 = new User.UserBuilder("Prashant", "chiku").age("27").salary("50000").build();
		User user4 = new User.UserBuilder("Kapil", "kaadu").residence("nagpur").salary("25000").build();
		
		System.out.println(user1);
		System.out.println(user2);
		System.out.println(user3);
		System.out.println(user4);

	}

}
