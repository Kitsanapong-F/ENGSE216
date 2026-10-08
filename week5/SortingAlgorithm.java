package week5;

/**
 * Interface สำหรับกำหนดสัญญา (Contract) ของอัลกอริทึมการเรียงลำดับข้อมูล
 * ใช้หลักการ Abstraction และ Polymorphism (Strategy Pattern)
 */
public interface SortingAlgorithm {
    void sort(int[] array);
    String getName();
}

