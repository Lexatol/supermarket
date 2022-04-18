package ru.lexp00.supermarket.mscore.dto.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.lexp00.supermarket.mscore.entities.users.User;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private int cashback;
//    private List<String> productCommentDtoList;

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.cashback = user.getCashback().getBonus();
//        this.productCommentDtoList = user.getProductCommentList().stream().map(ProductComment::getDescription).collect(Collectors.toList());
    }
}
