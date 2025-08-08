package utils;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {

    public static String gerarId(String prefixo, AtomicInteger contador) {
        return String.format("%s%04d", prefixo, contador.getAndIncrement());
    }
}
