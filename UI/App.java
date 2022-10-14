package Ex002Phonebook.UI;

import Ex002Phonebook.Config;
import Ex002Phonebook.Core.MVP.Presenter;
import Ex002Phonebook.Core.MVP.View;

import java.util.Scanner;

public class App {
    public static void ButtonClick() {
        System.out.print("\033[H\033[J");// ru.stackoverflow.com/questions/1315049/Как-очистить-консоль-в-java-во-время-действия-программы
        View view = new NewConsoleView();
        Presenter presenter = new Presenter(view, Config.pathDb);
        presenter.LoadFromFile();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean bool = true;

            while (bool) {
                System.out.println(" 1 - prev  2 - next 3 - add  4 - remove 5 - quit and save changes");
                String key = scanner.nextLine();
                System.out.print("\033[H\033[J");
                switch (key) {
                    case "1":
                        presenter.prev();
                        break;
                    case "2":
                        presenter.next();
                        break;

                    case "3":
                        presenter.add();
                        break;
                    case "4":
                        presenter.remove();
                        break;
                    case "5":
                        presenter.saveToFile();

                  finish();
                  bool = false;

                        break;

                    default:
                        System.out.println("Такой команды нет");
                        break;
                }
            }
        }

    }
    public static void finish()
    {
        System.out.println("Всего хорошего.");
    }
}
