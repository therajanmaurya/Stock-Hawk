package rajan.udacity.stock.hawk.test.common;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import rajan.udacity.stock.hawk.data.model.multiple.Stocks;

/**
 * Factory class that makes instances of data models with random field values.
 * The aim of this class is to help setting up test fixtures.
 */
public class TestDataFactory {

    public static String randomUuid() {
        return UUID.randomUUID().toString();
    }

    /*public static Stocks makeRibot(String uniqueSuffix) {
        return Stocks.create(makeProfile(uniqueSuffix));
    }*/

    public static List<Stocks> makeListRibots(int number) {
        List<Stocks> ribots = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            //ribots.add(makeRibot(String.valueOf(i)));
        }
        return ribots;
    }

    /*public static Profile makeProfile(String uniqueSuffix) {
        return Profile.builder()
                .setName(makeName(uniqueSuffix))
                .setEmail("email" + uniqueSuffix + "@ribot.co.uk")
                .setDateOfBirth(new Date())
                .setHexColor("#0066FF")
                .setAvatar("http://api.ribot.io/images/" + uniqueSuffix)
                .setBio(randomUuid())
                .build();
    }*/

    /*public static Name makeName(String uniqueSuffix) {
        return Name.create("Name-" + uniqueSuffix, "Surname-" + uniqueSuffix);
    }*/

}