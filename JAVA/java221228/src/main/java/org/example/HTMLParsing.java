package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTMLParsing {
    public static void main(String[] args) {
        // 웹에서 필요한 문자열 가져오기
        // API Server 에서 데이터를 받아오는 부분은 전송방식, 파리미터 부분을 제외하면 동일하다.

        String html = null;
        try {
            // URL 생성
            URL url = new URL("https://www.hani.co.kr/");

            // 다운로드 옵션 설정 -> 전송방식 과 파라미터를 설정한다.
            // URL 이 상위클래스이기 때문에 HttpURLConnection인 하위 클래스 형식으로 다운캐스팅이 가능하다.
            // 최상위 클래스의 요소들을 하위 클래스에도 존재하기 때문에 끼워 넣을 수 있음
            // 반대의 경우는 있을 수도 없을 수도 있기 때문에 불가능하다. (상위 클래스) 인스턴스 = (상위 클래스) 하위 클래스 인스턴스
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");


            // 결과 다운로드
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();

                if(line == null){
                    break;
                }

                stringBuilder.append(line + "\n");
            }
            html = stringBuilder.toString();
//            System.out.println(html);

        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return;
            // System.exit(0);
        }

        // 문자열에서 원하는 데이터를 추출 - Parsing
        // 데이터 형식에 따라 json, xml csv, html에 따라 다르다.
        if(html != null){
            try{
                // html 문자열을 메모리에 DOM 형태로 펼쳐내기
                Document document = Jsoup.parse(html);

                // 태그 가지고 찾기
                Elements elements = document.getElementsByTag("a");

/*                // 태그는 여러개 이므로 순회
                for(int i=0; i<elements.size(); i++){
                    // 한 개 찾아오기
                    Element element = elements.get(i);
                    // 텍스트 확인
//                    System.out.println(element.text());

                    // 속성 확인
                    System.out.println(element.attr("href"));
                }
                */

                // 선택자 이용
                Elements elements1 = document.select("#container");
                for (int i = 0; i < elements1.size(); i++) {
                    Element element = elements.get(i);
                    System.out.println(element.text());
                }

            } catch (Exception e){
                System.out.println(e.getLocalizedMessage());
            }
        }


        // 데이터 사용

    }
}
