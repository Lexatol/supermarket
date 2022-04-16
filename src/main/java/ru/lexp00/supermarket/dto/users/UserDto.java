package ru.lexp00.supermarket.dto.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.lexp00.supermarket.entities.users.User;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private int cashback;

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.cashback = user.getCashback().getBonus();
    }
}
