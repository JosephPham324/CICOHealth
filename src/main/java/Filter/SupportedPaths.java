package Filter;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Pham Nhat Quang CE170036 (FPTU CANTHO)
 */
public class SupportedPaths {

//    private final String[] user_paths = {"/user-exercises", "/user-info", "/user-statistics", "/user-meals", "/healthinfo", "/logout-control"};
    private HashMap<String, String> correspondingReferrer;//Key: servlet, value: referrer

    public SupportedPaths() {
        correspondingReferrer = new HashMap<>();
        correspondingReferrer.put("/login-control", "/login");
        correspondingReferrer.put("/healthinfo-control", "/register-control");
        correspondingReferrer.put("/register-control", "/register");

        correspondingReferrer.put("/create-meal-control", "/search-food");
        correspondingReferrer.put("/edit-meal-control", "/user-meals");
        correspondingReferrer.put("/delete-meal-control", "/user-meals");

        correspondingReferrer.put("/add-exercise-control", "/search-exercise");
        correspondingReferrer.put("/edit-exercise-control", "/search-exercise");
        correspondingReferrer.put("/delete-exercise-control", "/search-exercise");

        correspondingReferrer.put("/login-edit-control", "/user-info");
        correspondingReferrer.put("/edit-user-info-control", "/user-info");
        correspondingReferrer.put("/edit-health-info-control", "/user-info");
        correspondingReferrer.put("/edit-goal-control", "/user-info");
    }

    public boolean availableServlet(String servletPath) {
        return this.correspondingReferrer.containsKey(servletPath);
    }

    public boolean checkCorrectReferrer(String servletPath, String referrerPath) {
        if (referrerPath == null || servletPath == null || !this.correspondingReferrer.containsKey(servletPath)) {
            return false;
        }
        if (servletPath.endsWith("/home-control") || servletPath.endsWith("/logout-control")) {
            return true;
        }
        return referrerPath.endsWith("Nutrition" + this.correspondingReferrer.get(servletPath));
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
}
