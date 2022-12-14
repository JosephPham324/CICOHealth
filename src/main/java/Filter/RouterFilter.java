package Filter;

import DAO.UserDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

/**
 * Semester: FALL 2022
 * Subject : FRJ301
 * Class   : SE1606
 * Project : Nutrition 
 * @author : Group 4
 * CE161130  Nguyen Le Quang Thinh (Leader)
 * CE170036  Pham Nhat Quang
 */
public class RouterFilter implements Filter {

    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    /**
     * Constructor
     */
    public RouterFilter() {
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {

//        Object userID = httpRequest.getSession().getAttribute("userID");
        if (debug) {
            log("RouterFilter:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
	for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    String values[] = request.getParameterValues(name);
	    int n = values.length;
	    StringBuffer buf = new StringBuffer();
	    buf.append(name);
	    buf.append("=");
	    for(int i=0; i < n; i++) {
	        buf.append(values[i]);
	        if (i < n-1)
	            buf.append(",");
	    }
	    log(buf.toString());
	}
         */
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("RouterFilter:DoAfterProcessing");
        }

        // Write code here to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        /*
	for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    Object value = request.getAttribute(name);
	    log("attribute: " + name + "=" + value.toString());
	}
         */
        // For example, a filter might append something to the response.
        /*
	PrintWriter respOut = new PrintWriter(response.getWriter());
	respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    /**
     *
     * Filter link
     * 
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        if (debug) {
            log("RouterFilter:doFilter()");
        }

        doBeforeProcessing(request, response);

        Throwable problem = null;
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            String url = httpRequest.getServletPath();

            if (url.endsWith("/home-control") || url.endsWith("/logout-control") || url.endsWith("/login-control") || url.endsWith("/register-control")) {
                chain.doFilter(request, response);
                return;
            }
            if (url.endsWith(".jsp") && !url.contains("Error404.jsp")) {//Redirect .jsp
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/home-control");
                return;
            }

            Map<String, ServletRegistration> servletRegistrations = (Map) request.getServletContext().getServletRegistrations();//Key: servlet name, value: registration
            boolean acceptedPath = false;
            for (String key : servletRegistrations.keySet()) {
                HashSet<String> path = (HashSet) servletRegistrations.get(key).getMappings();
                if (path.contains(url)) {
                    acceptedPath = true;
                    break;
                }
            }

            if (url.contains("scripts/") || url.contains("css/") || url.contains("image/")) {//To load resources
                acceptedPath = true;
            }

            if (url.contains("Update/") || url.contains("UserProfile/")) {//To load resources
                acceptedPath = true;
            }

            if (!acceptedPath) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/home-control");
                return;
            }

            SupportedPaths paths = new SupportedPaths();
            if (paths.checkAdminPath(url) && httpRequest.getSession().getAttribute("userID") != null) {
//                System.out.println(url);
//                System.out.println((String) httpRequest.getSession().getAttribute("userID"));
                String userID = httpRequest.getSession().getAttribute("userID") + "";
                int userRole = new UserDAO().getRoleIDByUserID(Integer.parseInt(userID));
                if (userRole == 1) {
                    chain.doFilter(request, response);
                    return;
                } else {
                    httpResponse.sendRedirect(httpRequest.getContextPath() + "/home-control");
                    return;
                }
            } else if (paths.checkAdminPath(url) && httpRequest.getSession().getAttribute("userID") == null) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/home-control");
                return;
            }
            if (url.endsWith("control") && (!url.endsWith("home-control"))) {//Redirect if user enters url ending with control
                String referrer = httpRequest.getHeader("referer");
                boolean correctReferrer = paths.checkCorrectReferrer(url, referrer);
//                httpResponse.getWriter().write(correctReferrer + "");
                if (referrer == null || !paths.availableServlet(url)) {
                    String referrerPath = paths.getCorrectReferrer(url);
                    if (referrerPath != null) {
                        httpResponse.sendRedirect(httpRequest.getContextPath() + referrerPath);
                        return;
                    }
                    httpResponse.sendRedirect(httpRequest.getContextPath() + "/home-control");
                    return;
                } else if (!correctReferrer) {
                    httpResponse.sendRedirect(referrer);
                    return;
                }
            }
            chain.doFilter(request, response);
        } catch (Throwable t) {
            // If an exception is thrown somewhere down the filter chain,
            // we still want to execute our after processing, and then
            // rethrow the problem after that.
            problem = t;
            t.printStackTrace();
        }

        doAfterProcessing(request, response);

        // If there was a problem, we want to rethrow it if it is
        // a known type, otherwise log it.
        if (problem != null) {
            if (problem instanceof ServletException) {
                throw (ServletException) problem;
            }
            if (problem instanceof IOException) {
                throw (IOException) problem;
            }
            sendProcessingError(problem, response);
        }

    }

    /**
     * Return the filter configuration object for this filter.
     * @return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     * @param filterConfig filter 
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("RouterFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("RouterFilter()");
        }
        StringBuffer sb = new StringBuffer("RouterFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    /**
     *
     * @param t throw able
     * @return String 
     */
    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    /**
     * Log filter servlet context
     * @param msg String
     */
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
