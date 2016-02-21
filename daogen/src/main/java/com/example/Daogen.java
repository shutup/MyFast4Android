package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class Daogen {
    public static void main(String args[]) throws Exception {
        Schema schema = new Schema(1, "com.shutup.db.model");
        schema.setDefaultJavaPackageDao("com.shutup.db.dao");
//        schema.enableKeepSectionsByDefault();
//        schema.enableActiveEntitiesByDefault();
//        ActiveRecord
        addEntity(schema);
        new DaoGenerator().generateAll(schema, "./app/src/main/java-gen");
    }

    private static void addEntity(Schema schema) {
        Entity person = schema.addEntity("Person");
        person.addIdProperty().primaryKey();
        person.addStringProperty("name");
        person.addDoubleProperty("height");
        person.addDoubleProperty("weight");
        Entity card = schema.addEntity("Card");
        card.addIdProperty().primaryKey();
        card.addStringProperty("num");
        card.addStringProperty("address");
        Property idcardPK = person.addLongProperty("cardId").getProperty();
        person.addToOne(card, idcardPK);
        Property personPK = card.addLongProperty("personId").getProperty();
        card.addToOne(person,personPK);
    }
}
