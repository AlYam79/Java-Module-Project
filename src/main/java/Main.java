import java.util.Locale;

public class Main {
    public static String chooseSuffix(float number) {  // Создаем метод который выбирает окончания.
        int divider = 10;                              // Объявляем переменную делителя
        if (number >= 11 && number <=14) {
            divider = 100;
        }
        int value = (int) Math.floor(number) % divider; // Округляем number и извлекаем последнюю цифру

        String suffix;

        switch (value) {
            case 1:
                suffix = "рубль";
                break;
            case 2:
            case 3:
            case 4:
                suffix = "рубля";
                break;
            default:
                suffix = "рублей";
                break;
        }
        return suffix;
    }


    public static void main(String[] args) {
        Persons persons = new Persons();  // Создаём новый объект класса Persons
        persons.read();      //  Вызываем метод read класса Persons.

        Calculator calculator = new Calculator(); // Создаём новый объект класса Persons
        calculator.calculate();  //  Вызываем метод calculate класса Calculator.

        for (Product product : calculator.products) {  // Из объекта calculator класса Calсulator в вытаскиваем список продуктов.
            System.out.println(String.format(Locale.US, "Добавленные товары: %s - %.2f Руб.", product.name, product.cost)); // Для каждого продукта из списка печатаем его имя и цену.
        }
        float averageCheck = (float) (calculator.total / persons.count); // Подсчитываем средний чек

        System.out.println(String.format(Locale.US, "%.2f  %s  с каждого гостя.", averageCheck, chooseSuffix(averageCheck)));
    }

}
