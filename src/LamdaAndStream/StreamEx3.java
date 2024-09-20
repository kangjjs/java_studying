package LamdaAndStream;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx3 {

    static class Student implements Comparable<Student> {
        String name;
        int ban;
        int totalScore;

        Student(String name, int ban, int totalScore) {
            this.name = name;
            this.ban = ban;
            this.totalScore = totalScore;
        }

        public String toString() {
            return String.format("[%s, %d, %d]", name, ban, totalScore)
                    .toString();
        }

        public String getName() {
            return name;
        }

        public int getBan() {
            return ban;
        }

        public int getTotalScore() {
            return totalScore;
        }

        @Override
        public int compareTo(Student o) {
            return o.totalScore - this.totalScore;
        }
    }

    public static void main(String[] args) {
        Student[] stuArr = {
                new Student("이자바", 3, 300),
                new Student("김자바", 1, 200),
                new Student("안자바", 2, 100),
                new Student("박자바", 2, 150),
                new Student("소자바", 1, 200),
                new Student("나자바", 3, 290),
                new Student("감자바", 3, 180)
        };

        Stream<Student> studentStream = Stream.of(stuArr);
        studentStream.sorted(Comparator.comparing(Student::getBan)
                        .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);
        studentStream = Stream.of(stuArr);
        IntStream intStream = studentStream.mapToInt(Student::getTotalScore);
        IntSummaryStatistics stat = intStream.summaryStatistics();
        System.out.println("count=" + stat.getCount());
        System.out.println("sum=" + stat.getSum());
        System.out.println("average=" + stat.getAverage());
        System.out.println("min=" + stat.getMin());
        System.out.println("max=" + stat.getMax());
    }
}
