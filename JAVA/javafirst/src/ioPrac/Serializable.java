package ioPrac;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializable {

    public static void main(String[] args) {
        // 인스턴스 단위로 기록할 수 있는 스트림 생성
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sample.dat"))) {
            // 기록된 인스턴스 읽어오기
            // return type이 Object 이므로
            // 기록할 때 사용한 데이터 타입으로 강제 형 변환
            Data data = (Data) ois.readObject();
            System.out.println(data);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
