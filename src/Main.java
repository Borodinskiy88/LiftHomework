import java.util.*;

public class Main {

    public static void main(String[] args) {
        Deque<Integer> elevator = new ArrayDeque<>();

        while (true) {
            System.out.println("Ожидаю ввода этажа: (для завершения нажмите 0)");
            Scanner scanner = new Scanner(System.in);
            int stage = Integer.parseInt(scanner.nextLine());
            if (stage >= 0 && stage < 26) {
                int last = 0;
                while (elevator.peek() != null) {
                    last = elevator.peekLast();
                    break;
                }
                elevator.add(stage);
                if (last == stage) {
                    elevator.removeLast();
                    System.out.println("Лифт уже находится на этом этаже");
                    System.out.println();
                }

                if (stage == 0) {
                    System.out.println("Лифт проехал по следующим этажам:");
                    while (!elevator.isEmpty()) {
                        int s = elevator.poll();
                        System.out.print(s + " этаж" + "->" + " ");
                    }
                    System.out.println();
                    System.out.println("Программа завершена!");
                    break;
                }

            } else {
                System.out.println("Такого этажа в доме нет");
            }
        }
    }
}
