package com.example.beadndo;

import com.oanda.v20.account.AccountID;
import com.oanda.v20.primitives.AccountUnits;
import com.oanda.v20.primitives.Currency;
import com.oanda.v20.primitives.DateTime;
import com.oanda.v20.transaction.TransactionID;

public class szamlainfo {
    public szamlainfo(AccountID id, String alias, Currency currency, AccountUnits balance, Long createdByUserId, DateTime createdTime, Long openTradeCount, TransactionID lastTransactionID) {
        this.id = id;
        this.alias = alias;
        this.currency = currency;
        this.balance = balance;
        this.createdByUserId = createdByUserId;
        this.createdTime = createdTime;
        this.openTradeCount = openTradeCount;
        this.lastTransactionID = lastTransactionID;
    }

    public AccountID getId() {
        return id;
    }

    public String getAlias() {
        return alias;
    }

    public Currency getCurrency() {
        return currency;
    }

    public AccountUnits getBalance() {
        return balance;
    }

    public Long getCreatedByUserId() {
        return createdByUserId;
    }

    public DateTime getCreatedTime() {
        return createdTime;
    }

    public Long getOpenTradeCount() {
        return openTradeCount;
    }

    public TransactionID getLastTransactionID() {
        return lastTransactionID;
    }

    public AccountID id;
    public String alias;
    public Currency currency;
    public AccountUnits balance;
    public Long createdByUserId;
    public DateTime createdTime;
    public Long openTradeCount;
    public TransactionID lastTransactionID;

}