
package test3;

import static java.util.Arrays.sort;
import java.util.Comparator;
import java.util.Scanner;

public class B {

    static class Data {

        String fatherN;
        String sonN;
        int ageR;
        int ageSon;
    }

    static int cmp(Data a, Data b) {
        if (a.ageSon < b.ageSon) {
            return 0;
        } else if (a.ageSon == b.ageSon) {
            if (a.sonN.compareTo(b.sonN) > 0) {
                return 0;
            }
        }
        return 1;
    }

    static int x;
    static Data[] linkDL = new Data[102];

    static void Dequy(String fth, int kc) {
        for (int i = 1; i <= x; i++) {
            if (fth.equals(linkDL[i].fatherN)) {
                if (fth.equals("Ted")) {
                    linkDL[i].ageSon = 100 - linkDL[i].ageR;
                    kc = 100 - linkDL[i].ageR;
                    Dequy(linkDL[i].sonN, kc);
                } else {
                    linkDL[i].ageSon = kc - linkDL[i].ageR;
                    Dequy(linkDL[i].sonN, kc - linkDL[i].ageR);
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < linkDL.length; i++) {
            linkDL[i] = new Data();
        }
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            x = in.nextInt();
            for (int j = 1; j <= x; j++) {
                linkDL[j].fatherN = in.next();
                linkDL[j].sonN = in.next();
                linkDL[j].ageR = in.nextInt();
            }
            Dequy("Ted", 0);
            try {
                sort(linkDL,1,x+1, new Comparator<Data>() {
                    @Override
                    public int compare(Data a, Data b) {
                        if (a.ageSon > b.ageSon) {
                            return -1;
                        } else if (a.ageSon == b.ageSon) {
                            if (a.sonN.compareTo(b.sonN) < 0) {
                                return -1;
                            }
                            return 0;
                        }
                        return 1;
                    }
                });
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("DATASET " + i);
            for (int k = 1; k <= x; k++) {
                System.out.println(linkDL[k].sonN + " " + linkDL[k].ageSon);
            }
        }
        in.close();
    }
}