package eternal0_1;

import java.util.ArrayList;
import java.util.List;

class CardBoard {
    public static void main(String[] args) {

        ArrayList<List> table = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= 10; j++)
                row.add(i * j);
            table.add(row);
        }
        for (List<Integer> row : table)
            System.out.println(row);
    }

}
