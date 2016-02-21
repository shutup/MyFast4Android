package com.shutup.db.dao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.shutup.db.model.Person;
import com.shutup.db.model.Card;

import com.shutup.db.dao.PersonDao;
import com.shutup.db.dao.CardDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig personDaoConfig;
    private final DaoConfig cardDaoConfig;

    private final PersonDao personDao;
    private final CardDao cardDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        personDaoConfig = daoConfigMap.get(PersonDao.class).clone();
        personDaoConfig.initIdentityScope(type);

        cardDaoConfig = daoConfigMap.get(CardDao.class).clone();
        cardDaoConfig.initIdentityScope(type);

        personDao = new PersonDao(personDaoConfig, this);
        cardDao = new CardDao(cardDaoConfig, this);

        registerDao(Person.class, personDao);
        registerDao(Card.class, cardDao);
    }
    
    public void clear() {
        personDaoConfig.getIdentityScope().clear();
        cardDaoConfig.getIdentityScope().clear();
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    public CardDao getCardDao() {
        return cardDao;
    }

}
