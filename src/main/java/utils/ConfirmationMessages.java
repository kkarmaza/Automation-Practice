package utils;

public enum ConfirmationMessages {
    REMOVEITEM("Are you sure you would like to remove this item from the shopping cart?"),
    NOITEMS("You have no items in your shopping cart");

    private final String confirmationMessage;

    ConfirmationMessages(String confirmationMessage) {
        this.confirmationMessage = confirmationMessage;
    }

    public String getConfirmationMessage() {
        return confirmationMessage;
    }
}
