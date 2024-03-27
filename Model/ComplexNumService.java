package Patterns.Homework.Model;

public class ComplexNumService {
    public static boolean checkComplexNum(String number){
        return number.matches("^[-+0-9i.,]+$");
        
    }
    public static ComplexNumber parseComplexNum(String number){
        int i = 1;
        if (number.indexOf("-") == 0){
            i = -1;
            number = number.substring(1);
        }
        String[] num = number.replaceAll("i","").replaceAll("I","").split("[+-]");
        if (num.length==2){
            return new ComplexNumber(Double.parseDouble(num[0])*i,number.contains("-") ? Double.parseDouble(num[1])*-1 : Double.parseDouble(num[1]));
        } else return new ComplexNumber(Double.parseDouble(num[0])*i,0);
    }

    public static String preparaStrToComplexNum(String number){
        return number.trim().replaceAll(",",".").replaceAll(" ","");
    }
    @Override
    public String toString() {
        return "ComplexNumService []";
    }
    
}
