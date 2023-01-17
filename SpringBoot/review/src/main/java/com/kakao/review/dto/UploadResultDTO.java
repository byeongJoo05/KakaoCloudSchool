package com.kakao.review.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Data
@AllArgsConstructor
// Serializable(직렬화) : 데이터를 전송할 때 객체 단위로 전송할 수 있도록 해주는 인터페이스
public class UploadResultDTO implements Serializable{
    // 일반속성 - property. 실제로 html에서 부를 때는 getter로 부르는 것
    private String fileName;
    private String uuid;
    private String uploadPath;

    // 실제 이미지 경로를 리턴해주는 메서드
    // 파생속성 - 일반속성은 아니지만 속성처럼 사용하게 되는 함수들.
    public String getImageURL() {
        try{
            return URLEncoder.encode(uploadPath + "/" + uuid + fileName, "UTF-8");
        } catch (UnsupportedEncodingException e){
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
        return "";
    }

    // 썸네일 이미지 경로를 리턴해주는 메서드
    public String getThumbnailURL() {
        try{
            return URLEncoder.encode(uploadPath + "/s_" + uuid + fileName, "UTF-8");
        } catch (UnsupportedEncodingException e){
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
        return "";
    }
}
