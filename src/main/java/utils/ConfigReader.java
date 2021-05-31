package utils;

import exceptions.LocalConfFileNotFoundException;
import exceptions.WrongIniFileFormatException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ConfigReader {
    private HashMap<String, String> localConfVars = new HashMap();
    private FileUtils fileUtils;

    public ConfigReader() {
        this.fileUtils = new FileUtils();
        this.loadLocalConf();
    }

    public ConfigReader(String fileNameWithPath) {
        try {
            java.util.Properties props = new java.util.Properties();
            props.load(new FileInputStream(new File(fileNameWithPath)));
            Iterator var3 = props.stringPropertyNames().iterator();

            while(var3.hasNext()) {
                String key = (String)var3.next();
                this.localConfVars.put(key, props.getProperty(key));
            }
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }

    public ConfigReader(String fileNameWithPath, Class classpath) {
        try {
            java.util.Properties props = new java.util.Properties();
            props.load(classpath.getClassLoader().getResourceAsStream(fileNameWithPath));
            Iterator var4 = props.stringPropertyNames().iterator();

            while(var4.hasNext()) {
                String key = (String)var4.next();
                this.localConfVars.put(key, props.getProperty(key));
            }
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }

    public ConfigReader(String fileNameWithPath, Boolean loadEnvVars) {
        this.fileUtils = new FileUtils();
        this.loadLocalConf(fileNameWithPath, loadEnvVars);
    }

    private void loadLocalConf() {
        this.loadLocalConf("project_conf.ini", true);
    }

    private void loadLocalConf(String fileNameWithPath, Boolean loadEnvVars) {
        this.localConfVars.clear();

        try {
            List<String> localConfLines = this.fileUtils.readFileAsList(fileNameWithPath);
            HashMap<String, String> localConfPreVars = this.translateIniFile(localConfLines);
            Iterator var5 = localConfPreVars.entrySet().iterator();

            while(var5.hasNext()) {
                Map.Entry<String, String> localConfVar = (Map.Entry)var5.next();
                this.localConfVars.put(localConfVar.getKey(), localConfVar.getValue());
            }

            if (loadEnvVars) {
                Map<String, String> envVars = System.getenv();
                Iterator var11 = envVars.entrySet().iterator();

                while(var11.hasNext()) {
                    Map.Entry<String, String> envVar = (Map.Entry)var11.next();
                    this.localConfVars.put(((String)envVar.getKey()).replaceFirst("bamboo_", ""), envVar.getValue());
                }
            }
        } catch (WrongIniFileFormatException | IOException var9) {
            try {
                throw new LocalConfFileNotFoundException(fileNameWithPath);
            } catch (LocalConfFileNotFoundException var8) {
                var8.printStackTrace();
            }
        }

    }

    private HashMap<String, String> translateIniFile(List<String> iniFileLines) throws WrongIniFileFormatException {
        HashMap<String, String> iniFileVars = new HashMap();
        Iterator var3 = iniFileLines.iterator();

        while(var3.hasNext()) {
            String iniLine = (String)var3.next();
            if (!iniLine.startsWith("#") && !iniLine.trim().isEmpty()) {
                String[] varLine = iniLine.split("=");

                try {
                    iniFileVars.put(varLine[0].trim(), varLine[1].trim());
                } catch (ArrayIndexOutOfBoundsException var7) {
                    throw new WrongIniFileFormatException();
                }
            }
        }

        return iniFileVars;
    }

    public String getEnvVar(String varName) {
        return this.localConfVars.containsKey(varName) ? (String)this.localConfVars.get(varName) : "Not Found";
    }
}