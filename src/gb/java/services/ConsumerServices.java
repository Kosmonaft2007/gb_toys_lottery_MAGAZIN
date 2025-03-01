package services;

import model.Toy;

import java.util.List;
import java.util.Random;

public class ConsumerServices {

    public void getPrize() {
        List<Toy> toyList = DataServices.readData();

        for (Toy toy : toyList) {
            if (toy.getPriority() == priorityValue()) {
                if (toy.getAmount() > 0) {
                    System.out.printf("your prize is %s", toy);
                    toy.setAmount(toy.getAmount() - 1);
                } else {
                    getPrize();
                    toyList.remove(toy);
                    DataServices.reWriteData(toyList);
                }
                return;
            }
        }
    }

    public void getPrizesList() {
        List<Toy> toyList = DataServices.readData();

        for (Toy toy : toyList) {
            System.out.printf("your prize is %s", toy);
        }
    }

    private int priorityValue() {
        int seed = new Random().nextInt(9) + 1;
        return new Random().nextInt(seed + 1);
    }
}