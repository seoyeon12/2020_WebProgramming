package kr.hs.dgsw.webblog.Protocol;

//enum => 속성 값 정해줄 때
//요청 속성 값 정하기
public enum ResponseType {
    FAIL(0, "명령을 실행하지 못하였습니다."),

    USER_DELETE     (101, "ID [%d]의 사용자를 삭제하였습니다."), //사용자를 삭제했을 때(101)
    USER_ADD        (102, "ID [%d]의 사용자를 추가하였습니다."), //사용자를 추가했을 때(102)
    USER_UPDATE     (103, "ID [%d]의 사용자를 수정하였습니다."), //사용자를 수정했을 때(103)
    USER_GET        (104, "ID [%d]의 사용자를 조회하였습니다."), //사용자를 조회했을 때(105)
    USER_GET_ALL    (105, "전체 사용자를 조회하였습니다."), //사용자 전체를 조회했을 때(105)

    POST_GET        (201, "ID [%d]의 게시글을 조회하였습니다."), //게시글을 조회헀을 때(201)
    POST_DELETE     (202, "ID [%d]의 게시글을 삭제하였습니다."), //게시글을 삭제했을 때(202)
    POST_ADD        (203, "ID [%d]의 게시글을 추가하였습니다."), //게시글을 추가했을 때(203)
    POST_UPDATE     (204, "ID [%d]의 게시글을 수정하였습니다."), //게시글을 수정했을 떄(204)
    POST_GET_ALL    (205, "전체 게시글을 조회하였습니다."), //게시글 전체를 조회했을 때(205)
    POST_GET_BY_USER        (206, "USER ID [%d]의 게시글을 조회하였습니다."), //유저의 게시글을 조회했을 때(206)

    ATTACHMENT_STORED       (301, "이미지를 저장하였습니다."), //이미지를 저장 했을 떄(301)
    ;
     
    final private int code;
    final private String desc;

    ResponseType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int code() {return this.code;}
    public String desc() {return this.desc;}
}