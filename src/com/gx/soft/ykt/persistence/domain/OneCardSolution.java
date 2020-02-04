package com.gx.soft.ykt.persistence.domain;

import javax.persistence.*;

@Entity
@Table(name = "one_card_solution", schema = "jbxqycy", catalog = "")
public class OneCardSolution {
    private String rowId;
    private String cardNum;
    private String cardHolder;
    private String password;
    private String accountBalance;
    private String createTime;
    private String accountStatus;
    private String userIdCard;
    private String userPhone;

    @Id
    @Column(name = "row_id")
    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    @Basic
    @Column(name = "card_num")
    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    @Basic
    @Column(name = "card_holder")
    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "account_balance")
    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Basic
    @Column(name = "create_time")
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "account_status")
    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Basic
    @Column(name = "user_id_card")
    public String getUserIdCard() {
        return userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    @Basic
    @Column(name = "user_phone")
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OneCardSolution that = (OneCardSolution) o;

        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (cardNum != null ? !cardNum.equals(that.cardNum) : that.cardNum != null) return false;
        if (cardHolder != null ? !cardHolder.equals(that.cardHolder) : that.cardHolder != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (accountBalance != null ? !accountBalance.equals(that.accountBalance) : that.accountBalance != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (accountStatus != null ? !accountStatus.equals(that.accountStatus) : that.accountStatus != null)
            return false;
        if (userIdCard != null ? !userIdCard.equals(that.userIdCard) : that.userIdCard != null) return false;
        if (userPhone != null ? !userPhone.equals(that.userPhone) : that.userPhone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (cardNum != null ? cardNum.hashCode() : 0);
        result = 31 * result + (cardHolder != null ? cardHolder.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (accountBalance != null ? accountBalance.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (accountStatus != null ? accountStatus.hashCode() : 0);
        result = 31 * result + (userIdCard != null ? userIdCard.hashCode() : 0);
        result = 31 * result + (userPhone != null ? userPhone.hashCode() : 0);
        return result;
    }
}
