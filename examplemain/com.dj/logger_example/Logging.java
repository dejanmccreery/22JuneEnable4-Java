package logger_example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Logging {

    /* Loggers
     * - used for outputting information to the console, or usually to a log file when an application is running in production,
     *   this of course differs for a console application
     * - loggers allow for different formatting to be specified when printing to the console
     * - loggers are built into Java since v1.4
     * - loggers use the chain of responsibility command pattern underneath
     */

    //This logger will act as a logger for the class
    // generally each class has its own Logger bc the logger will show what class it's been called from
    private static Logger LOGGER = Logger.getLogger(Logging.class.getName());

    /* Seven logging levels (from highest to least priority):
     * 1. SEVERE
     * 2. WARNING
     * 3. INFO
     * 4. CONFIG
     * 5. FINE
     * 6. FINER
     * 7. FINEST
     *
     * OFF turns logging off, ALL means log all messages.
     *
     * When a log level is set, logs are output for all levels equal to that level or higher.
     *  A log level of WARNING would only output WARNING and SEVERE log messages for example.
     */

    public static void main(String[] args) {
        LOGGER.setLevel(Level.INFO);
    }
    
}
