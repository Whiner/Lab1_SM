package com.lab1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinearKongruesMethod linearKongruesMethod = new LinearKongruesMethod(15133, 27119, 1235, 1000);
        List<Float> xList = linearKongruesMethod.getXList();
        Integer[] count = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (Float f : xList) {
            int interval = LinearKongruesMethod.getInterval(f);
            count[interval]++;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("file.csv"))) {
            int j = 0;
            for (Integer i : count) {
                writer.write(j++ + ";" + i + ";\n");
            }
            float mathWait = LinearKongruesMethod.getMathWait(xList);
            writer.write("\n\nM;" + mathWait + ";\n");
            writer.write("D;" + LinearKongruesMethod.getDisp(xList, mathWait) + ";\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
