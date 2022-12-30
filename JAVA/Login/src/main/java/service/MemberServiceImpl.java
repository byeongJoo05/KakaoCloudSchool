package service;

import domain.MemberVO;
import dto.MemberDTO;
import persistence.MemberDAO;

import java.lang.reflect.Member;

public class MemberServiceImpl implements MemberService{
    // DAO 변수
    private MemberDAO memberDAO;

    private MemberServiceImpl() {
        memberDAO = MemberDAO.getInstance();
    }

    private static MemberService service;

    public static MemberService getInstance() {
        if (service == null) {
            service = new MemberServiceImpl();
        }
        return service;
    }
    @Override
    public MemberDTO login(String mid, String mpw, String uuid) {
        MemberDTO dto = null;
        MemberVO vo = memberDAO.login(mid, mpw);
        // vo를 dto로 변환
        if (vo != null) {
            dto = new MemberDTO();
            dto.setMid(vo.getMid());
            dto.setMname(vo.getMname());
            // UUID 업데이트
            memberDAO.updateUUID(mid, uuid);
        }
        return dto;
    }

    @Override
    public MemberDTO login(String uuid) {
        MemberDTO dto = null;

        MemberVO vo = memberDAO.login(uuid);
        if (vo != null) {
            dto = new MemberDTO();
            dto.setMid(vo.getMid());
            dto.setMname(vo.getMname());
        }

        return dto;
    }
}
