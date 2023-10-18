package second_homework.life_cycle_JUnit5;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import second_homework.hw.Motorcycle;
import second_homework.hw.Car;

public class TestLC {
    static Object[] provideCars() {
        return new Object[] {
                new Car("Tesla", "X", 2022),
                new Car("Toyota", "Camry", 2021),
                new Car("Honda", "civic", 2004),
        };
    }

    @Test
    void carIsCar(){
        Car car = new Car("Tesla", "X", 2022);

        assertThat(car).isInstanceOf(Car.class); // проверка: машина это машина
    }

    @Test
    void carHas4wheel(){
        Car car = new Car("Tesla", "X", 2022);

        assertThat(car.getNumWheels()).isEqualTo(4); // 4 ли колеса у машины
    }

//    @ParameterizedTest
//    @ValueSource(ints = { 2, 4, 6}) // Параметризованный тест, лежат заведомо ложные данные кроме одного истинного
//    void carHasCorrectNumberOfWheels(int numWheels) {
//        Car car = new Car("Tesla", "X", 2022);
//
//        assertThat(car.getNumWheels()).isEqualTo(numWheels); // Проверяем, что кол-во колес равно 4
//    }

    @Test
    void motorcycleHas2wheel(){
        Motorcycle motorcycle = new Motorcycle("Kawasaki", "Hayabusa", 2023);

        assertThat(motorcycle.getNumWheels()).isEqualTo(2); // 2 ли колеса у мотоцикла
    }

//    @ParameterizedTest
//    @ValueSource(ints = { 2, 4, 6}) // Параметризованный тест, лежат заведомо ложные данные кроме одного истинного
//    void motorcycleHasCorrectNumberOfWheels(int numWheels) {
//        Motorcycle motorcycle = new Motorcycle("Kawasaki", "Hayabusa", 2023);
//
//        assertThat(motorcycle.getNumWheels()).isEqualTo(numWheels); // Проверяем, что кол-во колес равно 2
//    }

    @Test
    void carSpeed60TestDrive(){
        Car car = new Car("Tesla", "X", 2022);

        car.testDrive();

        assertThat(car.getSpeed()).isEqualTo(60); // скорость тестового вождения
    }

    @Test
    void motorcycleSpeed75TestDrive(){
        Motorcycle motorcycle = new Motorcycle("Kawasaki", "Hayabusa", 2023);

        motorcycle.testDrive();

        assertThat(motorcycle.getSpeed()).isEqualTo(75); // скорость тестового вождения
    }
    @ParameterizedTest
    @ValueSource(ints = { 2, 4, 6}) // указали здесь возможное кол-во колес
    void motorcycleSpeed75TestDrive2(){
        Motorcycle motorcycle = new Motorcycle("Kawasaki", "Hayabusa", 2023);

        motorcycle.testDrive();

        assertThat(motorcycle.getSpeed()).isEqualTo(75); // скорость тестового вождения
    }

    @Test
    void carParkingTest(){
        Car car = new Car("Tesla", "X", 2022);

        car.testDrive();
        car.park();

        assertThat(car.getSpeed()).isEqualTo(0); // скорость остановленной машины
    }

    @ParameterizedTest
    @MethodSource("provideCars") // то же самое, только мы уже имеем конкретные экземпляры авто
    void shouldParkCarAndSetSpeedToZero(Car car) {
        car.testDrive();
        car.park();

        assertThat(car.getSpeed()).isEqualTo(0);  // скорость остановленных машин
    }

    @Test
    void motorcycleParkingTest(){
        Motorcycle motorcycle = new Motorcycle("Kawasaki", "Hayabusa", 2023);

        motorcycle.testDrive();
        motorcycle.park();

        assertThat(motorcycle.getSpeed()).isEqualTo(0); // скорость остановленного мотоцикла
    }
}
