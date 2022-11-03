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
    private HashMap<String, String> correspondingReferer;//Key: servlet, value: referrer

    public SupportedPaths() {
        correspondingReferer = new HashMap<>();
        correspondingReferer.put("/login-control", "/login");
        correspondingReferer.put("/healthinfo-control", "/register-control");
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

    public boolean availableServlet(String servletPath) {
        return this.correspondingReferer.containsKey(servletPath);
    }

    public boolean checkCorrectReferer(String servletPath, String referrerPath) {
        if (referrerPath == null || servletPath == null || !this.correspondingReferer.containsKey(servletPath)) {
            return false;
        }
        if (servletPath.endsWith("/home-control") || servletPath.endsWith("/logout-control")) {
            return true;
        }
        return referrerPath.endsWith("Nutrition" + this.correspondingReferer.get(servletPath));
    }

    public Set<String> listFilesUsingDirectoryStream(String dir) throws IOException {
        Set<String> fileSet = new HashSet<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
            for (Path path : stream) {
                if (!Files.isDirectory(path)) {
                    fileSet.add(path.getFileName()
                            .toString());
                }
            }
        }
        return fileSet;
    }

//    public String[] getUser_paths() {
//        return user_paths;
//    }

    public HashMap<String, String> getCorrespondingReferrer() {
        return correspondingReferer;
    }

//    public static void main(String[] args) {
//        try {
//            System.out.println(new SupportedPaths().listFilesUsingDirectoryStream("scripts"));
//        } catch (IOException ex) {
//            Logger.getLogger(SupportedPaths.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
