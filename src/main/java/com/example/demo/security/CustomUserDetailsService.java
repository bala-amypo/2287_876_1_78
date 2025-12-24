import java.util.HashMap;
import java.util.Map;

public Map<String, Object> registerUser(
        String username,
        String password,
        String email,
        String role) {

    Map<String, Object> map = new HashMap<>();
    map.put("message", "User registered");
    return map;
}
