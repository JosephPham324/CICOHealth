package Filter;

import DAO.ExerciseTypeDAO;
import DAO.UserDAO;
import Entity.ExerciseType;
import Entity.User;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Pham Nhat Quang CE170036 (FPTU CANTHO)
 */
public class SupportedPaths {

//    private final String[] user_paths = {"/user-exercises", "/user-info", "/user-statistics", "/user-meals", "/healthinfo", "/logout-control"};
    private HashMap<String, String> correspondingReferrer;//Key: servlet, value: referrer
    private HashSet<String> adminPaths;

    public SupportedPaths() {

        correspondingReferrer = new HashMap<>();
        adminPaths = new HashSet<>();

        correspondingReferrer.put("/login-control", "/login");
        correspondingReferrer.put("/login-error-control", "/login");
        correspondingReferrer.put("/healthinfo-control", "/register-control");
        correspondingReferrer.put("/register-control", "/register");
        correspondingReferrer.put("/register-error-control", "/register");
        

        correspondingReferrer.put("/create-meal-control", "/search-food");
        correspondingReferrer.put("/edit-meal-control", "/user-meals");
        correspondingReferrer.put("/delete-meal-control", "/user-meals");

        correspondingReferrer.put("/add-exercise-control", "/search-exercise");
        correspondingReferrer.put("/edit-exercise-control", "/user-exercises");
        correspondingReferrer.put("/delete-exercise-control", "/user-exercises");

        correspondingReferrer.put("/login-edit-control", "/user-info");
        correspondingReferrer.put("/edit-user-info-control", "/user-info");
        correspondingReferrer.put("/edit-health-info-control", "/user-info");
        correspondingReferrer.put("/edit-goal-control", "/user-info");

        adminPaths.add("/admin-control");
        adminPaths.add("/admin");
        adminPaths.add("/admin-info");
        adminPaths.add("/adminuser-info");
        adminPaths.add("/adminexercise-info");
        adminPaths.add("/update-healthinfo");
        adminPaths.add("/getuser-exerciseid-control");
        adminPaths.add("/user-load-control");
        adminPaths.add("/admin-load-control");
        adminPaths.add("/delete-user-control");

        adminPaths.add("/admin-exercisetype-control");
        adminPaths.add("/delete-exercisetype-control");
        adminPaths.add("/update-exercisetype-control");
        adminPaths.add("/add-exercisetype-control");
        adminPaths.add("/adminadd-exercise");
        adminPaths.add("/adminupdate-exercise");
        adminPaths.add("/update-control");
        adminPaths.add("/adminupdate-admin");
        adminPaths.add("/adminupdate-user");

        adminPaths.add("/user-exercise");
        adminPaths.add("/user-goal");
        adminPaths.add("/user-healthinfo");
    }

    public boolean availableServlet(String servletPath) {
        return this.correspondingReferrer.containsKey(servletPath);
    }

    public boolean checkCorrectReferrer(String servletPath, String referrerPath) {
        String pattern = "(\\?[a-zA-z]+=.+)";
        System.out.println(servletPath);
        System.out.println(referrerPath);
        servletPath = Pattern.compile(pattern).matcher(servletPath).replaceAll("");
        if (referrerPath != null) {
            referrerPath = Pattern.compile(pattern).matcher(referrerPath).replaceAll("");
        }
        System.out.println(servletPath);
        System.out.println(referrerPath);
        if (referrerPath == null || servletPath == null || !this.correspondingReferrer.containsKey(servletPath)) {
            System.out.println("lol");

            return false;
        }
        if (servletPath.endsWith("/home-control") || servletPath.endsWith("/logout-control") || servletPath.endsWith("/admin-control")) {
            return true;
        }

        return referrerPath.endsWith(this.correspondingReferrer.get(servletPath));
    }

    public String getCorrectReferrer(String servletPath) {
        return this.correspondingReferrer.get(servletPath);
    }

    public boolean checkAdminPath(String path) {
        String pattern = "(\\?[a-zA-z]+=.+)";
        String pattern1 = "(^/*Nutrition)";
        path = Pattern.compile(pattern).matcher(path).replaceAll("");
        path = Pattern.compile(pattern1).matcher(path).replaceAll("");
        return this.adminPaths.contains(path);
    }

    public HashMap<String, String> getCorrespondingReferrer() {
        return correspondingReferrer;
    }

    public static void main(String[] args) {
        SupportedPaths paths = new SupportedPaths();
        System.out.println(paths.checkAdminPath("/Nutrition/admin-control?action=USER+INFO"));
    }
}
