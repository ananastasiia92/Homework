package Patterns.Homework;

import Patterns.Homework.View.Log;
import Patterns.Homework.View.LogConsole;

/*
 * Создать проект калькулятора комплексных чисел (достаточно сделать сложение, умножение и деление).
Применить при создании программы архитектурные паттерны, добавить логирование калькулятора.
Соблюдать принципы SOLID, паттерны проектирования.
 */
public class Main {
    public static void main(String[] args) {
        ComplexPresenter control = new ComplexPresenter(new Log(new LogConsole()));
        control.start();
    }
}
