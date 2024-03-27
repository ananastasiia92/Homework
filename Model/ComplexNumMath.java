package Patterns.Homework.Model;

public class ComplexNumMath {
    ComplexNumber number;

    /**Сложение двух комплексных чисел
     * @param a1 первое число
     * @param b1 второе число
     * @return результат сложения комплексных чисел (a1 + b1)
     */
    public static ComplexNumber add(ComplexNumber a1, ComplexNumber b1)
    {
        return new ComplexNumber(a1.getReal() + b1.getReal(), a1.getImaginary() + b1.getImaginary());
    }

    /**Вычитание из первого комплексного числа второго
     * @param a1 первое число
     * @param b1 второе число
     * @return результат вычитания комплексных чисел (a1 - b1)
     */
    public static ComplexNumber subtract(ComplexNumber a1, ComplexNumber b1)
    {
        return new ComplexNumber(a1.getReal() - b1.getReal(), a1.getImaginary() - b1.getImaginary());
    }
    public static ComplexNumber multiply(ComplexNumber a1, ComplexNumber b1)
    {
        return new ComplexNumber(a1.getReal() * b1.getReal() - a1.getImaginary() * b1.getImaginary(),
                                a1.getReal() * b1.getImaginary() + a1.getImaginary() * b1.getReal());
    }
    public static ComplexNumber divide(ComplexNumber a1, ComplexNumber b1)
    {
        return new ComplexNumber((a1.getReal() * b1.getReal() + a1.getImaginary() * b1.getImaginary()) / (b1.getReal() * b1.getReal() + b1.getImaginary() * b1.getImaginary()),
                                (a1.getImaginary() * b1.getReal() - a1.getReal() * b1.getImaginary()) / (b1.getReal() * b1.getReal() + b1.getImaginary() * b1.getImaginary()));
    }
}
