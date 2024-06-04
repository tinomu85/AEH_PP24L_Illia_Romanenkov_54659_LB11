package pl.pp;

import java.util.*;

class Student {
    private String indeks;
    private String imie;
    private String nazwisko;
    private List<Integer> oceny;

    public Student(String indeks, String imie, String nazwisko, List<Integer> oceny) {
        this.indeks = indeks;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.oceny = oceny;
    }

    public String getIndeks() {
        return indeks;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public List<Integer> getOceny() {
        return oceny;
    }

    public double obliczSrednia() {
        int suma = 0;
        for (int ocena : oceny) {
            suma += ocena;
        }
        return suma / (double) oceny.size();
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko + " (" + indeks + ") - Average: " + String.format("%.2f", obliczSrednia());
    }
}

public class mojaJedenastaAplikacja {
    public static void main(String[] args) {
        List<Student> studenci = Arrays.asList(
                new Student("12345", "Jan", "Kowalski", Arrays.asList(4, 5, 3, 5)),
                new Student("67890", "Anna", "Nowak", Arrays.asList(5, 5, 4, 4)),
                new Student("54321", "Paweł", "Wiśniewski", Arrays.asList(2, 3, 2, 4)),
                new Student("09876", "Katarzyna", "Kowalczyk", Arrays.asList(5, 4, 4, 5))
        );

        Student najlepszyStudent = Collections.max(studenci, Comparator.comparingDouble(Student::obliczSrednia));

        // Obliczenie średniej ocen wszystkich studentów
        double sredniaWszystkich = studenci.stream().mapToDouble(Student::obliczSrednia).average().orElse(0.0);

        // Sortowanie studentów według nazwisk
        List<Student> posortowaniStudenci = new ArrayList<>(studenci);
        posortowaniStudenci.sort(Comparator.comparing(Student::getNazwisko));

        // Wynik działania programu
        System.out.println("Student z najwyższą średnią: " + najlepszyStudent);
        System.out.println();
        System.out.println("Studenci posortowani według nazwisk:");
        for (Student student : posortowaniStudenci) {
            System.out.println(student);
        }
    }
}
