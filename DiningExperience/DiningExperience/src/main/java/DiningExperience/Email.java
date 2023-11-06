package DiningExperience;

public class Email {
	private String firstName; //NOPMD this field will be manipulated later.
	private String lastname;
	private String password = null;
	private String deparment;
	private int defaultpasswordLength = 8;
	private String email;
	
	private String randomPassword(int lenght) {
		String set = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		char [] password = new char[lenght];
		for (int i = 0; i < lenght; i++) {
            int rand = (int) (Math.random()* set.length());
            password[i] = set.charAt(rand);
        }
        return new String(password);
    }
}
