import java.util.Scanner;

class Main {
    public static User[] getUsers() {
        User user1 = new User("jhon", "jhon@gmail.com", "pass", 24);
        User user2 = new User("kate", "kate@gmail.com", "pass", 17);
        User user3 = new User("dj", "dj@gmail.com", "pass", 39);
        User user4 = new User("mari", "mari@gmail.com", "pass", 28);
        return new User[]{user1, user2, user3, user4};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.getAge() < 18) {
            throw new AccessDeniedException("Доступ запрещен!");
        }
    }

    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Введите логин:");
        String login = scanner.nextLine();

        System.out.println("Введите пароль:");
        String password = scanner.nextLine();

        User user = getUserByLoginAndPassword(login, password);
        validateUser(user);
        System.out.println("Доступ предоставлен!");
    }

}
