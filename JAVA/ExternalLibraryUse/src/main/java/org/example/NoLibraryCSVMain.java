package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoLibraryCSVMain {
    public static void main(String[] args) {
        // 문자열 파일을 읽기 위한 스트림 생성
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./volley.csv")))) {
            // 파일의 경로 확인을 위해서 작성
            // System.out.println(br);

            // 첫 줄은 데이터가 아니므로 첫 줄을 배제하기 위한 변수
            boolean flag = false;

            // 파싱한 결과를 저장하기 위한 List
            List<Player> list = new ArrayList<>();

            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                // 첫 줄을 읽지 않기 위해서 작성
                if (flag == false) {
                    flag = true;
                    continue;
                }
//                System.out.println(line);
                //, 단위로 분할
                String[] ar = line.split(",");
//                System.out.println(ar[0]);

                Player player = new Player();
                player.setName(ar[0]);
                player.setAge(Integer.parseInt(ar[1]));
                String birth = ar[2];
                // 위의 문자열을 Date 타입으로 변환해서 대입
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = sdf.parse(birth);
                player.setBirth(date);

                player.setEmail(ar[3]);
                player.setNickname(ar[4]);

                // 리스트에 추가
                list.add(player);
            }

            for (Player player : list) {
                System.out.println(player);
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
