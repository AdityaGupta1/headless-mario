package  com.devoxx4kids.supermario;

import java.io.*;

public class FileBasedBuilder implements MarioWorldBuilder{


    @Override
    public int[][] build() {

        int[][] world = new int[240][3584];
        InputStream resourceAsStream = FileBasedBuilder.class.getResourceAsStream("/levelOne.txt");
        InputStreamReader in = new InputStreamReader(resourceAsStream);
        try (BufferedReader reader = new BufferedReader(in);
        ){
            String sCurrentLine;
            while ((sCurrentLine = reader.readLine()) != null) {
                String[]s = sCurrentLine.split(" ");
                int type = Integer.valueOf(s[0]);
                int y = Integer.valueOf(s[1]);
                int x = Integer.valueOf(s[2]);

                for(int i= 0; i < 16 ; i++)
                    for(int j= 0; j< 16 ; j++) {
                        world[y+ i][j + x] = type;
                    }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return world;
    }
}
