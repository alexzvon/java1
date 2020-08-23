package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderProcessor {
    final private Path startPath;
    final PathMatcher pathMatcher;
    int count = 0;
    List<Order> listOrder = new ArrayList<>();

    public OrderProcessor(String startPath) {
        this.startPath = Paths.get(startPath);
        pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/???-??????-????.csv");
    }

    public int loadOrders(LocalDate start, LocalDate finish, String shopId) {
        try {
            Files.walkFileTree(startPath, new SimpleFileVisitor<>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (pathMatcher.matches(file)) {
                        if (!checkLDS(start, finish, shopId, file)) {
                            listOrder.add(new Order(file));
                        }
                    }

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    count++;
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }

    private boolean checkLDS(LocalDate start, LocalDate finish, String shopId, Path file) throws IOException {
        LocalDate date = LocalDate.parse(Files.getLastModifiedTime(file).toString().split("T")[0]);

        if (start != null && start.isAfter(date)) {
            return false;
        }

        if (start != null && finish.isBefore(date)) {
            return false;
        }

        return shopId == null || shopId.equals(file.getFileName().toString().split("\\.")[0].split("-")[0]);
    }

    public static void main(String[] args) {
        String startPath = "/home/aleksey/leson17/z3/";

        LocalDate start = LocalDate.parse("2020-08-23");
        LocalDate finish = LocalDate.parse("2020-08-23");
        String shopId = null;

        OrderProcessor orderProcessor = new OrderProcessor(startPath);

        System.out.println(orderProcessor.loadOrders(start, finish, shopId));

    }
}


//Реализовать класс OrderProcessor со следующими методами
//
//3.3 конструктор public OrderProcessor(String startPath) - инициализирует класс,
// с указанием начальной папки для хранения файлов
//
//3.4 метод public int loadOrders(LocalDate start, LocalDate finish, String shopId) - загружает заказы
// за указанный диапазон дат, с start до finish, обе даты включительно. Если start == null,
// значит нет ограничения по дате слева, если finish == null, значит нет ограничения по дате справа,
// если shopId == null - грузим для всех магазинов При наличии хотя бы одной ошибке в формате файла,
// файл полностью игнорируется, т.е. Не поступает в обработку. Метод возвращает количество файлов с ошибками.
// При этом, если в классе содержалась информация, ее надо удалить
//
//
//3.5 метод public List<Order> process(String shopId) - выдать список заказов в порядке обработки
// (отсортированные по дате-времени), для заданного магазина. Если shopId == null, то для всех
//
//3.6 метод public Map<String, Double> statisticsByShop() - выдать информацию по объему продаж по магазинам
// (отсортированную по ключам): String - shopId, double - сумма стоимости всех проданных товаров в этом
// магазине
//
//3.7 метод public Map<String, Double> statisticsByGoods() - выдать информацию по объему продаж по товарам
// (отсортированную по ключам): String - goodsName, double - сумма стоимости всех проданных товаров этого
// наименования
//
//3.8 метод public Map<LocalDate, Double> statisticsByDay() - выдать информацию по объему продаж по дням
// (отсортированную по ключам): LocalDate - конкретный день, double - сумма стоимости всех проданных
// товаров в этот день
