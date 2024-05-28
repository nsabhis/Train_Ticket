package train;

import train.Ticket;
import train.user;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {
    private List<Ticket> tickets = new ArrayList<>();

    public Ticket purchaseTicket(user user, String from, String to) {
        Ticket ticket = new Ticket();
        ticket.setuser(user);
        ticket.setFrom(from);
        ticket.setTo(to);
        ticket.setPrice(20.0);
        ticket.setSeatSection(assignSeatSection());
        tickets.add(ticket);
        return ticket;
    }

    public Ticket getTicketForUser(String email) {
        return tickets.stream().filter(ticket -> ticket.getuser().getEmail().equals(email)).findFirst().orElse(null);
    }

    public List<Ticket> getTicketsBySection(String section) {
        return tickets.stream().filter(ticket -> ticket.getSeatSection().equals(section)).collect(Collectors.toList());
    }

    public void removeUser(String email) {
        tickets.removeIf(ticket -> ticket.getuser().getEmail().equals(email));
    }

    public void modifyUserSeat(String email, String newSection) {
        tickets.stream().filter(ticket -> ticket.getuser().getEmail().equals(email)).forEach(ticket -> ticket.setSeatSection(newSection));
    }

    private String assignSeatSection() {
        // Simple logic to assign seat sections alternately to A and B
        long countA = tickets.stream().filter(ticket -> "A".equals(ticket.getSeatSection())).count();
        long countB = tickets.stream().filter(ticket -> "B".equals(ticket.getSeatSection())).count();
        return countA <= countB ? "A" : "B";
    }
}