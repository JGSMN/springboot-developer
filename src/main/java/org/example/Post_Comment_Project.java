//Post_Comment_Project
//- 게시글 + 댓글 프로그램
//
//=== 요구사항 정리 ===
//        1. 게시글("Post")
//- id: 게시글 고유 번호
//- title: 게시글 제목
//- content: 게시글 내용
//- author: 게시글 작성자
//- comments: 게시글의 댓글 (List 형식)
//
//2. 게시글 기능 정리
//- 게시글 생성(Post)
//- 게시글 조회(Get, 전체 조회)
//- 게시글 조회(Get, 단건 조회 - id 조회)
//- 게시글 수정(Put - title, content 만 수정 가능)
//- 게시글 삭제(Delete)
//
//3. 댓글("Comment")
//- id: 댓글 고유 번호
//- board: 해당 댓글을 작성하는 게시글 정보(POST 클래스 타입)
//- content: 댓글 내용
//- commenter: 댓글 작성자
//
//4. 댓글 기능 정리
//- 댓글 생성(Post)
//- 댓글 조회(Get, 전체 조회 - 해당 게시글의 댓글)
//- 댓글 수정(Put - content 만 수정 가능)
//- 댓글 삭제(Delete)
//
//// 초기 환경 설정 //
//----- 가져올 파일 -----
//entity 폴더 내의 Post, Comment 파일
//dto 폴더 내의 response 폴더 내의 ResponseDto 파일
//springbootdeveloper 폴더 내의 Post_Comment_Project 파일
//
//----- 생성 파일 ------
//controller
//- PostController
//- CommentController
//
//        dto
//- request
//----- PostRequestDto
//----- CommentRequestDto
//- response
//----- PostResponseDto
//----- CommentResponseDto
//
//repository (인터페이스 파일로 생성)
//- PostRepository
//- CommentRepository
//
//        service
//- PostService
//- CommentService