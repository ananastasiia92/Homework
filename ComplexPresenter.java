package Patterns.Homework;

import Patterns.Homework.Model.ComplexNumMath;
import Patterns.Homework.Model.ComplexNumService;
import Patterns.Homework.Model.ComplexNumber;
import Patterns.Homework.View.InputData;
import Patterns.Homework.View.Log;
import Patterns.Homework.View.LogFile;

public class ComplexPresenter {
    private Log currentLog;
    private String pathLog;

    public ComplexPresenter(Log startLog) {
        this.currentLog = startLog;
        this.pathLog = "log.txt";
    }
    private boolean stop(String message){
        currentLog.writeMessage("Завершение работы");
        currentLog.setLog(new LogFile(pathLog));
        currentLog.writeLog(message);
        return false;
    }
    private ComplexNumber calculations(ComplexNumber complexNumber1, ComplexNumber complexNumber2, String operand){
        switch (operand){
            case "+": return ComplexNumMath.add(complexNumber1,complexNumber2);
            case "-": return ComplexNumMath.subtract(complexNumber1,complexNumber2);
            case "*": return ComplexNumMath.multiply(complexNumber1,complexNumber2);
            case "/": return ComplexNumMath.divide(complexNumber1,complexNumber2);
            default:
                throw new IllegalStateException("Неизвестный операнд: " + operand);
        }
    }

    private boolean operation(){

        ComplexNumber complexNumber1;
        String data;
        while (true) {
            currentLog.writeMessage("Введите первое комплексное число: ");
            data = InputData.getData();
            if (ComplexNumService.checkComplexNum(data)) {
                complexNumber1 = ComplexNumService.parseComplexNum(ComplexNumService.preparaStrToComplexNum(data));
                break;
            } else {
                currentLog.writeMessage("Неверное число");
            }
        }
        String operand;
        while (true){
            currentLog.writeMessage("Введите операцию: + - * /");
            operand = InputData.getData();
            if (operand.matches("[-+*/]")){
                break;
            }else {
                currentLog.writeMessage("Неверный операнд");
            }

        }
        ComplexNumber complexNumber2;
        while (true) {
            currentLog.writeMessage("Введите второе комплексное число: ");
            data = InputData.getData();
            if (ComplexNumService.checkComplexNum(data)) {
                complexNumber2 = ComplexNumService.parseComplexNum(ComplexNumService.preparaStrToComplexNum(data));
                break;
            } else {
                currentLog.writeMessage("Неверное число");
            }
        }
        ComplexNumber result = calculations(complexNumber1, complexNumber2,operand);
        currentLog.writeMessage(complexNumber1 + " " + operand + " " + complexNumber2 + " = " + result);
        currentLog.setLog(new LogFile(pathLog));
        currentLog.writeLog(complexNumber1 + " " + operand + " " + complexNumber2 + " = " + result);
        return true;
    }
    public void start(){
        currentLog.writeMessage("Калькулятор комплексных чисел");
        boolean run = true;
        String data;
        while (run){
            currentLog.writeMessage("Выберите действие\n1. Операции с комплексными числами\n2. Выход");
            data = InputData.getData();
            switch (data){
                case "1":
                    run = operation();
                    break;
                case "2":
                    run = stop("Exit");
                    break;
                default:
                    currentLog.writeMessage("Неверный ввод");
            }
        }
    }

    
}
