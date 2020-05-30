class Solution {
    
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == word.charAt(0) && searchWord(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean searchWord(char[][] board, String word, int i, int j, int c) {
        if (c == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(c)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = ' ';
        
        if (searchWord(board, word, i+1, j, c+1) || 
            searchWord(board, word, i-1, j, c+1) ||
           searchWord(board, word, i, j+1, c+1) ||
           searchWord(board, word, i, j-1, c+1)) {
            return true;
        }
        board[i][j] = temp;
        return false;
    }
}