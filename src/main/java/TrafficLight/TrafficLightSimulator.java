package TrafficLight;

enum TrafficLightColor {
    RED, GREEN, YELLOW
}

// Автоматизированное управление светофором
class TrafficLightSimulator implements Runnable {
    private Thread thrd; // поток для имитации светофора
    private TrafficLightColor tlc; // текущий цвет светофора
    boolean stop = false; // для остановки имитации установить в true
    boolean changed = false; // true, если светофор переключился

    TrafficLightSimulator(TrafficLightColor init) {
        tlc = init;
        thrd = new Thread(this);
        thrd.start();
    }

    TrafficLightSimulator() {
        tlc = TrafficLightColor.RED;
        thrd = new Thread(this);
        thrd.start();
    }

    // Запуск имитации автоматизированного светофора
    public void run() {
        while (!stop) {
            try {
                switch (tlc) {
                    case GREEN:
                        Thread.sleep(10000); // зеленый на 10 секунд
                        break;
                    case YELLOW:
                        Thread.sleep(2000); // желтый на 2 секунды
                        break;
                    case RED:
                        Thread.sleep(12000); // красный на 12 секунд
                        break;
                }
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
            changeColor();
        }
    }

    // Переключение цвета светофора
    synchronized void changeColor() {
        switch (tlc) {
            case RED:
                tlc = TrafficLightColor.GREEN;
                break;
            case YELLOW:
                tlc = TrafficLightColor.RED;
                break;
            case GREEN:
                tlc = TrafficLightColor.YELLOW;
        }
        changed = true;
        notify(); // уведомить о переключении цвета светофора
    }
    // Ожидание переключения цвета светофора
    synchronized void waitForChange() {
        try {
            while (!changed)
                wait(); // ожидать переключения цвета светофора
            changed = false;
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
    }
    // Возврат текущего цвета
    TrafficLightColor getColor() {
        return tlc;
    }
    // Прекращение имитации светофора
    void cancel() {
        stop = true;
    }
}
