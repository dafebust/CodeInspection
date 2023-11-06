package DiningExperience;

public class Email {
    private final String firstName;
    private final String lastname;
    private final String password;
    private final String deparment;
    private final int defaultpasswordLength = 8;
    private final String email;

    public Email(String firstName, String lastname, String deparment, String email) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.password = randomPassword(defaultpasswordLength);
        this.deparment = deparment;
        this.email = email;
    }

    public void imprimir() {
        System.out.println("Nombre: " + firstName);
        System.out.println("Apellido: " + lastname);
        System.out.println("Contraseña: " + password);
        System.out.println("Departamento: " + deparment);
        System.out.println("Email: " + email);
    }

    private String randomPassword(int length) {
        String set = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * set.length());
            password[i] = set.charAt(rand);
        }
        return new String(password);
    }
}
