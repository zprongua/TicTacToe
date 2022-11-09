package rocks.zipcodewilmington.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    String[] hori = new String[3];
    String[] vert = new String[3];
    String[] diag = new String[2];
    ArrayList<String> attempts = new ArrayList<String>();
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
        else return !isInFavorOfX();
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
        for (String attempt : this.attempts) {
            if (attempt.equals(winner)) {
                return true;
            }
        }
        return false;
    }

    public void setVert(Character[][] matrix) {
        //vert = new String[3];
        StringBuilder str = new StringBuilder();
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                str.append(matrix[i][j].toString());
            }
            this.vert[i] = str.toString();
            str = new StringBuilder();
        }
    }

    public void setHori(Character[][] matrix) {
        StringBuilder str = new StringBuilder();
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                 str.append(matrix[j][i].toString());
            }
            this.hori[i] = str.toString();
            str = new StringBuilder();
        }
    }

    public void setDiag(Character[][] matrix) {
        StringBuilder str = new StringBuilder();
        for (int i=0; i<3; i++) {
            str.append(matrix[i][i].toString());
        }
        this.diag[0] = str.toString();
        str = new StringBuilder();
        int i=0;
        for (int j = 2; j >= 0; j--){
            str.append(matrix[j][i].toString());
            i++;
        }
        this.diag[1] = str.toString();
    }

    public void setAttempts() {
        attempts.addAll(Arrays.asList(this.vert));
        attempts.addAll(Arrays.asList(this.hori));
        attempts.addAll(Arrays.asList(this.diag));
    }
}
