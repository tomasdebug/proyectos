import java.time.*;

public class obtenerFecha
{
    private LocalDate fecha;
    public obtenerFecha() {
        fecha = LocalDate.now();
    }
       public obtenerFecha(LocalDate date) {
        fecha = date;
    }
    public int getDay() {
        return fecha.getDayOfMonth();
    }
    public int getMonth() {
        return fecha.getMonthValue();
    }
    public int getYear() {
        return fecha.getYear();
    }
    public obtenerFecha(int day, int month, int year) {
        try {
            fecha = LocalDate.of(year, month, day);
        } catch(DateTimeException e) {
            System.out.println("Invalid date, please try again.");
        }
    }
    public void setDate(int day, int month, int year) {
        fecha = LocalDate.of(year, month, day);
    }
    public Fecha addDays(int days) {
        return new Fecha(fecha.plusDays(days));
    }
    public int getWeekOfTheYear() {
        int week = fecha.getDayOfYear() / 7;
        int weekDay = fecha.getDayOfYear() % 7;
        int firstDay = fecha.ofYearDay(fecha.getYear(), 1).getDayOfWeek().ordinal();
        if(weekDay + firstDay >= 7){
            week++;
        } 
        return week;
    }
}
