package ru.lexp00.supermarket.mscore.dto.users;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfo {
    private Long userId;
    private String role;
}
