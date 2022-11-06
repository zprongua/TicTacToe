package rocks.zipcodewilmington.tictactoe;

import com.sun.javafx.collections.ElementObservableListDecorator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    String[] hori = new String[3];
    String[] vert = new String[3];
    String[] diag = new String[2];
    ArrayList<String> tryThis = new ArrayList<String>();
    public Board(Character[][] matrix) {
        setHori(matrix);
        setVert(matrix);
        setDiag(matrix);
    }

    public Boolean isInFavorOfX() {
        return whoWon("X");
    }

    public Boolean isInFavorOfO() {
        return whoWon("O");
    }

    public Boolean isTie() {
        if (isInFavorOfO()) {
            return false;
        }
        else if (isInFavorOfX()) {
            return false;
        }
        return true;
    }

    public String getWinner() {
        if (isInFavorOfO()) {
            return "O";
        }
        else if (isInFavorOfX()) {
            return "X";
        }
        return "";
    }

    public boolean whoWon(String player) {
        setAttempts();
        String winner = player+player+player;
        for (String attempt : this.tryThis) {
            if (attempt.equals(winner)) {
                return true;
            }
        }
        return false;
    }

    public void setVert(Character[][] matrix) {
        //vert = new String[3];
        String str = "";
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                str += matrix[i][j].toString();
            }
            this.vert[i] = str;
            str = "";
        }
    }

    public void setHori(Character[][] matrix) {
        String str = "";
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                 str += matrix[j][i].toString();
            }
            this.hori[i] = str;
            str = "";
        }
    }

    public void setDiag(Character[][] matrix) {
        String str = "";
        for (int i=0; i<3; i++) {
            str += (matrix[i][i].toString());
        }
        this.diag[0] = str;
        str = "";
        int i=0;
        for (int j = 2; j >= 0; j--){
            str += (matrix[j][i].toString());
            i++;
        }
        this.diag[1] = str;
    }

    public void setAttempts() {
        tryThis.addAll(Arrays.asList(this.vert));
        tryThis.addAll(Arrays.asList(this.hori));
        tryThis.addAll(Arrays.asList(this.diag));
    }
}
