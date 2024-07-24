package com.example;

public class HexColorToRgb {

    /**
     *
     * @param color   #FFAA00   #FA0
     * @return
     */
    public RGB toRgb(String color) {
        if (null== color || color.isEmpty()) return new RGB(0,0,0);

        String r = "";
        String g = "";
        String b = "";

        if (color.length()==4) {
            r+=color.substring(1,2);
            g+=color.substring(2,3);
            b+=color.substring(3,4);
        }

        if (color.length()==7) {
            r+=color.substring(1,3);
            g+=color.substring(3,5);
            b+=color.substring(5,7);
        }

        return new RGB(Integer.parseInt(r,16),Integer.parseInt(g,16),Integer.parseInt(b,16));
    }
}
