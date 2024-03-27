package Patterns.Homework.View;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    private Logging log;
    private final SimpleDateFormat date;

    public Log(Logging log) {
        this.log = log;
        String datePattern = "yyyy-MM-dd HH:mm:ss";
        date = new SimpleDateFormat(datePattern);
    }

    public void setLog(Logging log) {
        this.log = log;
    }

    /** Вывод сообщения с указанием даты
     *
     * @param message сообщение
     */
    public void writeLog(String message) {
        String currentDate = date.format(new Date());
        log.writeMessage(currentDate+ " " + message);
    }

    /** Вывод сообщения
     *
     * @param message сообщение для вывода
     */
    public void writeMessage(String message) {
        log.writeMessage(message);
    }
}
