package VotingSystem;
import java.util.Arrays;
import java.util.Collections;

public class VotingSystemDemo {
    public static void main(String args[]) {
        VotingSystem votingSystem = new VotingSystem();

        // Создаем кандидатов
        Candidate candidate1 = new Candidate(10001, "Игорь Додон", Party.PCRM);
        Candidate candidate2 = new Candidate(10002, "Майя Санду", Party.PLDM);
        Candidate candidate3 = new Candidate(10003, "Владимир Воронин", Party.PCUS);
        Candidate candidate4 = new Candidate(10004, "Владимир Филат", Party.PDM);

        // Добавляем кандидатов в список
        System.out.println("===Добавляем кандидатов в список============================");
        votingSystem.add(candidate1);
        votingSystem.add(candidate2);
        votingSystem.add(candidate3);
        votingSystem.add(candidate4);

        // Вывод списка кандидатов
        System.out.println();
        System.out.println("===Вывод списка кандидатов==================================");
        votingSystem.printCandidates();

        // Удаляем кандидата из списка
        System.out.println();
        System.out.println("===Удаляем кандидата из списка==============================");
        votingSystem.remove(candidate4);

        // Вывод списка кандидатов
        System.out.println();
        System.out.println("===Вывод списка кандидатов==================================");
        votingSystem.printCandidates();

        // Создаем пользователей
        User user1 = new User("Иван Ургант", "ve4ernii_tak_sebe_iumor");
        User user2 = new User("Николай Басков", "spasibo_mame_za_papu");
        User user3 = new User("Земфира", "iskala_tebea_a_nashla_sebea");
        User user4 = new User("Александр Буйнов", "bez_o4kov_prozra4nei_svet");
        User user5 = new User("Иван Дорн", "nas_bilo_dvoe_jalko_4to_ne_troe");
        User user6 = new User("Александр Буйнов", "wrong_password");

        // Регистрируем пользователей
        System.out.println();
        System.out.println("===Регистрируем пользователей===============================");
        votingSystem.register(user1);
        votingSystem.register(user2);
        votingSystem.register(user3);
        votingSystem.register(user4);
        votingSystem.register(user5);

        // Попытка зарегистрировать пользователя с тем же именем
        System.out.println();
        System.out.println("===Попытка зарегистрировать пользователя с тем же именем====");
        votingSystem.register(user6);

        // Авторизируем пользователей
        System.out.println();
        System.out.println("===Авторизируем пользователей===============================");
        votingSystem.authorize(user1);
        votingSystem.authorize(user2);
        votingSystem.authorize(user3);
        votingSystem.authorize(user4);
        votingSystem.authorize(user5);

        // Вывод списка авторизированных пользователей
        System.out.println();
        System.out.println("===Вывод списка авторизированных пользователей==============");
        votingSystem.printAuthorizedUsers();

        // Удаление пользователя
        System.out.println();
        System.out.println("===Удаление пользователя====================================");
        votingSystem.delete(user3);

        // Вывод списка авторизированных пользователей
        System.out.println();
        System.out.println("===Вывод списка авторизированных пользователей==============");
        votingSystem.printAuthorizedUsers();

        // Пользователи голосуют за кандидатов
        System.out.println();
        System.out.println("===Пользователи голосуют за кандидатов======================");
        votingSystem.vote(user1, candidate1);
        votingSystem.vote(user2, candidate3);
        votingSystem.vote(user3, candidate2);
        votingSystem.vote(user4, candidate3);

        // Выход пользователя из системы
        System.out.println();
        System.out.println("===Выход пользователя из системы============================");
        votingSystem.logOut(user5);

        // Вывод списка авторизированных пользователей
        System.out.println();
        System.out.println("===Вывод списка авторизированных пользователей==============");
        votingSystem.printAuthorizedUsers();

        // Попытка неавторизированного пользователя проголосовать
        System.out.println();
        System.out.println("===Попытка неавторизированного пользователя проголосовать===");
        votingSystem.vote(user5, candidate3);

        // Попытка повторного голосования пользователя
        System.out.println();
        System.out.println("===Попытка повторного голосования пользователя==============");
        votingSystem.vote(user2, candidate2);

        // Вывод списка кандидатов
        System.out.println();
        System.out.println("===Вывод списка кандидатов==================================");
        votingSystem.printCandidates();

        // Вывод кандидата с наибольшим количеством голосов
        System.out.println();
        System.out.println("===Вывод кандидата с наибольшим количеством голосов=========");
        votingSystem.printHighestVotedCandidate();
    }
}
