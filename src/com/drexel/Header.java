package com.drexel;

public class Header {

    public String getHeader() {
        OptionReader.readOptions();
        String header = OptionReader.getString("header.enabled");
        String dataString = OptionReader.getString("header.footer");
        String formattedHeader = dataString + "\n";
        if (header.equals("true")) {
            return formattedHeader;
        }
        return null;
    }
}
