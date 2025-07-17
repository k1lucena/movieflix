package com.movieflix.movieflix.controller.request;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(String title,
                           String description,
                           LocalDate releaseDate,
                           double rating,
                           List<Long> categories,
                           List<Long> streaming
                           ) {
}
