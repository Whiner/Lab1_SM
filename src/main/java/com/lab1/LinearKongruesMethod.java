package com.lab1;

import java.util.ArrayList;
import java.util.List;

public class LinearKongruesMethod {
    private int a;
    private int m;
    private int x_a;
    private int n;

    public LinearKongruesMethod(int a, int m, int x_a, int n) {
        this.a = a;
        this.m = m;
        this.x_a = x_a;
        this.n = n;
    }

    public List<Float> getXList() {
        List<Float> x = new ArrayList<>();
        int xPrev = x_a;
        float kcu;
        for (int i = 0; i < n; i++) {
            xPrev = getX(xPrev);
            kcu = getKcu(xPrev);
            System.out.printf("Кси = %5.4f\n", kcu);
            x.add(kcu);
        }
        return x;
    }

    private int getX(int xPrev) {
        //System.out.println("xi = " + v);
        return (a * xPrev) % m;
    }

    public Float getKcu(Integer xi) {
        return (float) xi / (float) m;
    }

    public static int getInterval(float kcu) {
        return (int) (kcu * 10);
    }

    public static float getMathWait(List<Float> list) {
        float sum = 0;
        for (Float f : list) {
            sum += f;
        }
        return sum / list.size();
    }

    public static float getDisp(List<Float> list, Float mathWait){
        float sum = 0;
        for (Float f: list){
            sum += Math.pow(f - mathWait, 2);
        }
        return (float)Math.sqrt(sum / list.size());
    }
}
