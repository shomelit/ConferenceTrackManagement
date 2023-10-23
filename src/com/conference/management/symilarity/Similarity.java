package com.conference.management.symilarity;
import com.conference.management.talks.Talks;
import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Comparator;

public class Similarity implements Comparator<Talks> {
    @Override
    public int compare(Talks talks1, Talks talks2){

        return (findSimilarity(talks1.getTitle(), talks2.getTitle())>=0.5) ? 1 : -1;
    }

    public static int getLevenshteDistance(String X, String Y)
    {
        int m = X.length();
        int n = Y.length();

        int[][] T = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            T[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            T[0][j] = j;
        }
        int cost;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                cost = X.charAt(i - 1) == Y.charAt(j - 1) ? 0: 1;
                T[i][j] = Integer.min(Integer.min(T[i - 1][j] + 1, T[i][j - 1] + 1),
                        T[i - 1][j - 1] + cost);
            }
        }
        return T[m][n];
    }

    public static double findSimilarity(String x, String y) {
        if (x == null || y == null) {
            throw new IllegalArgumentException("Strings no pueden ser nulos");
        }

        double maxLength = Double.max(x.length(), y.length());
        if (maxLength > 0) {
            return (maxLength - getLevenshteDistance(x, y)) ;
        }
        return 1.0;
    }
}
