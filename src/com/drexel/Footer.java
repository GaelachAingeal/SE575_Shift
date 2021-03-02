package com.drexel;

public class Footer {

    public String getFooter () {
        OptionReader.readOptions();
        String footer = OptionReader.getString("footer.enabled");
        String dataString = OptionReader.getString("header.footer");
        String formattedFooter = "\n" + dataString;
        if (footer.equals("true")) {
            return formattedFooter;
        }
        return null;
    }
}
