package ru.lexp00.supermarket.mscore.dto.users;

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
