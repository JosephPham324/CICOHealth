package Filter;

import java.util.HashMap;

/**
 *
 * @author Pham Nhat Quang CE170036 (FPTU CANTHO)
 */
public class Paths {
    private final String[] user_paths = {"/user-exercises", "/user-info", "/user-statistics", "/user-meals"};
    private HashMap<String,String> correspondingServlet;

    public Paths() {
        correspondingServlet = new HashMap<>();
    }
    
    
}
