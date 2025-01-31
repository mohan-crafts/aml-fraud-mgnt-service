package com.txn.dto;

public class Transaction {

private Long id;
    
    private Boolean isDeposit;

    private Long amount;

    private Long senderUserId;

    private Boolean isInteracTxn;

    private String receiverUserId;

    private String receiverBankDetails;

    private String receiverLocation;
    
    private String msg;
    
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsDeposit() {
        return isDeposit;
    }

    public void setIsDeposit(Boolean isDeposit) {
        this.isDeposit = isDeposit;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getSenderUserId() {
        return senderUserId;
    }

    public void setSenderUserId(Long senderUserId) {
        this.senderUserId = senderUserId;
    }

    public Boolean getIsInteracTxn() {
        return isInteracTxn;
    }

    public void setIsInteracTxn(Boolean isInteracTxn) {
        this.isInteracTxn = isInteracTxn;
    }

    public String getReceiverUserId() {
        return receiverUserId;
    }

    public void setReceiverUserId(String receiverUserId) {
        this.receiverUserId = receiverUserId;
    }

    public String getReceiverBankDetails() {
        return receiverBankDetails;
    }

    public void setReceiverBankDetails(String receiverBankDetails) {
        this.receiverBankDetails = receiverBankDetails;
    }

    public String getReceiverLocation() {
        return receiverLocation;
    }

    public void setReceiverLocation(String receiverLocation) {
        this.receiverLocation = receiverLocation;
    }
    
    public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", amount='" + amount + '\'' +
                ", senderUserId='" + senderUserId + '\'' +
                ", receiverBankDetails='" + receiverBankDetails + '\'' +
                ", receiverLocation='" + receiverLocation + '\'' +
                ", msg='" + msg + '\'' +
                ", status='" + status + '\'' +
                ", receiverUserId='" + receiverUserId + '\'' +
                '}';
    }

	}
