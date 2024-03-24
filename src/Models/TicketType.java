package Models;

public enum TicketType {
    VIP,
    USUAL,
    BUDGETARY,
    CHEAP;

    @Override
    public String toString() {
        return "1." + VIP + "\n" + "2." + USUAL + "\n" + "3. " + BUDGETARY + "\n" + "4. " + CHEAP;
    }
}