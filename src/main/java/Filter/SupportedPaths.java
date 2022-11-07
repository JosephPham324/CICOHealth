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

    public SupportedPaths() {
//        UserDAO dao = new UserDAO();
//        ExerciseTypeDAO exDAO = new ExerciseTypeDAO();
//        List<User> user = dao.getListUser();
//        List<User> admin = dao.getListAdmin();
//        List<ExerciseType> ex = exDAO.getAllExerciseTypes();

        correspondingReferrer = new HashMap<>();
        correspondingReferrer.put("/login-control", "/login");
        correspondingReferrer.put("/healthinfo-control", "/register-control");
        correspondingReferrer.put("/register-control", "/register");

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

//        for (User o : user) {
//            correspondingReferrer.put("/update-control?id=" + o.getUserID(), "/login");
//            correspondingReferrer.put("/user-healthinfo?id=" + o.getUserID(), "/login");
//            correspondingReferrer.put("/user-goal?id=" + o.getUserID(), "/login");
//        }
//        for (User o : admin) {
//            correspondingReferrer.put("/update-control?id=" + o.getUserID(), "/login");
//        }
//        for (ExerciseType exType : ex) {
//            correspondingReferrer.put("/update-exercisetype?exerciseid=" + exType.getExerciseID(), "/login");
//        }
//        correspondingReferrer.put("/admin", "/login");
//        correspondingReferrer.put("/admin-control?action=ADMIN+INFO", "/login");
//        correspondingReferrer.put("/admin-control?action=USER+INFO", "/login");
//        correspondingReferrer.put("/admin-control?action=EXERCISE+MANAGEMENT", "/login");

        correspondingReferrer.put("/admin-control", "/admin");
        correspondingReferrer.put("/admin", "/admin-admin-control");

        correspondingReferrer.put("/update-healthinfo", "/admin-control");
        correspondingReferrer.put("/user-goal", "/admin-control");

        correspondingReferrer.put("/delete-user-control", "/admin-control");
        correspondingReferrer.put("/getuser-exerciseid-control", "/admin-control");
        correspondingReferrer.put("/user-load-control", "/admin-control");
        correspondingReferrer.put("/user-exercise", "/admin-control");

        correspondingReferrer.put("/admin-exercisetype-control", "/admin-control");
        correspondingReferrer.put("/delete-exercisetype-control", "/admin-control");
        correspondingReferrer.put("/update-exercisetype-control", "/admin-control");
        correspondingReferrer.put("/add-exercisetype-control", "/admin-control");
        correspondingReferrer.put("/adminadd-exercise", "/admin-control");
        correspondingReferrer.put("/update-control", "/admin-control");
    }

    public boolean availableServlet(String servletPath) {
        return this.correspondingReferrer.containsKey(servletPath);
    }

    public boolean checkCorrectReferrer(String servletPath, String referrerPath) {
        String pattern = "(\\?[a-zA-z]+=.+)";
        System.out.println(servletPath);
        System.out.println(referrerPath);
        servletPath = Pattern.compile(pattern).matcher(servletPath).replaceAll("");
        referrerPath = Pattern.compile(pattern).matcher(referrerPath).replaceAll("");
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

//    public Set<String> listFilesUsingDirectoryStream(String dir) throws IOException {
//        Set<String> fileSet = new HashSet<>();
//        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
//            for (Path path : stream) {
//                if (!Files.isDirectory(path)) {
//                    fileSet.add(path.getFileName()
//                            .toString());
//                }
//            }
//        }
//        return fileSet;
//    }
//    public String[] getUser_paths() {
//        return user_paths;
//    }
    public HashMap<String, String> getCorrespondingReferrer() {
        return correspondingReferrer;
    }

//    public static void main(String[] args) {
//        try {
//            System.out.println(new SupportedPaths().listFilesUsingDirectoryStream("scripts"));
//        } catch (IOException ex) {
//            Logger.getLogger(SupportedPaths.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public static void main(String[] args) {
        SupportedPaths paths = new SupportedPaths();
        System.out.println(paths.checkCorrectReferrer("/update-control?id=2", "/admin-control?action=ADMIN+INFO"));
    }
}
