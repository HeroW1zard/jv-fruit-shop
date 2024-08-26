package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class FruitStorageImpl implements FruitStorage {
    private final Map<String, Integer> storage = new HashMap<>();

    @Override
    public void addFruit(String fruit, int quantity) {
        storage.put(fruit, storage.getOrDefault(fruit, 0) + quantity);
    }

    @Override
    public void setFruit(String fruit, int quantity) {
        storage.put(fruit, quantity);
    }

    @Override
    public void removeFruit(String fruit, int quantity) {
        int currentQuantity = storage.getOrDefault(fruit, 0);
        if (currentQuantity < quantity) {
            throw new IllegalArgumentException("Not enough " + fruit + "in storage");
        }
        storage.put(fruit, currentQuantity - quantity);
    }

    @Override
    public int getFruitQuantity(String fruit) {
        return storage.getOrDefault(fruit, 0);
    }

    @Override
    public Map<String, Integer> getAllFruits() {
        return storage;
    }

}
