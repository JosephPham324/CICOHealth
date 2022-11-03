package Filter;

import java.util.HashMap;

/**
 *
 * @author Pham Nhat Quang CE170036 (FPTU CANTHO)
 */
public class Paths {

    private final String[] user_paths = {"/user-exercises", "/user-info", "/user-statistics", "/user-meals", "/healthinfo", "/logout-control"};
    private HashMap<String, String> correspondingReferer;//Key: servlet, value: referrer

    public Paths() {
        correspondingReferer = new HashMap<>();
        correspondingReferer.put("/login-control", "/login");
        correspondingReferer.put("/healthinfo-control", "/healthinfo");
        correspondingReferer.put("/register-control", "/register");

        correspondingReferer.put("/create-meal-control", "/search-food");
        correspondingReferer.put("/edit-meal-control", "/user-meals");
        correspondingReferer.put("/delete-meal-control", "/user-meals");

        correspondingReferer.put("/add-exercise-control", "/search-exercise");
        correspondingReferer.put("/edit-exercise-control", "/search-exercise");
        correspondingReferer.put("/delete-exercise-control", "/search-exercise");

        correspondingReferer.put("/login-edit-control", "/user-info");
        correspondingReferer.put("/edit-user-info-control", "/user-info");
        correspondingReferer.put("/edit-health-info-control", "/user-info");
        correspondingReferer.put("/edit-goal-control", "/user-info");
    }

    public boolean checkCorrectReferer(String servletPath, String referrerPath) {
        if (referrerPath == null || servletPath == null || this.correspondingReferer.get(servletPath) == null) {
            return false;
        }
        if (servletPath.endsWith("home-control")) {
            return true;
        }
        return this.correspondingReferer.get(servletPath).equalsIgnoreCase(referrerPath);
    }

    public String[] getUser_paths() {
        return user_paths;
    }

    public HashMap<String, String> getCorrespondingReferrer() {
        return correspondingReferer;
    }

}
