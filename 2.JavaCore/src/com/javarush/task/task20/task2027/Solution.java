package com.javarush.task.task20.task2027;

import java.util.LinkedList;
import java.util.List;

/* 
Кроссворд
*/

/*
Хорошее решение
 */
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'e', 'm', 'e', 'm', 'e', 'm'},
                {'h', 's', 'o', 'o', 'o', 'o'},
                {'o', 'm', 'o', 'd', 'o', 'm'},
                {'h', 'h', 'o', 'o', 'o', 'h'},
                {'p', 'm', 'm', 'm', 'h', 'm'}
        };
        detectAllWords(crossword, "dom","home" );
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> allWords = new LinkedList<>();

        for (String word: words) {
            char firstLetter = word.charAt(0);
            for (int i =0 ; i <crossword.length; i++) {
                for (int j = 0; j <crossword[i].length; j++) {

                    // If we find first letter of this word, we check positions of other letters
                    if (crossword[i][j]== firstLetter ){

                        try{
                            allWords.add(checkWord(crossword, word,i,j,0,+1));
                        }catch (Exception e){}

                        try{
                            allWords.add(checkWord(crossword, word,i,j,+1,0));
                        }catch (Exception e){}
                        try{
                            allWords.add(checkWord(crossword, word,i,j,-1,0));
                        }catch (Exception e){}
                        try{
                            allWords.add(checkWord(crossword, word,i,j,0,-1));
                        }catch (Exception e){}
                        try{
                            allWords.add(checkWord(crossword, word,i,j,+1,+1));
                        }catch (Exception e){}
                        try{
                            allWords.add(checkWord(crossword, word,i,j,-1,-1));
                        }catch (Exception e){}
                        try{
                            allWords.add(checkWord(crossword, word,i,j,+1,-1));
                        }catch (Exception e){}
                        try{
                            allWords.add(checkWord(crossword, word,i,j,-1,+1));
                        }catch (Exception e){}

                    }
                }
            }



        }

        return allWords;
    }

    public static Word checkWord(int[][] crossword, String word, int i, int j, int vectorI, int vectorJ) throws Exception {
        int positions[] = new int[4];
        Word wordFirst = new Word(word);

        positions[0] = j;
        positions[1] = i;

        for (int checkLength = 1; checkLength < word.length(); checkLength++) {
            if (word.charAt(checkLength) != crossword[i + vectorI*checkLength][j + vectorJ*checkLength]) {
                throw new Exception();
            }
            if (checkLength == word.length() - 1) {
                positions[3] = i + (vectorI * word.length()) - vectorI;
                positions[2] = j + (vectorJ*word.length()) - vectorJ;
                wordFirst.setStartPoint(positions[0], positions[1]);
                wordFirst.setEndPoint(positions[2], positions[3]);
            }
        }
        return wordFirst;
    }



    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}

/* Моё кривое решение
public class Solution {
    public static void main(String[] args) {

        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> result = detectAllWords(crossword, "home", "same");
        //System.out.println(result.toString());
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        ArrayList<Word> result = new ArrayList<>();
            for (String word : words) {
                for (int y = 0; y < crossword.length; y++) {
                    for (int x = 0; x < crossword[y].length; x++) {
                        if (crossword[y][x] == word.toCharArray()[0]) {
                            //System.out.println((char)crossword[y][x]);
                            //System.out.println(y + ", " + x);
                            Word detectedRight;
                            if ((detectedRight = detectRight(crossword, word, y, x)) != null) {
                                result.add(detectedRight);
                            }
                            Word detectedLeft;
                            if ((detectedLeft = detectLeft(crossword, word, y, x)) != null) {
                                result.add(detectedLeft);
                            }
                            Word detectedUp;
                            if ((detectedUp = detectUp(crossword, word, y, x)) != null) {
                                result.add(detectedUp);
                            }
                            Word detectedDown;
                            if ((detectedDown = detectDown(crossword, word, y, x)) != null) {
                                result.add(detectedDown);
                            }
                            Word detectedRightUp;
                            if ((detectedRightUp = detectRightUp(crossword, word, y, x)) != null) {
                                result.add(detectedRightUp);
                            }
                            Word detectedRightDown;
                            if ((detectedRightDown = detectRightDown(crossword, word, y, x)) != null) {
                                result.add(detectedRightDown);
                            }
                            Word detectedLeftDown;
                            if ((detectedLeftDown = detectLeftDown(crossword, word, y, x)) != null) {
                                result.add(detectedLeftDown);
                            }
                            Word detectedLeftUp;
                            if ((detectedLeftUp = detectLeftUp(crossword, word, y, x)) != null) {
                                result.add(detectedLeftUp);
                            }
                        }
                    }
                }
            }

        return result;
    }

    public static Word detectRight(int[][] crossword, String word, int y, int x) {
        int counter = 0;
        try {
            for (int i = 0; i < word.length(); i++) {
                if (crossword[y][x + i] == word.toCharArray()[i]) {
                    //System.out.println((char)crossword[y][x+i]);
                    //int ver = y;
                    //int hor = x+i;
                    //System.out.println(ver + ", " + hor);
                    counter++;
                }
            }
            //System.out.println(counter);
            if (counter == word.length()) {
                Word detected = new Word(word);
                detected.setStartPoint(x,y);
                detected.setEndPoint(x+word.length()-1, y);
                return detected;
            }
            else return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public static Word detectLeft(int[][] crossword, String word, int y, int x) {
        int counter = 0;
        try {
            for (int i = 0; i < word.length(); i++) {
                if (crossword[y][x - i] == word.toCharArray()[i]) {
                    counter++;
                }
            }
            if (counter == word.length()) {
                Word detected = new Word(word);
                detected.setStartPoint(x,y);
                detected.setEndPoint(x-word.length()+1, y);
                return detected;
            } else return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public static Word detectUp(int[][] crossword, String word, int y, int x) {
        int counter = 0;
        try {
            for (int i = 0; i < word.length(); i++) {
                if (crossword[y-i][x] == word.toCharArray()[i]) {
                    counter++;
                }
            }
            if (counter == word.length()) {
                Word detected = new Word(word);
                detected.setStartPoint(x,y);
                detected.setEndPoint(x, y-word.length()+1);
                return detected;
            } else {
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public static Word detectDown(int[][] crossword, String word, int y, int x) {
        int counter = 0;
        try {
            for (int i = 0; i < word.length(); i++) {
                if (crossword[y+i][x] == word.toCharArray()[i]) {
                    counter++;
                }
            }
            if (counter == word.length()) {
                Word detected = new Word(word);
                detected.setStartPoint(x,y);
                detected.setEndPoint(x, y+word.length()-1);
                return detected;
            } else {
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public static Word detectRightUp(int[][] crossword, String word, int y, int x) {
        int counter = 0;
        try {
            for (int i = 0; i < word.length(); i++) {
                if (crossword[y-i][x+i] == word.toCharArray()[i]) {
                    counter++;
                }
            }
            if (counter == word.length()) {
                Word detected = new Word(word);
                detected.setStartPoint(x,y);
                detected.setEndPoint(x+word.length()-1, y-word.length()+1);
                return detected;
            } else {
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public static Word detectRightDown(int[][] crossword, String word, int y, int x) {
        int counter = 0;
        try {
            for (int i = 0; i < word.length(); i++) {
                if (crossword[y-i][x+i] == word.toCharArray()[i]) {
                    counter++;
                }
            }
            if (counter == word.length()) {
                Word detected = new Word(word);
                detected.setStartPoint(x,y);
                detected.setEndPoint(x+word.length()-1, y+word.length()-1);
                return detected;
            } else {
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public static Word detectLeftDown(int[][] crossword, String word, int y, int x) {
        int counter = 0;
        try {
            for (int i = 0; i < word.length(); i++) {
                if (crossword[y+i][x-i] == word.toCharArray()[i]) {
                    counter++;
                }
            }
            if (counter == word.length()) {
                Word detected = new Word(word);
                detected.setStartPoint(x,y);
                detected.setEndPoint(x-word.length()+1, y+word.length()-1);
                return detected;
            } else {
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public static Word detectLeftUp(int[][] crossword, String word, int y, int x) {
        int counter = 0;
        try {
            for (int i = 0; i < word.length(); i++) {
                if (crossword[y-i][x-i] == word.toCharArray()[i]) {
                    counter++;
                }
            }
            if (counter == word.length()) {
                Word detected = new Word(word);
                detected.setStartPoint(x,y);
                detected.setEndPoint(x-word.length()+1, y-word.length()+1);
                return detected;
            } else {
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
*/
