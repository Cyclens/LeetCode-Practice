import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class reconstructItinerary {
	public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
        	map.put(ticket.get(0), ticket);
        }
        
    }
}
