package org.example.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import org.example.springbootdeveloper.dto.request.PostRequestDto;
import org.example.springbootdeveloper.dto.response.BookResponseDto;
import org.example.springbootdeveloper.dto.response.CommentResponseDto;
import org.example.springbootdeveloper.dto.response.PostResponseDto;
import org.example.springbootdeveloper.dto.response.ResponseDto;
import org.example.springbootdeveloper.entity.Post;
import org.example.springbootdeveloper.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.example.springbootdeveloper.dto.response.ResponseDto.setFailed;
import static org.example.springbootdeveloper.dto.response.ResponseDto.setSuccess;

@Service
@RequiredArgsConstructor
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public ResponseDto<PostResponseDto> createPost(PostRequestDto dto) {
        try {
            Post post = Post.builder()
                    .title(dto.getTitle())
                    .content(dto.getContent())
                    .author(dto.getAuthor())
                    .build();
            postRepository.save(post);
            return setSuccess("게시글이 정상적으로 등록되었습니다.", convertToPostResponseDto(post));
        } catch (Exception e) {
            return setFailed("게시글 등록 중 오류가 발생했습니다: " + e.getMessage());
        }


    }


    public ResponseDto<List<PostResponseDto>> getAllPosts() {
        List<PostResponseDto> posts = postRepository.findAll()
                .stream()
                .map(this::convertToPostResponseDto)
                .collect(Collectors.toList());
        return setSuccess("성공", posts);

    }

    public ResponseDto<PostResponseDto> getPostById(Long postId) {
        try {
            Post post = postRepository.findById(postId)
                    .orElseThrow(() -> new IllegalAccessError("열심히노력중" + postId));
            return setSuccess("게시글을 id로 가져오는 것을 성공하였습니다.", convertToPostResponseDto(post));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return setFailed("게시글을 id로 가져오는것을 실패하였습니다.");
        }
    }


    public ResponseDto<PostResponseDto> updatePost(Long postId, PostRequestDto updatepost) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 가져올 수 없습니다" + postId));

        post.setTitle(updatepost.getTitle());
        post.setContent(updatepost.getContent());
        post.setAuthor(updatepost.getAuthor());

        Post updatedPost = postRepository.save(post);

        convertToPostResponseDto(updatedPost);
        return setSuccess("성공", convertToPostResponseDto(updatedPost));


    }

    public ResponseDto<Void> deletePost(Long postId) {
        postRepository.deleteById(postId);
        return setSuccess("게시글 삭제 성공", deletePost(Long.valueOf("으에에")).getData());
    }

    private PostResponseDto convertToPostResponseDto(Post post) {
        List<CommentResponseDto> commentDtos = post.getComments().stream()
                .map(comment -> new CommentResponseDto(comment.getId(), post.getId(), comment.getContent(), comment.getCommenter()))
                .collect(Collectors.toList());

        return new PostResponseDto(
                post.getId(), post.getTitle(), post.getContent(), post.getAuthor(), commentDtos
        );
    }
}