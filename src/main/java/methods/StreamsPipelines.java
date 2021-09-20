package methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamsPipelines {

    public static Integer sum(List<Integer> list) {
        return list.stream().mapToInt((el) -> el).sum();
    }

    public static Integer production(List<Integer> list) {
        return list.stream().mapToInt((el) -> el).reduce((s1, s2) -> s1 * s2).orElse(0);
    }

    public static Integer oddSum(List<Integer> list) {
        return list.stream().filter(el -> el % 2 != 0).reduce(Integer::sum).orElse(0);
    }

    public static Map<Integer, Integer> sumByReminder(List<Integer> list, Integer divisor) {
        return list.stream()
                .collect(Collectors.groupingBy(el -> el % divisor, Collectors.summingInt(elFromGroup -> elFromGroup)));
    }

    class Person {
        public String name;
        public String lastName;
        public Integer phalanxing;
        public Integer shieldwalling;
        public Integer tercioning;
        public Integer wedging;

        public Person(String name, String lastName, Integer phalanxing, Integer shieldwalling, Integer tercioning, Integer wedging) {
            this.name = name;
            this.lastName = lastName;
            this.phalanxing = phalanxing;
            this.shieldwalling = shieldwalling;
            this.tercioning = tercioning;
            this.wedging = wedging;
        }

        public Double getTotalScore() {
            return (phalanxing + shieldwalling + tercioning + wedging) / 4.0;
        }

        public String getName() {
            return String.format("%s %s", name, lastName);
        }
    }

    List<Person> students = new ArrayList<>();

    {
        students.add(new Person("Eco", "Betty", 0, 83, 89, 59));
        students.add(new Person("Lodbrok", "Johnny", 61, 92, 67, 0));
        students.add(new Person("Paige", "Umberto", 75, 94, 0, 52));
    }

    private static String getMark(Double score) {
        if (score > 90) return "A";
        if (score >= 83) return "B";
        if (score >= 75) return "C";
        if (score >= 68) return "D";
        if (score >= 60) return "E";
        return "F";
    }

    public static Map<String, Double> totalScores(List<Person> students) {
        return students.stream().collect(Collectors.toMap(Person::getName, Person::getTotalScore));
    }

    public static Double averageTotalScore(List<Person> students) {
        return students.stream().mapToDouble(Person::getTotalScore).average().orElse(0.0);
    }

    // FIXME: что идёт на вход?
    public static Map<String, Double> averageScoresPerTask(List<Person> students) {
        return null;
    }

    public static Map<String, String> defineMarks(List<Person> students) {
        return students.stream().collect(Collectors.toMap(Person::getName, p -> getMark(p.getTotalScore())));
    }

    // FIXME: что идёт на вход?
    public static Double easiestTask(List<Person> students) {
        return students.stream().mapToDouble(Person::getTotalScore).average().orElse(0.0);
    }

    // FIXME: implement
    public static Collector printableStringCollector(List<Person> students) {
        return null;
    }
}
