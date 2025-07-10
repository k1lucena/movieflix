package com.movieflix.movieflix.controller;

import com.movieflix.movieflix.controller.request.StreamingRequest;
import com.movieflix.movieflix.controller.response.StreamingResponse;
import com.movieflix.movieflix.entity.Streaming;
import com.movieflix.movieflix.mapper.StreamingMapper;
import com.movieflix.movieflix.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/streaming")
@RequiredArgsConstructor
public class StreamingController {

    private final StreamingService streamingService;


    @GetMapping
    public ResponseEntity<List<StreamingResponse>> getAll() {
        return ResponseEntity.ok(streamingService.findAll()
                .stream()
                .map(StreamingMapper::toStreamingResponse)
                .toList());

    }

    @PostMapping
    public ResponseEntity<StreamingResponse> save(@RequestBody StreamingRequest request) {
        Streaming newStreaming = StreamingMapper.toStreaming(request);
        Streaming streaming = streamingService.save(newStreaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(streaming));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> getById(@PathVariable Long id) {
        return streamingService.findById(id)
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteById(@PathVariable Long id) {
        streamingService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
