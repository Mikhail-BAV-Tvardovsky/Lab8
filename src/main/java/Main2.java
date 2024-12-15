import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int age;
    private String gender;
    private String position; // Добавлено поле "Должность"
    private int salary;

    public Employee(String name, int age, String gender, String position, int salary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.position = position; // Присваиваем должность
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position; // Получение должности
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }
}

public class Main2 {
    public static void main(String[] args) {
        // Список сотрудников с должностью
        Employee[] persons = new Employee[]{
                new Employee("Semyon", 20, "Male", "Developer", 300000),
                new Employee("Nikita", 20, "Male", "Developer", 300000),
                new Employee("Egor", 21, "Male", "Manager", 250000),
                new Employee("Alex", 19, "Male", "Developer", 210000),
                new Employee("Mariya", 18, "Female", "HR", 33000),
                new Employee("Artem", 19, "Male", "Manager", 19000),
                new Employee("YuliyaFr", 20, "Female", "HR", 18000),
                new Employee("Alena", 19, "Female", "Manager", 15000),
                new Employee("Oleg", 54, "Male", "Developer", 300000),
                new Employee("Nataliya", 50, "Female", "HR", 25000),
                new Employee("Yuliya", 29, "Female", "Developer", 27000)
        };

        // Вызов метода для обработки сотрудников
        magicMethod(persons, "Developer", 3); // Пример: находим 3 самых высокооплачиваемых разработчиков
    }

    public static void magicMethod(Employee[] personal, String position, int numberEmployees) {
        // Обработка сотрудников и вывод результатов
        System.out.println(Arrays.stream(personal)
                .filter(e -> e.getPosition().equals(position))  // Фильтрация по должности
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())  // Сортировка по зарплате (по убыванию)
                .limit(numberEmployees)  // Ограничение до N сотрудников
                .sorted(Comparator.comparingInt(e -> e.getName().length()))  // Сортировка по длине имени (по возрастанию)
                .map(Employee::getName)  // Получение имен сотрудников
                .collect(Collectors.joining(", ", numberEmployees + " самых высокооплачиваемых сотрудников зовут: ", ";"))); // Сборка результата
    }
}
