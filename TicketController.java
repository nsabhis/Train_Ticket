package train;

import train.Ticket;
import train.user;
import train.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/purchase")
    public Ticket purchaseTicket(@RequestBody user user) {
        return ticketService.purchaseTicket(user, "London", "France");
    }

    @GetMapping("/receipt")
    public Ticket getReceipt(@RequestParam String email) {
        return ticketService.getTicketForUser(email);
    }

    @GetMapping("/section")
    public List<Ticket> getTicketsBySection(@RequestParam String section) {
        return ticketService.getTicketsBySection(section);
    }

    @DeleteMapping("/remove")
    public void removeUser(@RequestParam String email) {
        ticketService.removeUser(email);
    }

    @PutMapping("/modify")
    public void modifySeat(@RequestParam String email, @RequestParam String newSection) {
        ticketService.modifyUserSeat(email, newSection);
    }
}
