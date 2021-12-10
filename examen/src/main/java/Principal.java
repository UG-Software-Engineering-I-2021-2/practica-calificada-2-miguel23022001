import org.testng.Assert;

import java.util.*;

public class Principal {
    final private Map<Integer, List<Pair<Teacher, Boolean>>> allYearsTeachers = Map.ofEntries(
            new AbstractMap.SimpleImmutableEntry<>(
                    2020,
                    List.of(
                            new Pair<>( new ProfesorTC("Josefina"), true),
                            new Pair<>( new ProfesorTC("Edonisio"), true),
                            new Pair<>( new ProfesorTC("Edufasio"), false)
                    )
            ),
            new AbstractMap.SimpleImmutableEntry<>(
                    2019,
                    List.of(
                            new Pair<>( new ProfesorTC("Eduarda"), false),
                            new Pair<>( new ProfesorTC("Abelardo"), false),
                            new Pair<>( new ProfesorTC("Francisca"), false)
                    )
            )
    );
    private final int yearToCalculate;

    public Principal(int yearToCalculate) {
        this.yearToCalculate = yearToCalculate;
    }
    public float calculateGrades(final List<Pair<Integer, Float>> examsStudents, final boolean hasReachedMinimumClasses) {
        if (!examsStudents.isEmpty()) {
            boolean hasToIncreaseOneExtraPoint = isHasToIncreaseOneExtraPoint(yearToCalculate);
            float gradesSum       = 0f;
            int   gradesWeightSum = 0;

            for (Pair<Integer, Float> examGrade : examsStudents) {
                gradesSum += (examGrade.first() * examGrade.second() / 100);
                gradesWeightSum += examGrade.first();
            }
            if (gradesWeightSum == 100) {
                if (hasReachedMinimumClasses) {
                    if (hasToIncreaseOneExtraPoint) {
                        return Float.min(10f, gradesSum + 1);
                    }
                    return gradesSum;
                }
                return 0f;
            } else if (gradesWeightSum > 100) {
                return -1f;
            }
            return -2f;
        }
        return 0f;
    }

    private boolean isHasToIncreaseOneExtraPoint(final int year) {
        boolean hasToIncreaseOneExtraPoint = false;

        for (Map.Entry<Integer, List<Pair<Teacher, Boolean>>> yearlyTeachers : allYearsTeachers.entrySet()) {
            if (year == yearlyTeachers.getKey()) {
                List<Pair<Teacher, Boolean>> teachers = yearlyTeachers.getValue();
                for (Pair<Teacher, Boolean> teacher : teachers) {
                    if (!teacher.second()) {
                        continue;
                    }
                    hasToIncreaseOneExtraPoint = true;
                }
            }
        }
        return hasToIncreaseOneExtraPoint;
    }

    public List<String> TeachersIncreaseOneExtra(){
        List<String> teachersName = new ArrayList<>();
        for (Map.Entry<Integer, List<Pair<Teacher, Boolean>>> yearlyTeachers : allYearsTeachers.entrySet()) {
            if (yearToCalculate == yearlyTeachers.getKey()) {
                List<Pair<Teacher, Boolean>> teachers = yearlyTeachers.getValue();
                for (Pair<Teacher, Boolean> teacher : teachers) {
                    if (teacher.second()) {
                        teachersName.add(teacher.first()._Nombre);
                    }
                }
            }
        }
        return teachersName;
    }

    public List<String> StudentWithOneExtra(final List<Pair<Student, Integer>> Students){
        List<String> StudentsName = new ArrayList<>();
        for (Pair<Student, Integer> student : Students) {
            if (isHasToIncreaseOneExtraPoint(student.second())) {
                StudentsName.add(student.first()._Nombre);
            }
        }
        return StudentsName;
    }

    public static void main(String[] args) {
        System.out.println("Hola");
    }
}
