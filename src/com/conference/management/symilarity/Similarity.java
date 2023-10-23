package com.conference.management.symilarity;
import com.conference.management.talks.Talks;
import java.util.Comparator;

/**
 * Clase Similarity implements Comparator
 */
public class Similarity implements Comparator<Talks> {
    /***
     * Método sobreescrito para comparar el listado de talks
     * @param talks1 title de talks
     * @param talks2 title de talks
     * @return int indicativo de similitud para ordenamiento
     */
    @Override
    public int compare(Talks talks1, Talks talks2){
        return (findSimilarity(talks1.getTitle(), talks2.getTitle())>=0.5) ? 1 : -1;
    }

    /***
     * Método que calcula de similitud entre dos cadenas de texto
     * @param X String a comparar
     * @param Y String a comparar
     * @return
     */
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

    /***
     * Mètodo de búsqueda de similitudes entre dos cadenas
     * @param x String
     * @param y String
     * @return double similitud
     */
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
