package com.shutup.db.model;

import com.shutup.db.dao.DaoSession;
import de.greenrobot.dao.DaoException;

import com.shutup.db.dao.CardDao;
import com.shutup.db.dao.PersonDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "PERSON".
 */
public class Person {

    private Long id;
    private String name;
    private Double height;
    private Double weight;
    private Long cardId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient PersonDao myDao;

    private Card card;
    private Long card__resolvedKey;


    public Person() {
    }

    public Person(Long id) {
        this.id = id;
    }

    public Person(Long id, String name, Double height, Double weight, Long cardId) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.cardId = cardId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPersonDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    /** To-one relationship, resolved on first access. */
    public Card getCard() {
        Long __key = this.cardId;
        if (card__resolvedKey == null || !card__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CardDao targetDao = daoSession.getCardDao();
            Card cardNew = targetDao.load(__key);
            synchronized (this) {
                card = cardNew;
            	card__resolvedKey = __key;
            }
        }
        return card;
    }

    public void setCard(Card card) {
        synchronized (this) {
            this.card = card;
            cardId = card == null ? null : card.getId();
            card__resolvedKey = cardId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
