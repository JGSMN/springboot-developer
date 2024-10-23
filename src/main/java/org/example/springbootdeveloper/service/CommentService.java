//package org.example.springbootdeveloper.service;
//
//import org.example.springbootdeveloper.dto.request.CommentRequestDto;
//import org.example.springbootdeveloper.dto.response.CommentResponseDto;
//import org.example.springbootdeveloper.dto.response.ResponseDto;
//import org.example.springbootdeveloper.entity.Comment;
//import org.example.springbootdeveloper.entity.Post;
//import org.example.springbootdeveloper.repository.CommentRepository;
//import org.example.springbootdeveloper.repository.PostRepository;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.List;
//
//@Service
//public class CommentService {
//    private final CommentRepository commentRepository;
//    private final PostRepository postRepository;
//
//    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
//        this.commentRepository = commentRepository;
//        this.postRepository = postRepository;
//    }
//
//    public ResponseDto<CommentResponseDto> createComment(CommentRequestDto dto) {
//        try {
//                getPostId getid= postRepository.findById(dto.getPostId(),
//            Comment comment = new Comment(dto.getPostId(), dto.getContent(), dto.getCommenter());
//        } catch (Exception e) {
//            throw new ResponseStatusException(
//                    HttpStatus.BAD_REQUEST,
//                    "Failed to create comment", e
//            );
//
//        }
//    }
//
//    public ResponseDto<List<CommentResponseDto>> getCommentsByPost(Long postId) {
//        return null;
//    }
//
//    public ResponseDto<CommentResponseDto> updateComment(Long commentId, String newContent) {
//        return null;
//    }
//
//    public ResponseDto<Void> deleteComment(Long commentId) {
//        return null;
//    }
//
//    private CommentResponseDto convertToCommentResponseDto(Comment comment) {
//        return new CommentResponseDto(
//                comment.getId(), comment.getPost().getId(), comment.getContent()
//                , comment.getCommenter()
//        );
//    }
//}