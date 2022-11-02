package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    String[] hori;
    String[] vert;
    String[] diag;
    String[] attempts;
    public Board(Character[][] matrix) {
        this.hori = setHori(matrix);
        this.vert = setVert(matrix);
        this.diag = setDiag(matrix);
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
        if (isInFavorOfX()) {
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
        String winner = player+player+player;
        for (int i=0; i<attempts.length; i++) {
            if (attempts[i].equals(winner)) {
                return true;
            }
        }
        return false;
    }

    public String[] setVert(Character[][] matrix) {
        vert = new String[3];
        String str = "";
        for (int i=0; i<3; i++) {
            for (int j=0; i<3; i++) {
                str += matrix[i][j].toString();
            }
            vert[i] = str;
            str = "";
        }
        return vert;
    }

    public void setHori(Character[][] matrix) {
        hori = new String[3];
        String str = "";
        for (int i=0; i<3; i++) {
            for (int j=0; i<3; i++) {
                 str += matrix[j][i].toString();
            }
            hori[i] = str;
            str = "";
        }
    }

    public void setDiag(Character[][] matrix) {
        diag = new String[2];
        String str = "";
        for (int i=0; i<3; i++) {
            str += (matrix[i][i].toString());
        }
        diag[0] = str;
        for (int i=0; i<3; i++) {
            for (int j = 2; j >= 0; j--){
                str = (matrix[i][i].toString());
            }
        }
        diag[1] = str;
    }

    public String[] getAttempts() {
        attempts = new String[8];
        System.arraycopy(vert, 0, attempts, 0, 3);
        System.arraycopy(hori, 0, attempts, 3, 3);
        System.arraycopy(diag, 0, attempts, 6, 2);
        return attempts;
    }
}
