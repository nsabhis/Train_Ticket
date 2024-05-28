package train;

public class Ticket {
	private String from;
    private String to;
    private double price;
    private String seatSection;
    private user user;

    // Getters and setters

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSeatSection() {
        return seatSection;
    }

    public void setSeatSection(String seatSection) {
        this.seatSection = seatSection;
    }

    public user getuser() {
        return user;
    }

    public void setuser(user user) {
        this.user = user;
    }
}

