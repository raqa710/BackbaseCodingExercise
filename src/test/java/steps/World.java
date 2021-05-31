package steps;

import utils.ConfigReader;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class World {
    public static ConfigReader config = new ConfigReader();
    public static String testEnv = config.getEnvVar("ENV_ID").trim().toUpperCase();
    public static String accessUser = config.getEnvVar("ACCESS_USER_" + testEnv);
    public static String accessPass = config.getEnvVar("ACCESS_PASS_" + testEnv);
    public static String loginUser = config.getEnvVar("LOGIN_USER_" + testEnv);
    public static String loginPass = config.getEnvVar("LOGIN_PASS_" + testEnv);

    public static String testURL = config.getEnvVar("BBLOG_URL_" + testEnv);
    /*public static String testURL = "";

    static {
        try {
            testURL = "https://" + URLEncoder.encode(accessUser, StandardCharsets.UTF_8.toString()) + ":" + URLEncoder.encode(accessPass, StandardCharsets.UTF_8.toString()) + "@" + config.getEnvVar("BBLOG_URL_" + testEnv);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }*/
}
