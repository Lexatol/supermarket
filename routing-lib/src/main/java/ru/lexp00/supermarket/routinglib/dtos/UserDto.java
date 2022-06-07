package ru.lexp00.supermarket.routinglib.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private int cashback;
    private List<String> productCommentDtoList;

}
